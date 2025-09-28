package crab.backport.block;

import crab.backport.block.entity.CrabsBackportBlockEntities;
import crab.backport.block.entity.PaleOakHangingSignBlockEntity;
import crab.backport.block.entity.PaleOakSignBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.HangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PaleOakHangingSignBlock extends HangingSignBlock {
    public PaleOakHangingSignBlock(Settings settings, WoodType woodType) {
        super(settings, woodType);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PaleOakHangingSignBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, CrabsBackportBlockEntities.PALE_OAK_HANGING_SIGN_BLOCK_ENTITY, PaleOakHangingSignBlockEntity::tick);
    }
}
