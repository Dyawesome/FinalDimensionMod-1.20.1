package net.expiredicecube.finaldimensionmod.item.client;

import net.expiredicecube.finaldimensionmod.item.custom.SealedBeaconItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SealedBeaconItemRenderer extends GeoItemRenderer<SealedBeaconItem> {
    public SealedBeaconItemRenderer() {
        super(new SealedBeaconItemModel());
    }
}
