package crab.backport.block;

import crab.backport.CrabsBackport;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CrabsBackportTags {
    public static class Blocks {
        public static final TagKey<Block> DRY_VEGETATION_MAY_PLACE_ON =
                createTag("dry_vegetation_may_place_on");
        public static final TagKey<Block> WOODEN_SHELVES =
                createTag("wooden_shelves");
        public static final TagKey<Block> PALE_OAK_LOGS =
                createTag("pale_oak_logs");

    }

    public static TagKey<Block> createTag(String name) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(CrabsBackport.MOD_ID, name));
    }


    public static class Items {
        public static final TagKey<Item> PALE_OAK_LOGS =
                createTag("pale_oak_logs");
        public static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(CrabsBackport.MOD_ID, name));
        }
    }
}
