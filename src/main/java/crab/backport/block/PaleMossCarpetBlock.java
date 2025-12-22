package crab.backport.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import crab.backport.util.CrabsBackportVoxelUtil;
import net.minecraft.block.*;
import net.minecraft.block.enums.WallShape;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Function;

public class PaleMossCarpetBlock extends Block implements Fertilizable {
    public PaleMossCarpetBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {

    }
//    TODO: Re-implement Pale Moss Carpet, i really cant be bothered rn its such a small part of it
//    public static final BooleanProperty BOTTOM = Properties.BOTTOM;
//    public static final EnumProperty<WallShape> NORTH = Properties.NORTH_WALL_SHAPE;
//    public static final EnumProperty<WallShape> EAST = Properties.EAST_WALL_SHAPE;
//    public static final EnumProperty<WallShape> SOUTH = Properties.SOUTH_WALL_SHAPE;
//    public static final EnumProperty<WallShape> WEST = Properties.WEST_WALL_SHAPE;
//    public static final Map<Direction, EnumProperty<WallShape>> WALL_SHAPE_PROPERTIES_BY_DIRECTION = ImmutableMap.copyOf(
//            Maps.newEnumMap(Map.of(Direction.NORTH, NORTH, Direction.EAST, EAST, Direction.SOUTH, SOUTH, Direction.WEST, WEST))
//    );
//    private final Function<BlockState, VoxelShape> shapeFunction;
//    public PaleMossCarpetBlock(Settings settings) {
//        super(settings);
//        this.setDefaultState(
//                this.stateManager
//                        .getDefaultState()
//                        .with(BOTTOM, true)
//                        .with(NORTH, WallShape.NONE)
//                        .with(EAST, WallShape.NONE)
//                        .with(SOUTH, WallShape.NONE)
//                        .with(WEST, WallShape.NONE)
//        );
//        this.shapeFunction = this.createShapeFunction();
//    }
//
//
//
//
//
//
//    public Function<BlockState, VoxelShape> createShapeFunction() {
//        Map<Direction, VoxelShape> map = CrabsBackportVoxelUtil.createHorizontalFacingShapeMap(Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 1.0, 1.0));
//        Map<Direction, VoxelShape> map2 = CrabsBackportVoxelUtil.createFacingShapeMap(Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 1.0, 1.0));
//        return (BlockState state) -> {
//            VoxelShape voxelShape = state.get(BOTTOM) ? map2.get(Direction.DOWN) : VoxelShapes.empty();
//            for (Map.Entry<Direction, EnumProperty<WallShape>> entry : WALL_SHAPE_PROPERTIES_BY_DIRECTION.entrySet()) {
//                WallShape shape = state.get(entry.getValue());
//                switch (shape) {
//                    case NONE:
//                    default:
//                        break;
//                    case LOW:
//                        voxelShape = VoxelShapes.union(voxelShape, map.get(entry.getKey()));
//                        break;
//                    case TALL:
//                        voxelShape = VoxelShapes.union(voxelShape, map2.get(entry.getKey()));
//                        break;
//                }
//            }
//            return voxelShape.isEmpty() ? VoxelShapes.fullCube() : voxelShape;
//        };
//    }
//
//    @Override
//    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        return (VoxelShape)this.shapeFunction.apply(state);
//    }
//    @Override
//    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        return state.get(BOTTOM) ? (VoxelShape)this.shapeFunction.apply(this.getDefaultState()) : VoxelShapes.empty();
//    }
//
//    @Override
//    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
//        return true;
//    }
//
//    @Override
//    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
//        BlockState blockState = world.getBlockState(pos.down());
//        return state.get(BOTTOM) ? !blockState.isAir() : blockState.isOf(this) && (Boolean)blockState.get(BOTTOM);
//    }
//    private static boolean hasAnyShape(BlockState state) {
//        if ((Boolean)state.get(BOTTOM)) {
//            return true;
//        } else {
//            for (EnumProperty<WallShape> enumProperty : WALL_SHAPE_PROPERTIES_BY_DIRECTION.values()) {
//                if (state.get(enumProperty) != WallShape.NONE) {
//                    return true;
//                }
//            }
//
//            return false;
//        }
//    }
//    private static boolean canGrowOnFace(BlockView world, BlockPos pos, Direction direction, BlockState state) {
//        return direction == Direction.UP ? false : MultifaceGrowthBlock.canGrowOn(world, direction, pos, state);
//    }
//    private static BlockState updateState(BlockState state, BlockView world, BlockPos pos, boolean bl) {
//        BlockState blockState = null;
//        BlockState blockState2 = null;
//        bl |= state.get(BOTTOM);
//
//        for (Direction direction : Direction.Type.HORIZONTAL) {
//            EnumProperty<WallShape> enumProperty = getWallShape(direction);
//            WallShape wallShape = canGrowOnFace(world, pos,  direction, state) ? (bl ? WallShape.LOW : state.get(enumProperty)) : WallShape.NONE;
//            if (wallShape == WallShape.LOW) {
//                if (blockState == null) {
//                    blockState = world.getBlockState(pos.up());
//                }
//
//                if (blockState.isOf(CrabsBackportBlocks.PALE_MOSS_CARPET) && blockState.get(enumProperty) != WallShape.NONE && !(Boolean)blockState.get(BOTTOM)) {
//                    wallShape = WallShape.TALL;
//                }
//
//                if (!(Boolean)state.get(BOTTOM)) {
//                    if (blockState2 == null) {
//                        blockState2 = world.getBlockState(pos.down());
//                    }
//
//                    if (blockState2.isOf(CrabsBackportBlocks.PALE_MOSS_CARPET) && blockState2.get(enumProperty) == WallShape.NONE) {
//                        wallShape = WallShape.NONE;
//                    }
//                }
//            }
//
//            state = state.with(enumProperty, wallShape);
//        }
//
//        return state;
//    }
//
//    @Nullable
//    @Override
//    public BlockState getPlacementState(ItemPlacementContext ctx) {
//        return updateState(this.getDefaultState(), ctx.getWorld(), ctx.getBlockPos(), true);
//    }
//
//    public static void placeAt(WorldAccess world, BlockPos pos, Random random, int flags) {
//        BlockState blockState = CrabsBackportBlocks.PALE_MOSS_CARPET.getDefaultState();
//        BlockState blockState2 = updateState(blockState, world, pos, true);
//        world.setBlockState(pos, blockState2, flags);
//        BlockState blockState3 = createUpperState(world, pos, random::nextBoolean);
//        if (!blockState3.isAir()) {
//            world.setBlockState(pos.up(), blockState3, flags);
//            BlockState blockState4 = updateState(blockState2, world, pos, true);
//            world.setBlockState(pos, blockState4, flags);
//        }
//    }
//
//    @Override
//    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
//        if (!world.isClient()) {
//            Random random = world.getRandom();
//            BlockState blockState = createUpperState(world, pos, random::nextBoolean);
//            if (!blockState.isAir()) {
//                world.setBlockState(pos.up(), blockState, Block.NOTIFY_ALL);
//            }
//        }
//    }
//
//    private static BlockState createUpperState(BlockView world, BlockPos pos, BooleanSupplier booleanSupplier) {
//        BlockPos blockPos = pos.up();
//        BlockState blockState = world.getBlockState(blockPos);
//        boolean bl = blockState.isOf(CrabsBackportBlocks.PALE_MOSS_CARPET);
//        if ((!bl || !(Boolean)blockState.get(BOTTOM)) && (bl || blockState.isReplaceable())) {
//            BlockState blockState2 = CrabsBackportBlocks.PALE_MOSS_CARPET.getDefaultState().with(BOTTOM, false);
//            BlockState blockState3 = updateState(blockState2, world, pos.up(), true);
//
//            for (Direction direction : Direction.Type.HORIZONTAL) {
//                EnumProperty<WallShape> enumProperty = getWallShape(direction);
//                if (blockState3.get(enumProperty) != WallShape.NONE && !booleanSupplier.getAsBoolean()) {
//                    blockState3 = blockState3.with(enumProperty, WallShape.NONE);
//                }
//            }
//
//            return hasAnyShape(blockState3) && blockState3 != blockState ? blockState3 : Blocks.AIR.getDefaultState();
//        } else {
//            return Blocks.AIR.getDefaultState();
//        }
//    }
//
//
//    @Override
//    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
//        if (!state.canPlaceAt(world, pos)) {
//            return Blocks.AIR.getDefaultState();
//        } else {
//            BlockState blockState = updateState(state, world, pos, false);
//            return !hasAnyShape(blockState) ? Blocks.AIR.getDefaultState() : blockState;
//        }
//    }
//
//    @Override
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(BOTTOM, NORTH, EAST, SOUTH, WEST);
//    }
//
//    @Override
//    public BlockState rotate(BlockState state, BlockRotation rotation) {
//        return switch (rotation) {
//            case CLOCKWISE_180 -> (BlockState)state.with(NORTH, (WallShape)state.get(SOUTH))
//                    .with(EAST, (WallShape)state.get(WEST))
//                    .with(SOUTH, (WallShape)state.get(NORTH))
//                    .with(WEST, (WallShape)state.get(EAST));
//            case COUNTERCLOCKWISE_90 -> (BlockState)state.with(NORTH, (WallShape)state.get(EAST))
//                    .with(EAST, (WallShape)state.get(SOUTH))
//                    .with(SOUTH, (WallShape)state.get(WEST))
//                    .with(WEST, (WallShape)state.get(NORTH));
//            case CLOCKWISE_90 -> (BlockState)state.with(NORTH, (WallShape)state.get(WEST))
//                    .with(EAST, (WallShape)state.get(NORTH))
//                    .with(SOUTH, (WallShape)state.get(EAST))
//                    .with(WEST, (WallShape)state.get(SOUTH));
//            default -> state;
//        };
//    }
//
//    @Override
//    public BlockState mirror(BlockState state, BlockMirror mirror) {
//        return switch (mirror) {
//            case LEFT_RIGHT -> (BlockState)state.with(NORTH, (WallShape)state.get(SOUTH)).with(SOUTH, (WallShape)state.get(NORTH));
//            case FRONT_BACK -> (BlockState)state.with(EAST, (WallShape)state.get(WEST)).with(WEST, (WallShape)state.get(EAST));
//            default -> super.mirror(state, mirror);
//        };
//    }
//
//    @Nullable
//    public static EnumProperty<WallShape> getWallShape(Direction face) {
//        return (EnumProperty<WallShape>)WALL_SHAPE_PROPERTIES_BY_DIRECTION.get(face);
//    }
//
//    @Override
//    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
//        return (Boolean)state.get(BOTTOM) && !createUpperState(world, pos, () -> true).isAir();
//    }
//
//    @Override
//    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
//        return true;
//    }
//
//    @Override
//    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
//        BlockState blockState = createUpperState(world, pos, () -> true);
//        if (!blockState.isAir()) {
//            world.setBlockState(pos.up(), blockState, Block.NOTIFY_ALL);
//        }
//    }

}
