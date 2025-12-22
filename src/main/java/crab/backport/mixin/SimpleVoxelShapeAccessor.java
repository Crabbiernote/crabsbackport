package crab.backport.mixin;

import net.minecraft.util.shape.SimpleVoxelShape;
import net.minecraft.util.shape.VoxelSet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SimpleVoxelShape.class)
    public interface SimpleVoxelShapeAccessor {
        @Invoker("<init>")
        static SimpleVoxelShape create(VoxelSet voxelSet) {
            throw new AssertionError();
        }
    }
