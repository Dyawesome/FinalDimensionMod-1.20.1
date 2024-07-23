package net.expiredicecube.finaldimensionmod.item.client;

import net.expiredicecube.finaldimensionmod.item.custom.ImpelloItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ImpelloItemRenderer extends GeoItemRenderer<ImpelloItem> {
    public ImpelloItemRenderer() {
        super(new ImpelloItemModel());
    }
}
