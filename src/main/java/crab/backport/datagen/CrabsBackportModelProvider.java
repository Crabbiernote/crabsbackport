package crab.backport.datagen;

import crab.backport.block.CrabsBackportBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class CrabsBackportModelProvider extends FabricModelProvider {
    public CrabsBackportModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool tuffpool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.TUFF);
        tuffpool.stairs(CrabsBackportBlocks.TUFF_STAIRS);
        tuffpool.wall(CrabsBackportBlocks.TUFF_WALLS);
        tuffpool.slab(CrabsBackportBlocks.TUFF_SLAB);

        BlockStateModelGenerator.BlockTexturePool polishedtuffpool = blockStateModelGenerator.registerCubeAllModelTexturePool(CrabsBackportBlocks.POLISHED_TUFF);
        polishedtuffpool.stairs(CrabsBackportBlocks.POLISHED_TUFF_STAIRS);
        polishedtuffpool.wall(CrabsBackportBlocks.POLISHED_TUFF_WALLS);
        polishedtuffpool.slab(CrabsBackportBlocks.POLISHED_TUFF_SLAB);
        BlockStateModelGenerator.BlockTexturePool tuffbrickpool = blockStateModelGenerator.registerCubeAllModelTexturePool(CrabsBackportBlocks.TUFF_BRICKS);
        tuffbrickpool.stairs(CrabsBackportBlocks.TUFF_BRICK_STAIRS);
        tuffbrickpool.wall(CrabsBackportBlocks.TUFF_BRICK_WALLS);
        tuffbrickpool.slab(CrabsBackportBlocks.TUFF_BRICK_SLAB);

        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.WEATHERED_CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.EXPOSED_CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.OXIDIZED_CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.WAXED_CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.WAXED_EXPOSED_CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.WAXED_OXIDIZED_CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.WAXED_WEATHERED_CHISELED_COPPER);
        blockStateModelGenerator.registerTrapdoor(CrabsBackportBlocks.COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(CrabsBackportBlocks.WAXED_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(CrabsBackportBlocks.EXPOSED_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(CrabsBackportBlocks.OXIDIZED_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(CrabsBackportBlocks.WEATHERED_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerDoor(CrabsBackportBlocks.COPPER_DOOR);
        blockStateModelGenerator.registerDoor(CrabsBackportBlocks.WAXED_COPPER_DOOR);
        blockStateModelGenerator.registerDoor(CrabsBackportBlocks.EXPOSED_COPPER_DOOR);
        blockStateModelGenerator.registerDoor(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_DOOR);
        blockStateModelGenerator.registerDoor(CrabsBackportBlocks.OXIDIZED_COPPER_DOOR);
        blockStateModelGenerator.registerDoor(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_DOOR);
        blockStateModelGenerator.registerDoor(CrabsBackportBlocks.WEATHERED_COPPER_DOOR);
        blockStateModelGenerator.registerDoor(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_DOOR);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.COPPER_GRATE);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.WAXED_COPPER_GRATE);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.EXPOSED_COPPER_GRATE);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_GRATE);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.OXIDIZED_COPPER_GRATE);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_GRATE);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.WEATHERED_COPPER_GRATE);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_GRATE);



    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
