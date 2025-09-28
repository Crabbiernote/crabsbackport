package crab.backport.block;

import crab.backport.block.entity.CrabsBackportBlockEntities;
import crab.backport.block.entity.PaleOakSignBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PaleOakWallSignBlock extends WallSignBlock {
    public PaleOakWallSignBlock(Settings settings, WoodType woodType) {
        super(settings, woodType);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PaleOakSignBlockEntity(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, CrabsBackportBlockEntities.PALE_OAK_SIGN_BLOCK_ENTITY, PaleOakSignBlockEntity::tick);
    }
}
