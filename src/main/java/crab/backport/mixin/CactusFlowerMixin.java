package crab.backport.mixin;

import crab.backport.block.CrabsBackportBlocks;
import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.block.CactusBlock.AGE;

@Mixin(CactusBlock.class)
public class CactusFlowerMixin extends Block {
    @Inject(method = "randomTick", at = @At(value = "HEAD"))
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci){
        BlockPos blockPos = pos.up();
        if (world.isAir(blockPos)) {
            int i = 1;
            int j = state.get(AGE);

            while (world.getBlockState(pos.down(i)).isOf(this)) {
                if (++i == 3 && j == 15) {
                    return;
                }
            }

            if (j == 8 && this.canPlaceAt(this.getDefaultState(), world, pos.up())) {
                double d = i >= 3 ? 0.25 : 0.1;
                if (random.nextDouble() <= d) {
                    world.setBlockState(blockPos, CrabsBackportBlocks.CACTUS_FLOWER.getDefaultState());
                }
            } else if (j == 15 && i < 3) {
                world.setBlockState(blockPos, this.getDefaultState());
                BlockState blockState = state.with(AGE, 0);
                world.setBlockState(pos, blockState, Block.NO_REDRAW);
                world.updateNeighbor(blockState, blockPos, this, blockPos , false);
            }

            if (j < 15) {
                world.setBlockState(pos, state.with(AGE, j + 1), Block.NO_REDRAW);
            }
        }

    }


    public CactusFlowerMixin(Settings settings) {
        super(settings);
    }
}
