package crab.backport.item;

import crab.backport.CrabsBackport;
import crab.backport.block.CrabsBackportBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CrabsBackportItemGroups {
    public static final ItemGroup CRABS_BACKPORT_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CrabsBackport.MOD_ID, "crabs_backport"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.crabsbackport"))
                    .icon(() -> new ItemStack(CrabsBackportBlocks.CHISELED_COPPER.asItem()))
                    .entries((displayContext, entries) -> {
                        entries.add(CrabsBackportBlocks.WILDFLOWERS);
                        entries.add(CrabsBackportBlocks.FIREFLY_BUSH);
                        entries.add(CrabsBackportBlocks.BUSH);
                        entries.add(CrabsBackportBlocks.SHORT_DRY_GRASS);
                        entries.add(CrabsBackportBlocks.TALL_DRY_GRASS);
                        entries.add(CrabsBackportBlocks.LEAF_LITTER);
                        entries.add(CrabsBackportBlocks.CACTUS_FLOWER);

                        entries.add(CrabsBackportBlocks.PALE_OAK_LOG);
                        entries.add(CrabsBackportBlocks.STRIPPED_PALE_OAK_LOG);
                        entries.add(CrabsBackportBlocks.PALE_OAK_WOOD);
                        entries.add(CrabsBackportBlocks.STRIPPED_PALE_OAK_WOOD);
                        entries.add(CrabsBackportBlocks.PALE_OAK_PLANKS);
                        entries.add(CrabsBackportBlocks.PALE_OAK_LEAVES);
                        entries.add(CrabsBackportBlocks.PALE_OAK_SAPLING);
                        entries.add(CrabsBackportBlocks.PALE_OAK_DOOR);
                        entries.add(CrabsBackportBlocks.PALE_OAK_TRAPDOOR);
                        entries.add(CrabsBackportBlocks.PALE_OAK_FENCE);
                        entries.add(CrabsBackportBlocks.PALE_OAK_FENCE_GATE);
                        entries.add(CrabsBackportBlocks.PALE_OAK_PRESSURE_PLATE);
                        entries.add(CrabsBackportBlocks.PALE_OAK_BUTTON);
                        entries.add(CrabsBackportItems.PALE_OAK_SIGN);
                        entries.add(CrabsBackportItems.PALE_OAK_HANGING_SIGN);
                        entries.add(CrabsBackportBlocks.PALE_OAK_SLAB);
                        entries.add(CrabsBackportBlocks.PALE_OAK_STAIRS);



                        entries.add(CrabsBackportBlocks.ACACIA_SHELF);
                        entries.add(CrabsBackportBlocks.BIRCH_SHELF);
                        entries.add(CrabsBackportBlocks.BAMBOO_SHELF);
                        entries.add(CrabsBackportBlocks.CHERRY_SHELF);
                        entries.add(CrabsBackportBlocks.CRIMSON_SHELF);
                        entries.add(CrabsBackportBlocks.DARK_OAK_SHELF);
                        entries.add(CrabsBackportBlocks.JUNGLE_SHELF);
                        entries.add(CrabsBackportBlocks.OAK_SHELF);
                        entries.add(CrabsBackportBlocks.MANGROVE_SHELF);
                        entries.add(CrabsBackportBlocks.PALE_OAK_SHELF);
                        entries.add(CrabsBackportBlocks.SPRUCE_SHELF);
                        entries.add(CrabsBackportBlocks.WARPED_SHELF);


                        entries.add(CrabsBackportBlocks.TUFF_BRICKS);
                        entries.add(CrabsBackportBlocks.TUFF_BRICK_WALLS);
                        entries.add(CrabsBackportBlocks.TUFF_BRICK_STAIRS);
                        entries.add(CrabsBackportBlocks.TUFF_BRICK_SLAB);
                        entries.add(CrabsBackportBlocks.TUFF_WALLS);
                        entries.add(CrabsBackportBlocks.TUFF_SLAB);
                        entries.add(CrabsBackportBlocks.TUFF_STAIRS);
                        entries.add(CrabsBackportBlocks.POLISHED_TUFF);
                        entries.add(CrabsBackportBlocks.POLISHED_TUFF_STAIRS);
                        entries.add(CrabsBackportBlocks.POLISHED_TUFF_SLAB);
                        entries.add(CrabsBackportBlocks.POLISHED_TUFF_WALLS);
                        entries.add(CrabsBackportBlocks.CHISELED_TUFF);
                        entries.add(CrabsBackportBlocks.CHISELED_TUFF_BRICKS);
                        entries.add(CrabsBackportBlocks.CHISELED_COPPER);
                        entries.add(CrabsBackportBlocks.COPPER_DOOR);
                        entries.add(CrabsBackportBlocks.COPPER_TRAPDOOR);
                        entries.add(CrabsBackportBlocks.COPPER_GRATE);
                        entries.add(CrabsBackportBlocks.COPPER_BULB);
                        entries.add(CrabsBackportBlocks.EXPOSED_CHISELED_COPPER);
                        entries.add(CrabsBackportBlocks.EXPOSED_COPPER_DOOR);
                        entries.add(CrabsBackportBlocks.EXPOSED_COPPER_TRAPDOOR);
                        entries.add(CrabsBackportBlocks.EXPOSED_COPPER_GRATE);
                        entries.add(CrabsBackportBlocks.EXPOSED_COPPER_BULB);
                        entries.add(CrabsBackportBlocks.WEATHERED_CHISELED_COPPER);
                        entries.add(CrabsBackportBlocks.WEATHERED_COPPER_DOOR);
                        entries.add(CrabsBackportBlocks.WEATHERED_COPPER_TRAPDOOR);
                        entries.add(CrabsBackportBlocks.WEATHERED_COPPER_GRATE);
                        entries.add(CrabsBackportBlocks.WEATHERED_COPPER_BULB);
                        entries.add(CrabsBackportBlocks.OXIDIZED_CHISELED_COPPER);
                        entries.add(CrabsBackportBlocks.OXIDIZED_COPPER_DOOR);
                        entries.add(CrabsBackportBlocks.OXIDIZED_COPPER_TRAPDOOR);
                        entries.add(CrabsBackportBlocks.OXIDIZED_COPPER_GRATE);
                        entries.add(CrabsBackportBlocks.OXIDIZED_COPPER_BULB);
                        entries.add(CrabsBackportBlocks.WAXED_CHISELED_COPPER);
                        entries.add(CrabsBackportBlocks.WAXED_COPPER_DOOR);
                        entries.add(CrabsBackportBlocks.WAXED_COPPER_TRAPDOOR);
                        entries.add(CrabsBackportBlocks.WAXED_COPPER_GRATE);
                        entries.add(CrabsBackportBlocks.WAXED_COPPER_BULB);
                        entries.add(CrabsBackportBlocks.WAXED_EXPOSED_CHISELED_COPPER);
                        entries.add(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_DOOR);
                        entries.add(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR);
                        entries.add(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_GRATE);
                        entries.add(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_BULB);
                        entries.add(CrabsBackportBlocks.WAXED_WEATHERED_CHISELED_COPPER);
                        entries.add(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_DOOR);
                        entries.add(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR);
                        entries.add(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_GRATE);
                        entries.add(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_BULB);
                        entries.add(CrabsBackportBlocks.WAXED_OXIDIZED_CHISELED_COPPER);
                        entries.add(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_DOOR);
                        entries.add(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);
                        entries.add(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_GRATE);
                        entries.add(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_BULB);

                        entries.add(CrabsBackportItems.MUSIC_DISC_CREATOR);
                        entries.add(CrabsBackportItems.MUSIC_DISC_CREATOR_MUSIC_BOX);
                        entries.add(CrabsBackportItems.MUSIC_DISC_PRECIPICE);
                        entries.add(CrabsBackportItems.MUSIC_DISC_LAVA_CHICKEN);
                        entries.add(CrabsBackportItems.MUSIC_DISC_TEARS);
                    }).build());


    public static void registerItemGroups() {
        CrabsBackport.LOGGER.info("Registering Item Groups for " + CrabsBackport.MOD_ID);
    }
}
