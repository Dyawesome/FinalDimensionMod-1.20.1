package net.expiredicecube.finaldimensionmod.block;

import net.expiredicecube.finaldimensionmod.FinalDimensionMod;
import net.expiredicecube.finaldimensionmod.block.custom.NexusBlock;
import net.expiredicecube.finaldimensionmod.block.custom.WireBlock;
import net.expiredicecube.finaldimensionmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FinalDimensionMod.MOD_ID);

    public static final RegistryObject<Block> EXPOSED_WIRE_WIRE = BLOCKS.register("exposed_wire_wire",
            () -> new WireBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_WIRE).noCollission().noOcclusion()));

    public static final RegistryObject<Block> GLISTENING_OBSIDIAN = registerBlock("glistening_obsidian",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.GILDED_BLACKSTONE)));

    public static final RegistryObject<Block> JADE_BLOCK = registerBlock("jade_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));

    public static final RegistryObject<Block> LITHIUM_BLOCK = registerBlock("lithium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> RAW_LITHIUM_BLOCK = registerBlock("raw_lithium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));

    public static final RegistryObject<Block> BETA_NEXUS = registerBlock("beta_nexus",
            () -> new RedstoneLampBlock(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));

    /*public static final RegistryObject<Block> NEXUS = registerBlock("nexus",
            () -> new NexusBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));*/


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
