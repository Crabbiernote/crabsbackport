package crab.backport.block;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class CactusFlowerBlock extends PlantBlock {
    private static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 14.0, 12.0, 14.0);
    public CactusFlowerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        BlockState blockState =world.getBlockState(pos);
        return blockState.isOf(Blocks.CACTUS) || blockState.isOf(Blocks.FARMLAND) || blockState.isSideSolid(world, pos, Direction.UP, SideShapeType.CENTER);
    }
}
