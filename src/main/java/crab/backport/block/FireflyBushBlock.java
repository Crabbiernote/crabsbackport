package crab.backport.block;

import crab.backport.CrabsBackportClient;
import crab.backport.sound.CrabsBackportSounds;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.PlantBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.ChunkRandom;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class FireflyBushBlock extends PlantBlock implements Fertilizable {
    public FireflyBushBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(30) == 0 && isNightAndNatural(world) && world.getTopY(Heightmap.Type.MOTION_BLOCKING, pos.getX(), pos.getZ()) <= pos.getY()) {
            world.playSoundAtBlockCenter(pos, CrabsBackportSounds.FIREFLY_BUSH_IDLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
        }
        if ((world.getLightLevel(pos) <= 13 || isNightAndNatural(world)) && random.nextDouble() <= 0.7) {
            double d = (double)pos.getX() + random.nextDouble() * 10.0 - 5.0;
            double e = (double)pos.getY() + random.nextDouble() * 5.0;
            double f = (double)pos.getZ() + random.nextDouble() * 10.0 - 5.0;
            world.addParticle(CrabsBackportClient.FIREFLY, d, e, f, 0.0, 0.0, 0.0);
        }
    }

        @Override
        public boolean isFertilizable (WorldView world, BlockPos pos, BlockState state,boolean isClient){
            return true;
        }

        @Override
        public boolean canGrow (World world, Random random, BlockPos pos, BlockState state){
            return true;
        }

        @Override
        public void grow (ServerWorld world, Random random, BlockPos pos, BlockState state){
            dropStack(world, pos, new ItemStack(this));
        }
        public boolean isNightAndNatural(World world){
            if (!world.getDimension().natural()) {
                return false;
            } else {
                int i = (int)(world.getTimeOfDay() % 24000L);
                return i >= 12600 && i <= 23400;
            }
        }
    }

