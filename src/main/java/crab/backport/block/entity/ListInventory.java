package crab.backport.block.entity;

import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

import java.util.function.Predicate;

public interface ListInventory extends Inventory {
    DefaultedList<ItemStack> getHeldStacks();

    default int getFilledSlotCount() {
        return (int) this.getHeldStacks().stream().filter(Predicate.not(ItemStack::isEmpty)).count();
    }

    @Override
    default int size() {
        return this.getHeldStacks().size();
    }

    @Override
    default void clear() {
        this.getHeldStacks().clear();
    }

    @Override
    default boolean isEmpty() {
        return this.getHeldStacks().stream().allMatch(ItemStack::isEmpty);
    }

    @Override
    default ItemStack getStack(int slot) {
        return this.getHeldStacks().get(slot);
    }

    @Override
    default boolean canTransferTo(Inventory hopperInventory, int slot, ItemStack stack) {
        return hopperInventory.containsAny(
                (Predicate<ItemStack>) (hopperStack -> hopperStack.isEmpty()
                        ? true
                        : ItemStack.areItemsEqual(stack, hopperStack) && hopperStack.getCount() + stack.getCount() <= Math.min(this.getMaxCountPerStack(), hopperStack.getMaxCount())
                ));
    }

    @Override
    default ItemStack removeStack(int slot, int amount) {
        ItemStack itemStack = Inventories.splitStack(this.getHeldStacks(), slot, amount);
        if (!itemStack.isEmpty()) {
            this.markDirty();
        }

        return itemStack;
    }

    @Override
    default ItemStack removeStack(int slot) {
        return Inventories.splitStack(this.getHeldStacks(), slot, this.getMaxCountPerStack());
    }

    @Override
    default boolean isValid(int slot, ItemStack stack) {
        return this.canAccept(stack) && (this.getStack(slot).isEmpty() || this.getStack(slot).getCount() < this.getMaxCount(stack));
    }

    default boolean canAccept(ItemStack stack) {
        return true;
    }

    @Override
    default void setStack(int slot, ItemStack stack) {
        this.setStackNoMarkDirty(slot, stack);
        this.markDirty();
    }

    default void setStackNoMarkDirty(int slot, ItemStack stack) {
        this.getHeldStacks().set(slot, stack);
        if (!stack.isEmpty() && stack.getCount() > this.getMaxCount(stack)) {
            stack.setCount(this.getMaxCount(stack));
        }
    }

    default int getMaxCount(ItemStack stack) {
        return Math.min(this.getMaxCountPerStack(), stack.getMaxCount());
    }

}
