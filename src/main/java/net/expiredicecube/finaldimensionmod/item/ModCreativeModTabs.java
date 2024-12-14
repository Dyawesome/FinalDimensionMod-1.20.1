package net.expiredicecube.finaldimensionmod.item;

import net.expiredicecube.finaldimensionmod.FinalDimensionMod;
import net.expiredicecube.finaldimensionmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FinalDimensionMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NEW_ITEMS_TAB = CREATIVE_MODE_TABS.register("new_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ENHANCED_PEARL.get()))
                    .title(Component.translatable("creativetab.new_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BLAZE_FLUID.get());
                        output.accept(ModItems.CELESTITE_INGOT.get());
                        output.accept(ModItems.CELESTITE_SPLINTER.get());
                        output.accept(ModItems.ECHO_DUST.get());
                        output.accept(ModItems.EMPTY_SEAL.get());
                        output.accept(ModItems.ENHANCED_PEARL.get());
                        output.accept(ModItems.EXPOSED_WIRE.get());
                        output.accept(ModItems.IMPELLO.get());
                        output.accept(ModItems.JADE.get());
                        output.accept(ModItems.LITHIUM.get());
                        output.accept(ModItems.OVERITE_INGOT.get());
                        output.accept(ModItems.PHANTOM_SILK.get());
                        output.accept(ModItems.RAW_LITHIUM.get());
                        output.accept(ModItems.SEAL_FRAGMENT.get());

                        output.accept(ModItems.AMBROSIA_GEL.get());

                        output.accept(ModItems.COKECOAL.get());

                        output.accept(ModItems.SEALED_CONDUIT.get());
                        output.accept(ModItems.SEALED_BEACON.get());

                        output.accept(ModBlocks.GLISTENING_OBSIDIAN.get());
                        output.accept(ModBlocks.JADE_BLOCK.get());
                        output.accept(ModBlocks.LITHIUM_BLOCK.get());
                        output.accept(ModBlocks.RAW_LITHIUM_BLOCK.get());
                        output.accept(ModBlocks.BETA_NEXUS.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
