package net.expiredicecube.finaldimensionmod.datagen;

import net.expiredicecube.finaldimensionmod.FinalDimensionMod;
import net.expiredicecube.finaldimensionmod.block.ModBlocks;
import net.expiredicecube.finaldimensionmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FinalDimensionMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.PORTAL_BLOCKS)
                .add(ModBlocks.GLISTENING_OBSIDIAN.get()).addTag(Tags.Blocks.OBSIDIAN);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LITHIUM_BLOCK.get(),
                     ModBlocks.RAW_LITHIUM_BLOCK.get(),
                     ModBlocks.JADE_BLOCK.get(),
                     ModBlocks.GLISTENING_OBSIDIAN.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LITHIUM_BLOCK.get(),
                     ModBlocks.RAW_LITHIUM_BLOCK.get()
                );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.GLISTENING_OBSIDIAN.get()
                );

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                ;

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.JADE_BLOCK.get()
                );

    }
}
