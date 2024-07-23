package net.expiredicecube.finaldimensionmod.item.client;

import net.expiredicecube.finaldimensionmod.FinalDimensionMod;
import net.expiredicecube.finaldimensionmod.item.custom.SealedConduitItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SealedConduitItemModel extends GeoModel<SealedConduitItem> {
    @Override
    public ResourceLocation getModelResource(SealedConduitItem sealedConduitItem) {
        return new ResourceLocation(FinalDimensionMod.MOD_ID, "geo/sealed_conduit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SealedConduitItem sealedConduitItem) {
        return new ResourceLocation(FinalDimensionMod.MOD_ID, "textures/item/sealed_conduit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SealedConduitItem sealedConduitItem) {
        return new ResourceLocation(FinalDimensionMod.MOD_ID, "animations/sealed_conduit.animation.json");
    }
}
