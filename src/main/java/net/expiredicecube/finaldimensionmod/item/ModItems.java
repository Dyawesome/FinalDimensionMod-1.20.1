package net.expiredicecube.finaldimensionmod.item;

import net.expiredicecube.finaldimensionmod.FinalDimensionMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FinalDimensionMod.MOD_ID);

    public static final RegistryObject<Item> PHANTOM_SILK = ITEMS.register("phantom_silk",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ECHO_DUST = ITEMS.register("echo_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLAZE_FLUID = ITEMS.register("blaze_fluid",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EMPTY_SEAL = ITEMS.register("empty_seal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ENHANCED_PEARL = ITEMS.register("enhanced_pearl",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EXPOSED_WIRE = ITEMS.register("exposed_wire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SEAL_FRAGMENT = ITEMS.register("seal_fragment",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CELESTITE_INGOT = ITEMS.register("celestite_ingot",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
