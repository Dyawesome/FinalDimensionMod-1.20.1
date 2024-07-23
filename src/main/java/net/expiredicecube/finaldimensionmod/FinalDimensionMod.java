package net.expiredicecube.finaldimensionmod;

import com.mojang.logging.LogUtils;
import net.expiredicecube.finaldimensionmod.block.ModBlocks;
import net.expiredicecube.finaldimensionmod.entity.ModEntities;
import net.expiredicecube.finaldimensionmod.item.ModCreativeModTabs;
import net.expiredicecube.finaldimensionmod.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FinalDimensionMod.MOD_ID)
public class FinalDimensionMod {
    public static final String MOD_ID = "finaldimensionmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FinalDimensionMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.BLAZE_FLUID);
            event.accept(ModItems.CELESTITE_INGOT);
            event.accept(ModItems.CELESTITE_SPLINTER);
            event.accept(ModItems.ECHO_DUST);
            event.accept(ModItems.EMPTY_SEAL);
            event.accept(ModItems.ENHANCED_PEARL);
            event.accept(ModItems.EXPOSED_WIRE);
            event.accept(ModItems.JADE);
            event.accept(ModItems.OVERITE_INGOT);
            event.accept(ModItems.PHANTOM_SILK);
            event.accept(ModItems.RAW_LITHIUM);
            event.accept(ModItems.SEAL_FRAGMENT);
            event.accept(ModItems.IMPELLO);

            event.accept(ModItems.AMBROSIA_GEL);

            event.accept(ModItems.COKECOAL);

            event.accept(ModItems.SEALED_CONDUIT);

            event.accept(ModBlocks.GLISTENING_OBSIDIAN);
            event.accept(ModBlocks.JADE_BLOCK);
            event.accept(ModBlocks.LITHIUM_BLOCK);
            event.accept(ModBlocks.RAW_LITHIUM_BLOCK);

        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntities.SEALED_CONDUIT.get(), ThrownItemRenderer::new);

        }
    }
}
