package net.expiredicecube.finaldimensionmod.item.client;

import net.expiredicecube.finaldimensionmod.item.custom.SealedConduitItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SealedConduitItemRenderer extends GeoItemRenderer<SealedConduitItem> {
    public SealedConduitItemRenderer() {
        super(new SealedConduitItemModel());
    }
}
