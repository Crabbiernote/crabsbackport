package crab.backport.item;

import crab.backport.CrabsBackport;
import crab.backport.block.CrabsBackportBlocks;
import crab.backport.sound.CrabsBackportSounds;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class CrabsBackportItems {
    public static final Item MUSIC_DISC_LAVA_CHICKEN = registerItem("music_disc_lava_chicken",
            new MusicDiscItem(9,
                    CrabsBackportSounds.LAVA_CHICKEN,
                    new Item.Settings().maxCount(1).rarity(Rarity.RARE),
                    134));
    public static final Item MUSIC_DISC_TEARS = registerItem("music_disc_tears",
            new MusicDiscItem(10,
                    CrabsBackportSounds.TEARS,
                    new Item.Settings().maxCount(1).rarity(Rarity.RARE),
                    175));
    public static final Item MUSIC_DISC_PRECIPICE = registerItem("music_disc_precipice",
            new MusicDiscItem(13,
                    CrabsBackportSounds.PRECIPICE,
                    new Item.Settings().maxCount(1).rarity(Rarity.RARE),
                    299));
    public static final Item MUSIC_DISC_CREATOR = registerItem("music_disc_creator",
            new MusicDiscItem(12,
                    CrabsBackportSounds.CREATOR,
                    new Item.Settings().maxCount(1).rarity(Rarity.RARE),
                    176));
    public static final Item MUSIC_DISC_CREATOR_MUSIC_BOX = registerItem("music_disc_creator_music_box",
            new MusicDiscItem(11,
                    CrabsBackportSounds.CREATOR_MUSIC_BOX,
                    new Item.Settings().maxCount(1).rarity(Rarity.RARE),
                    73));


    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CrabsBackport.MOD_ID, name), item);
    }

    public static void addItemsToNaturalItemsGroup(FabricItemGroupEntries entries) {
        entries.add(CrabsBackportBlocks.WILDFLOWERS);
        entries.add(CrabsBackportBlocks.FIREFLY_BUSH);
        entries.add(CrabsBackportBlocks.BUSH);
        entries.add(CrabsBackportBlocks.SHORT_DRY_GRASS);
        entries.add(CrabsBackportBlocks.TALL_DRY_GRASS);
        entries.add(CrabsBackportBlocks.LEAF_LITTER);
        entries.add(CrabsBackportBlocks.CACTUS_FLOWER);
    }

    public static void addItemsToBuildingBlocksGroup(FabricItemGroupEntries entries) {
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
        entries.add(CrabsBackportBlocks.COPPER_GRATE);
        entries.add(CrabsBackportBlocks.COPPER_DOOR);
        entries.add(CrabsBackportBlocks.COPPER_TRAPDOOR);
        entries.add(CrabsBackportBlocks.EXPOSED_CHISELED_COPPER);
        entries.add(CrabsBackportBlocks.EXPOSED_COPPER_GRATE);
        entries.add(CrabsBackportBlocks.EXPOSED_COPPER_DOOR);
        entries.add(CrabsBackportBlocks.EXPOSED_COPPER_TRAPDOOR);
        entries.add(CrabsBackportBlocks.WEATHERED_CHISELED_COPPER);
        entries.add(CrabsBackportBlocks.WEATHERED_COPPER_GRATE);
        entries.add(CrabsBackportBlocks.WEATHERED_COPPER_DOOR);
        entries.add(CrabsBackportBlocks.WEATHERED_COPPER_TRAPDOOR);
        entries.add(CrabsBackportBlocks.OXIDIZED_CHISELED_COPPER);
        entries.add(CrabsBackportBlocks.OXIDIZED_COPPER_GRATE);
        entries.add(CrabsBackportBlocks.OXIDIZED_COPPER_DOOR);
        entries.add(CrabsBackportBlocks.OXIDIZED_COPPER_TRAPDOOR);
        entries.add(CrabsBackportBlocks.WAXED_CHISELED_COPPER);
        entries.add(CrabsBackportBlocks.WAXED_COPPER_GRATE);
        entries.add(CrabsBackportBlocks.WAXED_COPPER_DOOR);
        entries.add(CrabsBackportBlocks.WAXED_COPPER_TRAPDOOR);
        entries.add(CrabsBackportBlocks.WAXED_EXPOSED_CHISELED_COPPER);
        entries.add(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_GRATE);
        entries.add(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_DOOR);
        entries.add(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR);
        entries.add(CrabsBackportBlocks.WAXED_WEATHERED_CHISELED_COPPER);
        entries.add(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_GRATE);
        entries.add(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_DOOR);
        entries.add(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR);
        entries.add(CrabsBackportBlocks.WAXED_OXIDIZED_CHISELED_COPPER);
        entries.add(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_GRATE);
        entries.add(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_DOOR);
        entries.add(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);

    }

    public static void registerModItems() {
        CrabsBackport.LOGGER.info("Registering Mod Items for " + CrabsBackport.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(CrabsBackportItems::addItemsToNaturalItemsGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(CrabsBackportItems::addItemsToBuildingBlocksGroup);

    }
}
