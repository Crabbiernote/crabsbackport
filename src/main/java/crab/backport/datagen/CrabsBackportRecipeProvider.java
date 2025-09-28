package crab.backport.datagen;

import crab.backport.block.CrabsBackportBlocks;
import crab.backport.block.CrabsBackportTags;
import crab.backport.item.CrabsBackportItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.Waterloggable;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;

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
    public static final List<ItemConvertible> COPPERGRATEHONEY = List.of(CrabsBackportBlocks.COPPER_GRATE, Items.HONEYCOMB);

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        offerPlanksRecipe(consumer, CrabsBackportBlocks.PALE_OAK_PLANKS, CrabsBackportTags.Items.PALE_OAK_LOGS, 4);
        offerHangingSignRecipe(consumer, CrabsBackportItems.PALE_OAK_HANGING_SIGN, CrabsBackportBlocks.STRIPPED_PALE_OAK_LOG);
        offerSlabRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CrabsBackportBlocks.PALE_OAK_SLAB, CrabsBackportBlocks.PALE_OAK_PLANKS);
//        createStairsRecipe(CrabsBackportBlocks.PALE_OAK_STAIRS, Ingredient.ofItems(CrabsBackportBlocks.PALE_OAK_PLANKS));
//        createDoorRecipe(CrabsBackportBlocks.PALE_OAK_DOOR, Ingredient.ofItems(CrabsBackportBlocks.PALE_OAK_PLANKS));
//        createTrapdoorRecipe(CrabsBackportBlocks.PALE_OAK_TRAPDOOR, Ingredient.ofItems(CrabsBackportBlocks.PALE_OAK_PLANKS));
//        createFenceRecipe(CrabsBackportBlocks.PALE_OAK_FENCE, Ingredient.ofItems(CrabsBackportBlocks.PALE_OAK_PLANKS));
//        createFenceGateRecipe(CrabsBackportBlocks.PALE_OAK_FENCE_GATE, Ingredient.ofItems(CrabsBackportBlocks.PALE_OAK_PLANKS));
//        createPressurePlateRecipe(RecipeCategory.REDSTONE, CrabsBackportBlocks.PALE_OAK_PRESSURE_PLATE, Ingredient.ofItems(CrabsBackportBlocks.PALE_OAK_PLANKS));

    }
}