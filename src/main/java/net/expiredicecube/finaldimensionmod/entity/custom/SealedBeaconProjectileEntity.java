package net.expiredicecube.finaldimensionmod.entity.custom;

import net.expiredicecube.finaldimensionmod.entity.ModEntities;
import net.expiredicecube.finaldimensionmod.item.ModItems;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class SealedBeaconProjectileEntity extends ThrowableItemProjectile implements ItemSupplier {

    private Item dropItem = Items.BEACON;

    public SealedBeaconProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SealedBeaconProjectileEntity(Level pLevel) {
        super(ModEntities.SEALED_BEACON.get(), pLevel);
    }

    public SealedBeaconProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.SEALED_BEACON.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SEALED_BEACON.get();
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);

        if (!this.level().isClientSide) {

            // Check hit type
            if (result.getType() == HitResult.Type.ENTITY) {
                EntityHitResult entityHitResult = (EntityHitResult) result;
                this.onHitEntity(entityHitResult);
            } else if (result.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockHitResult = (BlockHitResult) result;
                this.onHitBlock(blockHitResult);
            }

            // Drop the item at the projectile's current position
            dropItemEntity();

            // Remove the projectile from the world
            this.discard();
        }
    }

    private void dropItemEntity() {
        ItemStack itemStack = new ItemStack(dropItem);
        // Spawn the item entity at the current position of the projectile
        this.level().addFreshEntity(new net.minecraft.world.entity.item.ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), itemStack));
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        // Additional behavior when hitting a block can be added here

        if (!this.level().isClientSide) {
            // Get the hit position
            double hitX = blockHitResult.getBlockPos().getX();
            double hitY = blockHitResult.getBlockPos().getY();
            double hitZ = blockHitResult.getBlockPos().getZ();

            // Play glass-breaking sound and spawn particles
            this.spawnGlassBreakingEffects(hitX, hitY, hitZ);
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        // Additional behavior when hitting an entity can be added here
        Entity target = entityHitResult.getEntity();

        if (!this.level().isClientSide) {

            if(target instanceof LivingEntity livingEntity) {
                // Apply damage to the entity
                DamageSource damageSource = this.damageSources().thrown(this, this.getOwner());
                target.hurt(damageSource, 5.0F); // Adjust damage value as needed // 5.0F is the damage amount
            }
            this.spawnGlassBreakingEffects(target.getX(), target.getY(), target.getZ());
        }
    }

    // Helper method to spawn particles and play sound
    private void spawnGlassBreakingEffects(double x, double y, double z) {
        // Play glass-breaking sound
        this.level().playSound(null, x, y, z, SoundEvents.GLASS_BREAK, SoundSource.NEUTRAL, 1.0F, 1.0F);

        // Spawn glass block particles
        if (this.level() instanceof ServerLevel serverLevel) {
            BlockParticleOption glassParticle = new BlockParticleOption(ParticleTypes.BLOCK, Blocks.GLASS.defaultBlockState());
            serverLevel.sendParticles(glassParticle, x, y, z, 10, 0.2, 0.2, 0.2, 0.02);
        }
    }
}
