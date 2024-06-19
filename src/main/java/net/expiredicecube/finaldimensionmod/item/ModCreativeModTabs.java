package net.expiredicecube.finaldimensionmod.item;

import net.expiredicecube.finaldimensionmod.FinalDimensionMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FinalDimensionMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NEW_ITEMS_TAB = CREATIVE_MODE_TABS.register("new_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ECHO_DUST.get()))
                    .title(Component.translatable("creativetab.new_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ECHO_DUST.get());
                        output.accept(ModItems.PHANTOM_SILK.get());
                        output.accept(ModItems.BLAZE_FLUID.get());
                        output.accept(ModItems.EMPTY_SEAL.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
