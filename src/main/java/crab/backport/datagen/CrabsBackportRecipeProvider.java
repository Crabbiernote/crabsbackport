package crab.backport.datagen;

import crab.backport.block.CrabsBackportBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;

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

    }
}