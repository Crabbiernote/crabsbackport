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
        addDrop(CrabsBackportBlocks.OAK_SHELF);
        addDrop(CrabsBackportBlocks.ACACIA_SHELF);
        addDrop(CrabsBackportBlocks.BAMBOO_SHELF);
        addDrop(CrabsBackportBlocks.BIRCH_SHELF);
        addDrop(CrabsBackportBlocks.CHERRY_SHELF);
        addDrop(CrabsBackportBlocks.CRIMSON_SHELF);
        addDrop(CrabsBackportBlocks.DARK_OAK_SHELF);
        addDrop(CrabsBackportBlocks.JUNGLE_SHELF);
        addDrop(CrabsBackportBlocks.MANGROVE_SHELF);
        addDrop(CrabsBackportBlocks.PALE_OAK_SHELF);
        addDrop(CrabsBackportBlocks.SPRUCE_SHELF);
        addDrop(CrabsBackportBlocks.WARPED_SHELF);


    }
}
