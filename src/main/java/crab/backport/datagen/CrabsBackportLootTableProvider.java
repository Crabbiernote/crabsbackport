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
        addDrop(CrabsBackportBlocks.PALE_OAK_LOG);
        addDrop(CrabsBackportBlocks.STRIPPED_PALE_OAK_LOG);
        addDrop(CrabsBackportBlocks.PALE_OAK_WOOD);
        addDrop(CrabsBackportBlocks.STRIPPED_PALE_OAK_WOOD);
        addDrop(CrabsBackportBlocks.PALE_OAK_PLANKS);
        addDrop(CrabsBackportBlocks.PALE_OAK_LEAVES, leavesDrops(CrabsBackportBlocks.PALE_OAK_LEAVES, CrabsBackportBlocks.PALE_OAK_SAPLING, 0.05F, 0.0625F, 0.083333336F, 0.1F));
        addDrop(CrabsBackportBlocks.PALE_OAK_SIGN);
        addDrop(CrabsBackportBlocks.PALE_OAK_SAPLING);
        addDrop(CrabsBackportBlocks.PALE_OAK_HANGING_SIGN);
        addDrop(CrabsBackportBlocks.PALE_OAK_TRAPDOOR);
        doorDrops(CrabsBackportBlocks.PALE_OAK_DOOR);
        addDrop(CrabsBackportBlocks.PALE_OAK_FENCE);
        addDrop(CrabsBackportBlocks.PALE_OAK_FENCE_GATE);
        addDrop(CrabsBackportBlocks.PALE_OAK_STAIRS);
        slabDrops(CrabsBackportBlocks.PALE_OAK_SLAB);
        addDrop(CrabsBackportBlocks.PALE_OAK_BUTTON);
        addDrop(CrabsBackportBlocks.PALE_OAK_PRESSURE_PLATE);
        addPottedPlantDrops(CrabsBackportBlocks.POTTED_PALE_OAK_SAPLING);

    }
}
