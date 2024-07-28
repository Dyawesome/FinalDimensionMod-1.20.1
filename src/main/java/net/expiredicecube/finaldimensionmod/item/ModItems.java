package net.expiredicecube.finaldimensionmod.item;

import net.expiredicecube.finaldimensionmod.FinalDimensionMod;
import net.expiredicecube.finaldimensionmod.block.ModBlocks;
import net.expiredicecube.finaldimensionmod.item.custom.FuelItem;
import net.expiredicecube.finaldimensionmod.item.custom.ImpelloItem;
import net.expiredicecube.finaldimensionmod.item.custom.SealedBeaconItem;
import net.expiredicecube.finaldimensionmod.item.custom.SealedConduitItem;
import net.minecraft.world.item.EnderpearlItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FinalDimensionMod.MOD_ID);

    public static final RegistryObject<Item> BLAZE_FLUID = ITEMS.register("blaze_fluid",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CELESTITE_INGOT = ITEMS.register("celestite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CELESTITE_SPLINTER = ITEMS.register("celestite_splinter",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ECHO_DUST = ITEMS.register("echo_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EMPTY_SEAL = ITEMS.register("empty_seal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ENHANCED_PEARL = ITEMS.register("enhanced_pearl",
            () -> new EnderpearlItem(new Item.Properties()));

    public static final RegistryObject<Item> EXPOSED_WIRE = ITEMS.register("exposed_wire",
            () -> new ItemNameBlockItem(ModBlocks.EXPOSED_WIRE_WIRE.get(), new Item.Properties()));

    public static final RegistryObject<Item> IMPELLO = ITEMS.register("impello",
            ()-> new ImpelloItem(new Item.Properties()));

    public static final RegistryObject<Item> JADE = ITEMS.register("jade",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LITHIUM = ITEMS.register("lithium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OVERITE_INGOT = ITEMS.register("overite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PHANTOM_SILK = ITEMS.register("phantom_silk",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_LITHIUM = ITEMS.register("raw_lithium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SEAL_FRAGMENT = ITEMS.register("seal_fragment",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> AMBROSIA_GEL = ITEMS.register("ambrosia_gel",
            ()-> new Item(new Item.Properties().food(ModFoods.AMBROSIA_GEL)));


    public static final RegistryObject<Item> COKECOAL = ITEMS.register("cokecoal",
            ()-> new FuelItem(new Item.Properties(), 3200));


    public static final RegistryObject<Item> SEALED_CONDUIT = ITEMS.register("sealed_conduit",
            ()-> new SealedConduitItem(new Item.Properties()));

    public static final RegistryObject<Item> SEALED_BEACON = ITEMS.register("sealed_beacon",
            ()-> new SealedBeaconItem(new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
