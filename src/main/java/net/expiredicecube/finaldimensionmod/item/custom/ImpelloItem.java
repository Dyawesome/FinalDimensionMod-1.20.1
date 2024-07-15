package net.expiredicecube.finaldimensionmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;

public class ImpelloItem extends Item {

    public ImpelloItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW; // Use a bow-like animation when using the item
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000; // Duration in ticks the item can be charged (20 ticks per second)
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        player.startUsingItem(hand); // Start using the item

        // Perform actions when the item is used
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity entity, int chargeTime) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            int chargeDuration = this.getUseDuration(stack) - chargeTime;

            // Example logic to determine charge level (adjust as needed)
            int chargeLevel = chargeDuration / 20; // Divide by 20 to convert ticks to seconds

            // Set the charge level in NBT tag or custom property of ItemStack
            stack.getOrCreateTag().putInt("charged", chargeLevel);

            // Calculate the direction the player is facing
            float yaw = player.getYRot();
            double motionX = Mth.sin(yaw / 180.0F * (float)Math.PI); // Use sin for X direction
            double motionZ = -Mth.cos(yaw / 180.0F * (float)Math.PI); // Use negative cos for Z direction

            // Apply force to push the player backwards
            double pushStrength = 1.5; // Adjust as needed
            player.push(motionX * pushStrength, 0.5, motionZ * pushStrength);

            // Check for collision with blocks
            BlockPos pos = player.blockPosition();
            if (!player.isCreative()) {
                for (int i = 0; i < 5; i++) {
                    BlockPos checkPos = pos.relative(player.getDirection(), i + 1);
                    if (!world.getBlockState(checkPos).isAir()) {
                        break; // Stop checking further if hit a non-air block
                    }
                    player.push(motionX * pushStrength, 0.5, motionZ * pushStrength);
                }
            }

            // Push other mobs and players in the vicinity
            double range = 5.0; // Adjust the range as needed
            for (LivingEntity target : world.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(range))) {
                if (target != player) { // Ensure not pushing the player again
                    double dx = target.getX() - player.getX();
                    double dz = target.getZ() - player.getZ();
                    double distance = Math.sqrt(dx * dx + dz * dz);
                    double strength = 1.5; // Adjust as needed
                    target.push(dx / distance * strength, 0.5, dz / distance * strength);
                }
            }
        }
    }
}