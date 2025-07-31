package crab.backport.block;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.List;
import java.util.Optional;

public class BushBlock extends PlantBlock implements Fertilizable {
    public BushBlock(Settings settings) {
        super(settings);
    }

    public static VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return canSpread(world, pos, state);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        findPosToSpreadTo(world, pos, state).ifPresent(posx -> world.setBlockState(posx, this.getDefaultState()));
    }

    static boolean canSpread(WorldView world, BlockPos pos, BlockState state) {
        return findPosToSpreadTo(Direction.Type.HORIZONTAL.stream().toList(), world, pos, state).isPresent();
    }

    static Optional<BlockPos> findPosToSpreadTo(World world, BlockPos pos, BlockState state) {
        return findPosToSpreadTo(Direction.Type.HORIZONTAL.getShuffled(world.random), world, pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    private static Optional<BlockPos> findPosToSpreadTo(List<Direction> directions, WorldView world, BlockPos pos, BlockState state) {
        for (Direction direction : directions) {
            BlockPos blockPos = pos.offset(direction);
            if (world.isAir(blockPos) && state.canPlaceAt(world, blockPos)) {
                return Optional.of(blockPos);
            }
        }

        return Optional.empty();
    }

}
