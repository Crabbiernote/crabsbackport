package crab.backport.mixin;

import net.minecraft.util.shape.ArrayVoxelShape;
import net.minecraft.util.shape.SimpleVoxelShape;
import net.minecraft.util.shape.VoxelSet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
@Mixin(ArrayVoxelShape.class)
    public interface ArrayVoxelShapeAccessor {
    @Invoker("<init>")
    static ArrayVoxelShape create(VoxelSet voxelSet) {
        throw new AssertionError();
    }
}
