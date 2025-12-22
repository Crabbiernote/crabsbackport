package crab.backport.block;

import com.mojang.serialization.MapCodec;
import crab.backport.sound.CrabsBackportSounds;
import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class HangingMossBlock extends Block implements Fertilizable {
    private static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
    private static final VoxelShape TIP_SHAPE = Block.createCuboidShape(2.0, 2.0, 2.0, 14.0, 16.0, 14.0);
    public static final BooleanProperty TIP = Properties.BOTTOM;


    public HangingMossBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(TIP, true));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(TIP) ? TIP_SHAPE : SHAPE;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(500) == 0) {
            BlockState blockState = world.getBlockState(pos.up());
            if (blockState.isIn(CrabsBackportTags.Blocks.PALE_OAK_LOGS) || blockState.isOf(CrabsBackportBlocks.PALE_OAK_LEAVES)) {
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), CrabsBackportSounds.PALE_HANGING_MOSS_IDLE, SoundCategory.AMBIENT, 1.0F, 1.0F, false);
            }
        }
    }

    @Override
    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return this.canPlaceAt(world, pos);
    }

    private boolean canPlaceAt(BlockView world, BlockPos pos) {
        BlockPos blockPos = pos.offset(Direction.UP);
        BlockState blockState = world.getBlockState(blockPos);
        return MultifaceGrowthBlock.canGrowOn(world, Direction.UP, blockPos, blockState) || blockState.isOf(CrabsBackportBlocks.PALE_HANGING_MOSS);
    }

    @Override
    public BlockState getStateForNeighborUpdate(
            BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {
        if (!this.canPlaceAt(world, pos)) {
            world.scheduleBlockTick(pos, this, 1);
        }

        return state.with(TIP, !world.getBlockState(pos.down()).isOf(this));
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!this.canPlaceAt(world, pos)) {
            world.breakBlock(pos, true);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TIP);
    }


    private boolean canGrowInto(BlockState state) {
        return state.isAir();
    }

    public BlockPos getTipPos(BlockView world, BlockPos pos) {
        BlockPos.Mutable mutable = pos.mutableCopy();

        BlockState blockState;
        do {
            mutable.move(Direction.DOWN);
            blockState = world.getBlockState(mutable);
        } while (blockState.isOf(this));

        return mutable.offset(Direction.UP).toImmutable();
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return this.canGrowInto(world.getBlockState(this.getTipPos(world, pos).down()));
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockPos blockPos = this.getTipPos(world, pos).down();
        if (this.canGrowInto(world.getBlockState(blockPos))) {
            world.setBlockState(blockPos, state.with(TIP, true));
        }
    }
}

