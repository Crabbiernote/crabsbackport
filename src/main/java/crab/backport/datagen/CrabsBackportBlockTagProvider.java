package crab.backport.datagen;

import crab.backport.block.CrabsBackportBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class CrabsBackportBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public CrabsBackportBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(
                CrabsBackportBlocks.POLISHED_TUFF,
                CrabsBackportBlocks.CHISELED_TUFF,
                CrabsBackportBlocks.TUFF_BRICKS,
                CrabsBackportBlocks.CHISELED_TUFF_BRICKS,
                CrabsBackportBlocks.TUFF_WALLS,
                CrabsBackportBlocks.TUFF_BRICK_WALLS,
                CrabsBackportBlocks.POLISHED_TUFF_WALLS,
                CrabsBackportBlocks.TUFF_SLAB,
                CrabsBackportBlocks.POLISHED_TUFF_SLAB,
                CrabsBackportBlocks.TUFF_BRICK_SLAB,
                CrabsBackportBlocks.TUFF_STAIRS,
                CrabsBackportBlocks.POLISHED_TUFF_STAIRS,
                CrabsBackportBlocks.TUFF_BRICK_STAIRS,
                CrabsBackportBlocks.CHISELED_COPPER,
                CrabsBackportBlocks.WEATHERED_CHISELED_COPPER,
                CrabsBackportBlocks.EXPOSED_CHISELED_COPPER,
                CrabsBackportBlocks.OXIDIZED_CHISELED_COPPER,
                CrabsBackportBlocks.WAXED_CHISELED_COPPER,
                CrabsBackportBlocks.WAXED_EXPOSED_CHISELED_COPPER,
                CrabsBackportBlocks.WAXED_OXIDIZED_CHISELED_COPPER,
                CrabsBackportBlocks.WAXED_WEATHERED_CHISELED_COPPER,
                CrabsBackportBlocks.COPPER_TRAPDOOR,
                CrabsBackportBlocks.WAXED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.EXPOSED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.OXIDIZED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.WEATHERED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.COPPER_GRATE,
                CrabsBackportBlocks.WAXED_COPPER_GRATE,
                CrabsBackportBlocks.EXPOSED_COPPER_GRATE,
                CrabsBackportBlocks.WAXED_EXPOSED_COPPER_GRATE,
                CrabsBackportBlocks.OXIDIZED_COPPER_GRATE,
                CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_GRATE,
                CrabsBackportBlocks.WEATHERED_COPPER_GRATE,
                CrabsBackportBlocks.WAXED_WEATHERED_COPPER_GRATE

        );
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).add(
                CrabsBackportBlocks.CHISELED_COPPER,
                CrabsBackportBlocks.WEATHERED_CHISELED_COPPER,
                CrabsBackportBlocks.EXPOSED_CHISELED_COPPER,
                CrabsBackportBlocks.OXIDIZED_CHISELED_COPPER,
                CrabsBackportBlocks.WAXED_CHISELED_COPPER,
                CrabsBackportBlocks.WAXED_EXPOSED_CHISELED_COPPER,
                CrabsBackportBlocks.WAXED_OXIDIZED_CHISELED_COPPER,
                CrabsBackportBlocks.WAXED_WEATHERED_CHISELED_COPPER,
                CrabsBackportBlocks.COPPER_TRAPDOOR,
                CrabsBackportBlocks.WAXED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.EXPOSED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.OXIDIZED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.WEATHERED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.COPPER_GRATE,
                CrabsBackportBlocks.WAXED_COPPER_GRATE,
                CrabsBackportBlocks.EXPOSED_COPPER_GRATE,
                CrabsBackportBlocks.WAXED_EXPOSED_COPPER_GRATE,
                CrabsBackportBlocks.OXIDIZED_COPPER_GRATE,
                CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_GRATE,
                CrabsBackportBlocks.WEATHERED_COPPER_GRATE,
                CrabsBackportBlocks.WAXED_WEATHERED_COPPER_GRATE
        );
        getOrCreateTagBuilder(BlockTags.WALLS).add(
                CrabsBackportBlocks.TUFF_WALLS,
                        CrabsBackportBlocks.TUFF_BRICK_WALLS,
                        CrabsBackportBlocks.POLISHED_TUFF_WALLS);

        getOrCreateTagBuilder(BlockTags.SLABS).add(
                CrabsBackportBlocks.TUFF_SLAB,
                        CrabsBackportBlocks.POLISHED_TUFF_SLAB,
                        CrabsBackportBlocks.TUFF_BRICK_SLAB
                );

        getOrCreateTagBuilder(BlockTags.STAIRS).add(
                CrabsBackportBlocks.TUFF_STAIRS,
                        CrabsBackportBlocks.POLISHED_TUFF_STAIRS,
                        CrabsBackportBlocks.TUFF_BRICK_STAIRS
        );

        getOrCreateTagBuilder(BlockTags.FLOWERS).add(
                CrabsBackportBlocks.WILDFLOWERS
        );
        getOrCreateTagBuilder(BlockTags.REPLACEABLE_BY_TREES).add(
                CrabsBackportBlocks.SHORT_DRY_GRASS,
                CrabsBackportBlocks.TALL_DRY_GRASS,
                CrabsBackportBlocks.BUSH,
                CrabsBackportBlocks.FIREFLY_BUSH
        );
        getOrCreateTagBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(
                CrabsBackportBlocks.WILDFLOWERS,
                CrabsBackportBlocks.LEAF_LITTER
        );
        getOrCreateTagBuilder(BlockTags.TRAPDOORS).add(
                CrabsBackportBlocks.COPPER_TRAPDOOR,
                CrabsBackportBlocks.WAXED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.EXPOSED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.OXIDIZED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.WEATHERED_COPPER_TRAPDOOR,
                CrabsBackportBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR
        );
        getOrCreateTagBuilder(BlockTags.DOORS).add(
                CrabsBackportBlocks.COPPER_DOOR,
                CrabsBackportBlocks.WAXED_COPPER_DOOR,
                CrabsBackportBlocks.EXPOSED_COPPER_DOOR,
                CrabsBackportBlocks.WAXED_EXPOSED_COPPER_DOOR,
                CrabsBackportBlocks.OXIDIZED_COPPER_DOOR,
                CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_DOOR,
                CrabsBackportBlocks.WEATHERED_COPPER_DOOR,
                CrabsBackportBlocks.WAXED_WEATHERED_COPPER_DOOR
        );
        }

    }

