package net.expiredicecube.finaldimensionmod.item.custom;

import net.expiredicecube.finaldimensionmod.item.client.ImpelloItemRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.util.RenderUtils;

import java.util.function.Consumer;

public class ImpelloItem extends Item implements GeoItem {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public ImpelloItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        setUsingItem(itemStack, true);
        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    public void onUseTick(Level world, LivingEntity entity, ItemStack stack, int count) {
        if (!world.isClientSide() && count <= 0) {
            releaseUsing(stack, world, entity, this.getUseDuration(stack) - count);
        }
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity entity, int timeLeft) {
        if (entity instanceof Player player) {
            int chargeDuration = this.getUseDuration(stack) - timeLeft;

            // Custom logic for pushing mobs and player
            pushEntitiesAndPlayer(world, player);

            // Trigger blasting animation
            if (!world.isClientSide()) {
                stack.getOrCreateTag().putBoolean("isBlasting", true);
            }
            setUsingItem(stack, false);
        }
    }

    private void pushEntitiesAndPlayer(Level world, Player player) {
        Vec3 look = player.getLookAngle();
        double range = 5.0;
        double strength = 1.5;

        // Push mobs in the direction the player is facing
        for (LivingEntity target : world.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(range))) {
            if (target != player) {
                Vec3 pushDirection = target.position().subtract(player.position()).normalize().scale(strength);
                target.push(pushDirection.x, 1, pushDirection.z);
            }
        }

        // Push player in the opposite direction
        Vec3 oppositeDirection = look.scale(-strength);
        player.push(oppositeDirection.x, 1, oppositeDirection.z);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 100; // 5 seconds
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.CUSTOM;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::animationPredicate));
    }

    private <E extends GeoAnimatable> PlayState animationPredicate(AnimationState<E> state) {
        if (state.getAnimatable() instanceof ImpelloItem) {
            ImpelloItem animatable = (ImpelloItem) state.getAnimatable();
            ItemStack stack = animatable.getItemStack();

            if (animatable.isUsingItem(stack)) {
                state.getController().setAnimation(RawAnimation.begin().then("charge", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            }

            if (stack.getOrCreateTag().getBoolean("isBlasting")) {
                state.getController().setAnimation(RawAnimation.begin().then("blast", Animation.LoopType.PLAY_ONCE));
                return PlayState.CONTINUE;
            }

        }

        return PlayState.STOP;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    private void setUsingItem(ItemStack stack, boolean isUsing) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putBoolean("isUsingItem", isUsing);
    }

    private boolean isUsingItem(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        return tag.getBoolean("isUsingItem");
    }

    public ItemStack getItemStack() {
        // Return the item stack associated with this item
        return new ItemStack(this);
    }

    @Override
    public double getTick(Object itemStack) {
        return RenderUtils.getCurrentTick();
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private ImpelloItemRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if(this.renderer == null){
                    renderer = new ImpelloItemRenderer();
                }
                return this.renderer;
            }
        });
    }
}