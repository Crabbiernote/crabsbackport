package crab.backport.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class LeafLitterBlock extends FlowerbedBlock {
    public LeafLitterBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return false;
    }
    @Override
    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.down());
        return Block.isFaceFullSquare(blockState.getCollisionShape(world, pos.down()), Direction.UP);
    }
}
