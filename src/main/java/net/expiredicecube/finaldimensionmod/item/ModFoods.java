package net.expiredicecube.finaldimensionmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties AMBROSIA_GEL = new FoodProperties.Builder().nutrition(8).fast()
            .saturationMod(0.2f).effect(()-> new MobEffectInstance(MobEffects.JUMP,200), 0.1f).build();
}
