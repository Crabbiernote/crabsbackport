package crab.backport.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HangingSignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class PaleOakHangingSignBlockEntity extends HangingSignBlockEntity {
    public PaleOakHangingSignBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return CrabsBackportBlockEntities.PALE_OAK_HANGING_SIGN_BLOCK_ENTITY;
    }
}
