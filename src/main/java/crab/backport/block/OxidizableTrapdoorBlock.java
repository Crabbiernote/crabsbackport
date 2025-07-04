package crab.backport.block;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class OxidizableTrapdoorBlock extends TrapdoorBlock implements Oxidizable {
    private final Oxidizable.OxidationLevel oxidationLevel;
    public OxidizableTrapdoorBlock(Settings settings, Oxidizable.OxidationLevel oxidationLevel, BlockSetType blockSetType) {
        super(settings, blockSetType);
        this.oxidationLevel = oxidationLevel;
    }


    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }


    @Override
    public boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }
    @Override
    public OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
