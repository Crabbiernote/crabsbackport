package crab.backport.block;

import crab.backport.block.entity.ListInventory;
import crab.backport.block.entity.ShelfBlockEntity;
import crab.backport.sound.CrabsBackportSounds;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.OptionalInt;

public class ShelfBlock extends BlockWithEntity implements InteractibleSlotContainer, SideChaining, Waterloggable {
    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<SideChainPart> SIDE_CHAIN = EnumProperty.of("side_chain", SideChainPart.class);
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape EAST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 12.0, 0.0, 5.0, 16.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 3.0, 16.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 5.0, 4.0, 16.0)

    );

    protected static final VoxelShape WEST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(11.0, 12.0, 0.0, 13.0, 16.0, 16.0),
            Block.createCuboidShape(13.0, 0.0, 0.0, 16.0, 16.0, 16.0),
            Block.createCuboidShape(11.0, 0.0, 0.0, 13.0, 4.0, 16.0)

    );
    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 12.0, 0.0, 16.0, 16.0, 5.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 3.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 5.0)

    );
    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 12.0, 11.0, 16.0, 16.0, 13.0),
            Block.createCuboidShape(0.0, 0.0, 13.0, 16.0, 16.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 11.0, 16.0, 4.0, 13.0)

    );


    public ShelfBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(
                this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(POWERED, false).with(SIDE_CHAIN, SideChainPart.UNCONNECTED).with(WATERLOGGED, false)
        );
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch ((Direction) state.get(FACING)) {
            case NORTH:
            default:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case EAST:
                return EAST_SHAPE;
        }
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return type == NavigationType.WATER && state.getFluidState().isIn(FluidTags.WATER);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ShelfBlockEntity(pos, state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED, SIDE_CHAIN, WATERLOGGED);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ListInventory) {
                ItemScatterer.spawn(world, pos, (ListInventory) blockEntity);
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
            this.disconnectNeighbors(world, pos, state);
        }
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient()) {
            boolean bl = world.isReceivingRedstonePower(pos);
            if ((Boolean) state.get(POWERED) != bl) {
                BlockState blockState = state.with(POWERED, bl);
                if (!bl) {
                    blockState = blockState.with(SIDE_CHAIN, SideChainPart.UNCONNECTED);
                }

                world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
                this.playSound(world, pos, bl ? CrabsBackportSounds.BLOCK_SHELF_ACTIVATE : CrabsBackportSounds.BLOCK_SHELF_DEACTIVATE);
                world.emitGameEvent(bl ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos, GameEvent.Emitter.of(blockState));
            }
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(POWERED, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()))
                .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public int getColumns() {
        return 3;
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof ShelfBlockEntity shelfBlockEntity && !hand.equals(Hand.OFF_HAND)) {
            OptionalInt optionalInt = this.getHitSlot(hit, state.get(FACING));
            if (optionalInt.isEmpty()) {
                return ActionResult.PASS;
            } else {
                PlayerInventory playerInventory = player.getInventory();
                if ((Boolean) state.get(POWERED)) {
                    ItemStack itemStack = playerInventory.getMainHandStack();
                    this.swapAllStacks(world, pos, playerInventory);
                    this.playSound(world, pos, CrabsBackportSounds.BLOCK_SHELF_MULTI_SWAP);
                    return itemStack == playerInventory.getMainHandStack() ? ActionResult.SUCCESS : ActionResult.CONSUME;
                } else {
                    ItemStack stack = playerInventory.getMainHandStack();
                    boolean bl = swapSingleStack(stack, player, shelfBlockEntity, optionalInt, playerInventory);
                    if (bl && !stack.isEmpty()) {
                        this.playSound(world, pos, CrabsBackportSounds.BLOCK_SHELF_SINGLE_SWAP);
                    } else if (bl || !stack.isEmpty()) {
                        this.playSound(world, pos, CrabsBackportSounds.BLOCK_SHELF_PLACE_ITEM);
                    }

                    return ActionResult.CONSUME;
                }
            }
        } else {
            return ActionResult.PASS;
        }
    }

    private static boolean swapSingleStack(ItemStack stack, PlayerEntity player, ShelfBlockEntity blockEntity, OptionalInt slot, PlayerInventory playerInventory) {
        ItemStack itemStack = blockEntity.swapStackNoMarkDirty(slot.getAsInt(), stack);
        ItemStack itemStack2 = player.isCreative() && itemStack.isEmpty() ? stack.copy() : itemStack;
        if (player.getMainHandStack() == stack) {
            player.setStackInHand(Hand.MAIN_HAND, itemStack2);
        }
        playerInventory.markDirty();
        blockEntity.markDirty(GameEvent.ITEM_INTERACT_FINISH);
        return !itemStack.isEmpty();
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    private void swapAllStacks(World world, BlockPos pos, PlayerInventory playerInventory) {
        List<BlockPos> list = this.getPositionsInChain(world, pos);
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                ShelfBlockEntity shelfBlockEntity = (ShelfBlockEntity) world.getBlockEntity((BlockPos) list.get(i));
                if (shelfBlockEntity != null) {
                    for (int j = 0; j < shelfBlockEntity.size(); j++) {
                        int k = 9 - (list.size() - i) * shelfBlockEntity.size() + j;
                        ItemStack itemStack = shelfBlockEntity.swapStackNoMarkDirty(j, playerInventory.removeStack(k));
                        playerInventory.setStack(k, itemStack);
                    }

                    playerInventory.markDirty();
                    playerInventory.markDirty();
                    shelfBlockEntity.markDirty(GameEvent.ENTITY_INTERACT);
                }
            }
        }
    }

    @Override
    public SideChainPart getSideChainPart(BlockState state) {
        return state.get(SIDE_CHAIN);
    }

    @Override
    public BlockState withSideChainPart(BlockState state, SideChainPart sideChainPart) {
        return state.with(SIDE_CHAIN, sideChainPart);
    }

    @Override
    public Direction getFacing(BlockState state) {
        return state.get(FACING);
    }

    @Override
    public boolean canChainWith(BlockState state) {
        return state.isIn(CrabsBackportTags.Blocks.WOODEN_SHELVES) && (Boolean) state.get(POWERED);
    }

    @Override
    public int getMaxSideChainLength() {
        return 3;
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if ((Boolean) state.get(POWERED)) {
            this.connectNeighbors(world, pos, state, oldState);
        } else {
            this.disconnectNeighbors(world, pos, state);
        }
    }

    private void playSound(WorldAccess world, BlockPos pos, SoundEvent sound) {
        world.playSound(null, pos, sound, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(
            BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos

    ) {
        if ((Boolean) state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }


    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        Direction direction = this.getFacing(state);
        if (world.isClient()) {
            return 0;
        } else if (direction != ((Direction) state.get(FACING)).getOpposite()) {
            return 0;
        } else if (world.getBlockEntity(pos) instanceof ShelfBlockEntity shelfBlockEntity) {
            int i = shelfBlockEntity.getStack(0).isEmpty() ? 0 : 1;
            int j = shelfBlockEntity.getStack(1).isEmpty() ? 0 : 1;
            int k = shelfBlockEntity.getStack(2).isEmpty() ? 0 : 1;
            return i | j << 1 | k << 2;
        } else {
            return 0;
        }
    }
}
