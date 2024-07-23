package net.expiredicecube.finaldimensionmod.item.client;

import net.expiredicecube.finaldimensionmod.FinalDimensionMod;
import net.expiredicecube.finaldimensionmod.item.custom.ImpelloItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ImpelloItemModel extends GeoModel<ImpelloItem> {
    @Override
    public ResourceLocation getModelResource(ImpelloItem impelloItem) {
        return new ResourceLocation(FinalDimensionMod.MOD_ID, "geo/impello.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ImpelloItem impelloItem) {
        return new ResourceLocation(FinalDimensionMod.MOD_ID, "textures/item/impello.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ImpelloItem impelloItem) {
        return new ResourceLocation(FinalDimensionMod.MOD_ID, "animations/impello.animation.json");
    }
}
