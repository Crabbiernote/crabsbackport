package crab.backport.block.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.event.GameEvent;

public class ShelfBlockEntity extends BlockEntity implements ListInventory {
    private final DefaultedList<ItemStack> heldStacks = DefaultedList.ofSize(3, ItemStack.EMPTY);

    public ShelfBlockEntity(BlockPos pos, BlockState state) {
        super(CrabsBackportBlockEntities.SHELF_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.heldStacks.clear();
        Inventories.readNbt(nbt, this.heldStacks);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.heldStacks, true);
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }


    @Override
    public NbtCompound toInitialChunkDataNbt() {
        NbtCompound nbtCompound = new NbtCompound();
        Inventories.writeNbt(nbtCompound, this.heldStacks, true);
        return createNbt();
    }

    @Override
    public DefaultedList<ItemStack> getHeldStacks() {
        return this.heldStacks;
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return Inventory.canPlayerUse(this, player);
    }

    public ItemStack swapStackNoMarkDirty(int slot, ItemStack stack) {
        ItemStack itemStack = this.removeStack(slot);
        this.setStackNoMarkDirty(slot, stack);
        return itemStack;
    }

    public void markDirty(GameEvent event) {
        super.markDirty();
        this.world.emitGameEvent(event, this.pos, GameEvent.Emitter.of(getCachedState()));
        this.getWorld().updateListeners(this.getPos(), this.getCachedState(), this.getCachedState(), Block.NOTIFY_ALL);
    }

    @Override
    public void markDirty() {
        this.markDirty(GameEvent.BLOCK_ACTIVATE);
    }
}

