package net.expiredicecube.finaldimensionmod.datagen;

import net.expiredicecube.finaldimensionmod.FinalDimensionMod;
import net.expiredicecube.finaldimensionmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FinalDimensionMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.AMBROSIA_GEL);
        simpleItem(ModItems.BLAZE_FLUID);
        simpleItem(ModItems.CELESTITE_INGOT);
        simpleItem(ModItems.CELESTITE_SPLINTER);
        simpleItem(ModItems.COKECOAL);
        simpleItem(ModItems.ECHO_DUST);
        simpleItem(ModItems.EMPTY_SEAL);
        simpleItem(ModItems.ENHANCED_PEARL);
        simpleItem(ModItems.JADE);
        simpleItem(ModItems.LITHIUM);
        simpleItem(ModItems.OVERITE_INGOT);
        simpleItem(ModItems.PHANTOM_SILK);
        simpleItem(ModItems.RAW_LITHIUM);
        simpleItem(ModItems.SEAL_FRAGMENT);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FinalDimensionMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
