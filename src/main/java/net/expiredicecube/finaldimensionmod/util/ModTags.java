package net.expiredicecube.finaldimensionmod.util;

import net.expiredicecube.finaldimensionmod.FinalDimensionMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ELECTRICAL_BLOCKS = tag("electrical_blocks");
        public static final TagKey<Block> PORTAL_BLOCKS = tag("portal_blocks");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(FinalDimensionMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> COMBINABLE_MINERALS_FOR_ARMOR = tag("combinable_minerals_for_armor");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(FinalDimensionMod.MOD_ID, name));
        }
    }
}
