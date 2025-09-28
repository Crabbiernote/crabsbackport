package crab.backport.datagen;

import crab.backport.block.CrabsBackportBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class CrabsBackportBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public CrabsBackportBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(CrabsBackportBlocks.PALE_OAK_LOG)
                .add(CrabsBackportBlocks.STRIPPED_PALE_OAK_LOG)
                .add(CrabsBackportBlocks.PALE_OAK_WOOD)
                .add(CrabsBackportBlocks.STRIPPED_PALE_OAK_WOOD);
        getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
                .add(CrabsBackportBlocks.PALE_OAK_WALL_SIGN);
        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
                .add(CrabsBackportBlocks.PALE_OAK_SIGN);
        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
                .add(CrabsBackportBlocks.PALE_OAK_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
                .add(CrabsBackportBlocks.PALE_OAK_HANGING_WALL_SIGN);

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(CrabsBackportBlocks.PALE_OAK_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(CrabsBackportBlocks.PALE_OAK_DOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(CrabsBackportBlocks.PALE_OAK_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(CrabsBackportBlocks.PALE_OAK_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(CrabsBackportBlocks.PALE_OAK_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(CrabsBackportBlocks.PALE_OAK_SLAB);
        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(CrabsBackportBlocks.PALE_OAK_SAPLING);


        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(CrabsBackportBlocks.PALE_OAK_BUTTON);

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(CrabsBackportBlocks.PALE_OAK_PRESSURE_PLATE);
        }
    }


