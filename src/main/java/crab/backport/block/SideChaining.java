package crab.backport.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public interface SideChaining {
    SideChainPart getSideChainPart(BlockState state);

    BlockState withSideChainPart(BlockState state, SideChainPart sideChainPart);

    Direction getFacing(BlockState state);

    boolean canChainWith(BlockState state);

    int getMaxSideChainLength();

    default List<BlockPos> getPositionsInChain(WorldAccess world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        if (!this.canChainWith(blockState)) {
            return List.of();
        } else {
            SideChaining.Neighbors neighbors = this.getNeighbors(world, pos, this.getFacing(blockState));
            List<BlockPos> list = new LinkedList();
            list.add(pos);
            this.forEachNeighborTowards(neighbors::getLeftNeighbor, SideChainPart.LEFT, list::add);
            this.forEachNeighborTowards(neighbors::getRightNeighbor, SideChainPart.RIGHT, list::add);
            return list;
        }
    }

    private void forEachNeighborTowards(IntFunction<Neighbor> neighborGetter, SideChainPart part, Consumer<BlockPos> posConsumer) {
        for (int i = 1; i < this.getMaxSideChainLength(); i++) {
            SideChaining.Neighbor neighbor = (SideChaining.Neighbor) neighborGetter.apply(i);
            if (neighbor.isCenterOr(part)) {
                posConsumer.accept(neighbor.pos());
            }

            if (neighbor.isNotCenter()) {
                break;
            }
        }
    }

    default void disconnectNeighbors(WorldAccess world, BlockPos pos, BlockState state) {
        SideChaining.Neighbors neighbors = this.getNeighbors(world, pos, this.getFacing(state));
        neighbors.getLeftNeighbor().disconnectFromRight();
        neighbors.getRightNeighbor().disconnectFromLeft();
    }

    default void connectNeighbors(WorldAccess world, BlockPos pos, BlockState state, BlockState oldState) {
        if (this.canChainWith(state)) {
            if (!this.isAlreadyConnected(state, oldState)) {
                SideChaining.Neighbors neighbors = this.getNeighbors(world, pos, this.getFacing(state));
                SideChainPart sideChainPart = SideChainPart.UNCONNECTED;
                int i = this.getPositionsInChain(world, neighbors.getLeftNeighbor().pos()).size();
                int j = this.getPositionsInChain(world, neighbors.getRightNeighbor().pos()).size();
                int k = 1;
                if (this.canAddChainLength(i, k)) {
                    sideChainPart = sideChainPart.connectToLeft();
                    neighbors.getLeftNeighbor().connectToRight();
                    k += i;
                }

                if (this.canAddChainLength(j, k)) {
                    sideChainPart = sideChainPart.connectToRight();
                    neighbors.getRightNeighbor().connectToLeft();
                }

                this.setSideChainPart(world, pos, sideChainPart);
            }
        }
    }

    private boolean canAddChainLength(int chainLength, int toAdd) {
        return chainLength > 0 && toAdd + chainLength <= this.getMaxSideChainLength();
    }

    private boolean isAlreadyConnected(BlockState state, BlockState oldState) {
        boolean bl = this.getSideChainPart(state).isConnected();
        boolean bl2 = this.canChainWith(oldState) && this.getSideChainPart(oldState).isConnected();
        return bl || bl2;
    }

    private SideChaining.Neighbors getNeighbors(WorldAccess world, BlockPos pos, Direction facing) {
        return new SideChaining.Neighbors(this, world, facing, pos, new HashMap());
    }

    default void setSideChainPart(WorldAccess world, BlockPos pos, SideChainPart part) {
        BlockState blockState = world.getBlockState(pos);
        if (this.getSideChainPart(blockState) != part) {
            world.setBlockState(pos, this.withSideChainPart(blockState, part), Block.NOTIFY_ALL);
        }
    }

    public record EmptyNeighbor(BlockPos pos) implements SideChaining.Neighbor {
        @Override
        public boolean isNotCenter() {
            return true;
        }

        @Override
        public boolean isCenterOr(SideChainPart part) {
            return false;
        }
    }

    public sealed interface Neighbor permits SideChaining.EmptyNeighbor, SideChaining.SideChainNeighbor {
        BlockPos pos();

        boolean isNotCenter();

        boolean isCenterOr(SideChainPart part);

        default void connectToRight() {
        }

        default void connectToLeft() {
        }

        default void disconnectFromRight() {
        }

        default void disconnectFromLeft() {
        }
    }

    public record Neighbors(SideChaining block, WorldAccess world, Direction facing, BlockPos center,
                            Map<BlockPos, Neighbor> cache) {
        private boolean canChainWith(BlockState state) {
            return this.block.canChainWith(state) && this.block.getFacing(state) == this.facing;
        }

        private SideChaining.Neighbor createNeighbor(BlockPos pos) {
            BlockState blockState = this.world.getBlockState(pos);
            SideChainPart sideChainPart = this.canChainWith(blockState) ? this.block.getSideChainPart(blockState) : null;
            return (SideChaining.Neighbor) (sideChainPart == null
                    ? new SideChaining.EmptyNeighbor(pos)
                    : new SideChaining.SideChainNeighbor(this.world, this.block, pos, sideChainPart));
        }

        private SideChaining.Neighbor getOrCreateNeighbor(Direction direction, Integer distance) {
            return (SideChaining.Neighbor) this.cache.computeIfAbsent(this.center.offset(direction, distance), this::createNeighbor);
        }

        public SideChaining.Neighbor getLeftNeighbor(int distance) {
            return this.getOrCreateNeighbor(this.facing.rotateYClockwise(), distance);
        }

        public SideChaining.Neighbor getRightNeighbor(int distance) {
            return this.getOrCreateNeighbor(this.facing.rotateYCounterclockwise(), distance);
        }

        public SideChaining.Neighbor getLeftNeighbor() {
            return this.getLeftNeighbor(1);
        }

        public SideChaining.Neighbor getRightNeighbor() {
            return this.getRightNeighbor(1);
        }
    }

    public record SideChainNeighbor(WorldAccess level, SideChaining block, BlockPos pos,
                                    SideChainPart part) implements SideChaining.Neighbor {
        @Override
        public boolean isNotCenter() {
            return this.part.isNotCenter();
        }

        @Override
        public boolean isCenterOr(SideChainPart part) {
            return this.part.isCenterOr(part);
        }

        @Override
        public void connectToRight() {
            this.block.setSideChainPart(this.level, this.pos, this.part.connectToRight());
        }

        @Override
        public void connectToLeft() {
            this.block.setSideChainPart(this.level, this.pos, this.part.connectToLeft());
        }

        @Override
        public void disconnectFromRight() {
            this.block.setSideChainPart(this.level, this.pos, this.part.disconnectFromRight());
        }

        @Override
        public void disconnectFromLeft() {
            this.block.setSideChainPart(this.level, this.pos, this.part.disconnectFromLeft());
        }
    }
}

