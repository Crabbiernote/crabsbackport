package crab.backport.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.PlantBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class TallDryGrassBlock extends PlantBlock implements Fertilizable {
    public TallDryGrassBlock(Settings settings) {
        super(settings);
    }


    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(CrabsBackportTags.Blocks.DRY_VEGETATION_MAY_PLACE_ON) || floor.isOf(Blocks.FARMLAND );
    }
    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return BushBlock.canSpread(world, pos, CrabsBackportBlocks.SHORT_DRY_GRASS.getDefaultState());
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BushBlock.findPosToSpreadTo(world, pos, CrabsBackportBlocks.SHORT_DRY_GRASS.getDefaultState())
                .ifPresent(blockPos -> world.setBlockState(blockPos, CrabsBackportBlocks.SHORT_DRY_GRASS.getDefaultState()));

    }
}
