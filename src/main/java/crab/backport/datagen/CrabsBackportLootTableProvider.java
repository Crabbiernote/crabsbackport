package crab.backport.datagen;

import crab.backport.block.CrabsBackportBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class CrabsBackportLootTableProvider extends FabricBlockLootTableProvider {
    public CrabsBackportLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        addDrop(CrabsBackportBlocks.POLISHED_TUFF);
        addDrop(CrabsBackportBlocks.CHISELED_TUFF);
        addDrop(CrabsBackportBlocks.TUFF_BRICKS);
        addDrop(CrabsBackportBlocks.CHISELED_TUFF_BRICKS);
        addDrop(CrabsBackportBlocks.TUFF_WALLS);
        addDrop(CrabsBackportBlocks.TUFF_STAIRS);
        addDrop(CrabsBackportBlocks.POLISHED_TUFF_WALLS);
        addDrop(CrabsBackportBlocks.POLISHED_TUFF_STAIRS);
        addDrop(CrabsBackportBlocks.TUFF_BRICK_WALLS);
        addDrop(CrabsBackportBlocks.TUFF_BRICK_STAIRS);
        addDrop(CrabsBackportBlocks.CHISELED_COPPER);
        addDrop(CrabsBackportBlocks.WEATHERED_CHISELED_COPPER);
        addDrop(CrabsBackportBlocks.EXPOSED_CHISELED_COPPER);
        addDrop(CrabsBackportBlocks.OXIDIZED_CHISELED_COPPER);
        addDrop(CrabsBackportBlocks.COPPER_TRAPDOOR);
        addDrop(CrabsBackportBlocks.WAXED_COPPER_TRAPDOOR);
        addDrop(CrabsBackportBlocks.EXPOSED_COPPER_TRAPDOOR);
        addDrop(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR);
        addDrop(CrabsBackportBlocks.OXIDIZED_COPPER_TRAPDOOR);
        addDrop(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);
        addDrop(CrabsBackportBlocks.WEATHERED_COPPER_TRAPDOOR);
        addDrop(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR);
        addDrop(CrabsBackportBlocks.COPPER_GRATE);
        addDrop(CrabsBackportBlocks.WAXED_COPPER_GRATE);
        addDrop(CrabsBackportBlocks.EXPOSED_COPPER_GRATE);
        addDrop(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_GRATE);
        addDrop(CrabsBackportBlocks.OXIDIZED_COPPER_GRATE);
        addDrop(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_GRATE);
        addDrop(CrabsBackportBlocks.WEATHERED_COPPER_GRATE);
        addDrop(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_GRATE);

        addDrop(CrabsBackportBlocks.FIREFLY_BUSH);
        addDropWithSilkTouch(CrabsBackportBlocks.BUSH);
        dropsWithShears(CrabsBackportBlocks.BUSH);
        addDropWithSilkTouch(CrabsBackportBlocks.SHORT_DRY_GRASS);
        dropsWithShears(CrabsBackportBlocks.SHORT_DRY_GRASS);
        dropsWithShears(CrabsBackportBlocks.TALL_DRY_GRASS);
        addDropWithSilkTouch(CrabsBackportBlocks.TALL_DRY_GRASS);

        addDrop(CrabsBackportBlocks.TUFF_SLAB, slabDrops(CrabsBackportBlocks.TUFF_SLAB));
        addDrop(CrabsBackportBlocks.POLISHED_TUFF_SLAB, slabDrops(CrabsBackportBlocks.POLISHED_TUFF_SLAB));
        addDrop(CrabsBackportBlocks.TUFF_BRICK_SLAB, slabDrops(CrabsBackportBlocks.TUFF_BRICK_SLAB));

        addDrop(CrabsBackportBlocks.LEAF_LITTER, flowerbedDrops(CrabsBackportBlocks.LEAF_LITTER));
        addDrop(CrabsBackportBlocks.WILDFLOWERS, flowerbedDrops(CrabsBackportBlocks.WILDFLOWERS));

        addDrop(CrabsBackportBlocks.COPPER_DOOR, doorDrops(CrabsBackportBlocks.COPPER_DOOR));
        addDrop(CrabsBackportBlocks.WAXED_COPPER_DOOR, doorDrops(CrabsBackportBlocks.WAXED_COPPER_DOOR));
        addDrop(CrabsBackportBlocks.EXPOSED_COPPER_DOOR, doorDrops(CrabsBackportBlocks.EXPOSED_COPPER_DOOR));
        addDrop(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_DOOR, doorDrops(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_DOOR));
        addDrop(CrabsBackportBlocks.OXIDIZED_COPPER_DOOR, doorDrops(CrabsBackportBlocks.OXIDIZED_COPPER_DOOR));
        addDrop(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_DOOR, doorDrops(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_DOOR));
        addDrop(CrabsBackportBlocks.WEATHERED_COPPER_DOOR, doorDrops(CrabsBackportBlocks.WEATHERED_COPPER_DOOR));
        addDrop(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_DOOR, doorDrops(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_DOOR));




    }
}
