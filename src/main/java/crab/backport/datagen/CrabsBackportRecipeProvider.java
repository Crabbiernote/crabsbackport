package crab.backport.datagen;

import crab.backport.block.CrabsBackportBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class CrabsBackportRecipeProvider extends FabricRecipeProvider {
    public CrabsBackportRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    public static final List<ItemConvertible> LEAF_LITTER_SMELTABLES = List.of(Blocks.ACACIA_LEAVES, Blocks.AZALEA_LEAVES, Blocks.BIRCH_LEAVES, Blocks.CHERRY_LEAVES, Blocks.FLOWERING_AZALEA_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.MANGROVE_LEAVES, Blocks.JUNGLE_LEAVES, Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES);
    public static final List<ItemConvertible> COPPER_ITEMS = List.of(CrabsBackportBlocks.COPPER_GRATE, CrabsBackportBlocks.COPPER_DOOR, CrabsBackportBlocks.COPPER_TRAPDOOR, CrabsBackportBlocks.CHISELED_COPPER,
            CrabsBackportBlocks.EXPOSED_COPPER_GRATE, CrabsBackportBlocks.EXPOSED_COPPER_DOOR, CrabsBackportBlocks.EXPOSED_COPPER_TRAPDOOR, CrabsBackportBlocks.EXPOSED_CHISELED_COPPER,
            CrabsBackportBlocks.WEATHERED_COPPER_GRATE, CrabsBackportBlocks.WEATHERED_COPPER_DOOR, CrabsBackportBlocks.WEATHERED_COPPER_TRAPDOOR, CrabsBackportBlocks.WEATHERED_CHISELED_COPPER,
            CrabsBackportBlocks.OXIDIZED_CHISELED_COPPER, CrabsBackportBlocks.OXIDIZED_COPPER_GRATE, CrabsBackportBlocks.OXIDIZED_COPPER_DOOR, CrabsBackportBlocks.OXIDIZED_COPPER_TRAPDOOR);

    public static final List<ItemConvertible> WAXED_COPPER_ITEMS = List.of(CrabsBackportBlocks.WAXED_COPPER_GRATE, CrabsBackportBlocks.WAXED_COPPER_DOOR, CrabsBackportBlocks.WAXED_COPPER_TRAPDOOR, CrabsBackportBlocks.WAXED_CHISELED_COPPER,
            CrabsBackportBlocks.WAXED_EXPOSED_COPPER_GRATE, CrabsBackportBlocks.WAXED_EXPOSED_COPPER_DOOR, CrabsBackportBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR, CrabsBackportBlocks.WAXED_EXPOSED_CHISELED_COPPER,
            CrabsBackportBlocks.WAXED_WEATHERED_COPPER_GRATE, CrabsBackportBlocks.WAXED_WEATHERED_COPPER_DOOR, CrabsBackportBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR, CrabsBackportBlocks.WAXED_WEATHERED_CHISELED_COPPER,
            CrabsBackportBlocks.WAXED_OXIDIZED_CHISELED_COPPER, CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_GRATE, CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_DOOR, CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);
    public static final List<ItemConvertible>  COPPERGRATEHONEY = List.of(CrabsBackportBlocks.COPPER_GRATE, Items.HONEYCOMB);

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        offerPolishedStoneRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.POLISHED_TUFF, Items.TUFF);
        offer2x2CompactingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_BRICKS, CrabsBackportBlocks.POLISHED_TUFF);

        offerWallRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_WALLS, Items.TUFF);
        offerWallRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.POLISHED_TUFF_WALLS, CrabsBackportBlocks.POLISHED_TUFF);
        offerWallRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_BRICK_WALLS, CrabsBackportBlocks.TUFF_BRICKS);


        offerSlabRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_SLAB, Items.TUFF);
        offerSlabRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.POLISHED_TUFF_SLAB, CrabsBackportBlocks.POLISHED_TUFF);
        offerSlabRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_BRICK_SLAB, CrabsBackportBlocks.TUFF_BRICKS);

        createStairsRecipe(CrabsBackportBlocks.TUFF_STAIRS, Ingredient.ofItems(Items.TUFF))
                .criterion(hasItem(Items.TUFF), conditionsFromItem(Items.TUFF))
                .criterion(hasItem(CrabsBackportBlocks.TUFF_STAIRS), conditionsFromItem(CrabsBackportBlocks.TUFF_STAIRS))
                .offerTo(consumer, new Identifier("crabs_backport", "tuff_stairs"));
        createStairsRecipe(CrabsBackportBlocks.POLISHED_TUFF_STAIRS, Ingredient.ofItems(CrabsBackportBlocks.POLISHED_TUFF))
                .criterion(hasItem(CrabsBackportBlocks.POLISHED_TUFF_STAIRS), conditionsFromItem(CrabsBackportBlocks.POLISHED_TUFF_STAIRS))
                .criterion(hasItem(CrabsBackportBlocks.POLISHED_TUFF), conditionsFromItem(CrabsBackportBlocks.POLISHED_TUFF))
                .offerTo(consumer, new Identifier("crabs_backport", "polished_tuff_stairs"));
        createStairsRecipe(CrabsBackportBlocks.TUFF_BRICK_STAIRS, Ingredient.ofItems(CrabsBackportBlocks.TUFF_BRICKS))
                .criterion(hasItem(CrabsBackportBlocks.TUFF_BRICK_STAIRS), conditionsFromItem(CrabsBackportBlocks.TUFF_BRICK_STAIRS))
                .criterion(hasItem(CrabsBackportBlocks.TUFF_BRICKS), conditionsFromItem(CrabsBackportBlocks.TUFF_BRICKS))
                .offerTo(consumer, new Identifier("crabs_backport", "tuff_brick_stairs"));

        createDoorRecipe(CrabsBackportBlocks.COPPER_DOOR, Ingredient.ofItems(Items.COPPER_INGOT))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(CrabsBackportBlocks.COPPER_DOOR), conditionsFromItem(CrabsBackportBlocks.COPPER_DOOR))
                .offerTo(consumer, new Identifier("crabs_backport", "copper_door"));
        createTrapdoorRecipe(CrabsBackportBlocks.COPPER_TRAPDOOR, Ingredient.ofItems(Items.COPPER_INGOT))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(CrabsBackportBlocks.COPPER_TRAPDOOR), conditionsFromItem(CrabsBackportBlocks.COPPER_TRAPDOOR))
                .offerTo(consumer, new Identifier("crabs_backport", "copper_trapdoor"));
        offerChiseledBlockRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.CHISELED_COPPER, Blocks.CUT_COPPER_SLAB);
        offerChiseledBlockRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.EXPOSED_CHISELED_COPPER, Blocks.EXPOSED_CUT_COPPER_SLAB);
        offerChiseledBlockRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.WEATHERED_CHISELED_COPPER, Blocks.WEATHERED_CUT_COPPER_SLAB);
        offerChiseledBlockRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.WAXED_CHISELED_COPPER, Blocks.WAXED_CUT_COPPER_SLAB);
        offerChiseledBlockRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.WAXED_EXPOSED_CHISELED_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB);
        offerChiseledBlockRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.WAXED_WEATHERED_CHISELED_COPPER, Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB);
        offerChiseledBlockRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.WAXED_OXIDIZED_CHISELED_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB);
        offerChiseledBlockRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.CHISELED_TUFF, CrabsBackportBlocks.TUFF_SLAB);
        offerChiseledBlockRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.CHISELED_TUFF_BRICKS, CrabsBackportBlocks.TUFF_BRICK_SLAB);

        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.CHISELED_TUFF_BRICKS, Blocks.TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.CHISELED_TUFF_BRICKS, CrabsBackportBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.CHISELED_TUFF_BRICKS, CrabsBackportBlocks.TUFF_BRICKS);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.CHISELED_TUFF, Blocks.TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.POLISHED_TUFF, Blocks.TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.POLISHED_TUFF_SLAB, Blocks.TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.POLISHED_TUFF_SLAB, CrabsBackportBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.POLISHED_TUFF_STAIRS, Blocks.TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.POLISHED_TUFF_STAIRS, CrabsBackportBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.POLISHED_TUFF_WALLS, Blocks.TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.POLISHED_TUFF_WALLS, CrabsBackportBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_BRICK_SLAB, Blocks.TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_BRICK_SLAB, CrabsBackportBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_BRICK_SLAB, CrabsBackportBlocks.TUFF_BRICKS);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_BRICK_STAIRS, Blocks.TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_BRICK_STAIRS, CrabsBackportBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_BRICK_STAIRS, CrabsBackportBlocks.TUFF_BRICKS);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_BRICK_WALLS, Blocks.TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_BRICK_WALLS, CrabsBackportBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_BRICK_WALLS, CrabsBackportBlocks.TUFF_BRICKS);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_BRICKS, Blocks.TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_BRICKS, CrabsBackportBlocks.POLISHED_TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_SLAB, Blocks.TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_STAIRS, Blocks.TUFF);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.TUFF_WALLS, Blocks.TUFF);

        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.CHISELED_COPPER, Blocks.COPPER_BLOCK);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.EXPOSED_CHISELED_COPPER, Blocks.EXPOSED_COPPER);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.OXIDIZED_CHISELED_COPPER, Blocks.OXIDIZED_COPPER );
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.WEATHERED_CHISELED_COPPER, Blocks.WEATHERED_COPPER );
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.WAXED_CHISELED_COPPER, Blocks.WAXED_COPPER_BLOCK );
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.WAXED_EXPOSED_CHISELED_COPPER, Blocks.WAXED_EXPOSED_COPPER);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.WAXED_OXIDIZED_CHISELED_COPPER, Blocks.WAXED_OXIDIZED_COPPER);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.WAXED_WEATHERED_CHISELED_COPPER, Blocks.WAXED_WEATHERED_COPPER);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.COPPER_GRATE, Blocks.COPPER_BLOCK,4);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.EXPOSED_COPPER_GRATE, Blocks.EXPOSED_COPPER,4);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.OXIDIZED_COPPER_GRATE, Blocks.OXIDIZED_COPPER,4);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.WEATHERED_COPPER_GRATE, Blocks.WEATHERED_COPPER,4);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.WAXED_COPPER_GRATE, Blocks.WAXED_COPPER_BLOCK,4);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.WAXED_EXPOSED_COPPER_GRATE, Blocks.WAXED_EXPOSED_COPPER,4);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_GRATE, Blocks.WAXED_OXIDIZED_COPPER,4);
        offerStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.WAXED_WEATHERED_COPPER_GRATE, Blocks.WAXED_WEATHERED_COPPER,4);




        offerSmelting(consumer, LEAF_LITTER_SMELTABLES, RecipeCategory.MISC, CrabsBackportBlocks.LEAF_LITTER, 0.15f, 200, "leaf_litter");
        offerSingleOutputShapelessRecipe(consumer, Items.YELLOW_DYE, CrabsBackportBlocks.WILDFLOWERS, "wildflower");
        for (int i = 0; i < COPPER_ITEMS.size(); i++) {
            offerShapelessRecipe(consumer, WAXED_COPPER_ITEMS.get(i), COPPER_ITEMS.get(i), "waxed_copper_item", 1);
        }
    }
}