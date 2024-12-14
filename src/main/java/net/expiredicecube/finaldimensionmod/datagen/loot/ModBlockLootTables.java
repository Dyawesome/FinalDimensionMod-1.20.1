package net.expiredicecube.finaldimensionmod.datagen.loot;

import net.expiredicecube.finaldimensionmod.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.JADE_BLOCK.get());
        this.dropSelf(ModBlocks.LITHIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_LITHIUM_BLOCK.get());
        this.dropSelf(ModBlocks.EXPOSED_WIRE_WIRE.get());
        this.dropSelf(ModBlocks.BETA_NEXUS.get());
        this.dropSelf(ModBlocks.GLISTENING_OBSIDIAN.get());


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
