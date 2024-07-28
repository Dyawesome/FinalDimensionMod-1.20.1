package net.expiredicecube.finaldimensionmod.item.client;

import net.expiredicecube.finaldimensionmod.FinalDimensionMod;
import net.expiredicecube.finaldimensionmod.item.custom.SealedBeaconItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SealedBeaconItemModel extends GeoModel<SealedBeaconItem> {
    @Override
    public ResourceLocation getModelResource(SealedBeaconItem sealedBeaconItem) {
        return new ResourceLocation(FinalDimensionMod.MOD_ID, "geo/sealed_beacon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SealedBeaconItem sealedBeaconItem) {
        return new ResourceLocation(FinalDimensionMod.MOD_ID, "textures/item/sealed_beacon.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SealedBeaconItem sealedBeaconItem) {
        return new ResourceLocation(FinalDimensionMod.MOD_ID, "animations/sealed_beacon.animation.json");
    }
}
