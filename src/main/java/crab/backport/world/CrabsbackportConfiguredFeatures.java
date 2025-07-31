package crab.backport.world;

import crab.backport.CrabsBackport;
import crab.backport.block.CrabsBackportBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class CrabsbackportConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BUSH_KEY = registerKey("bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIRCH_WILDFLOWER_KEY = registerKey("birch_wildflower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEADOW_WILDFLOWER_KEY = registerKey("meadow_wildflower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FIREFLY_BUSH_KEY = registerKey("firefly_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DRY_GRASS = registerKey("dry_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_BIRCH_TREE = registerKey("fallen_birch_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_SUPER_BIRCH_TREE = registerKey("fallen_super_birch_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_OAK_TREE = registerKey("fallen_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_SPRUCE_TREE = registerKey("fallen_spruce_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_JUNGLE_TREE = registerKey("fallen_jungle_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context,
                BUSH_KEY,
                Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig(
                        new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                                .add(CrabsBackportBlocks.BUSH.getDefaultState(), 1)),
                        128));

        register(context,
                BIRCH_WILDFLOWER_KEY,
                Feature.FLOWER,
                createRandomPatchFeatureConfig(
                        new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                                .add(CrabsBackportBlocks.WILDFLOWERS.getDefaultState(), 1)),
                        128));
        register(context,
                MEADOW_WILDFLOWER_KEY,
                Feature.FLOWER,
                createRandomPatchFeatureConfig(
                        new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                                .add(CrabsBackportBlocks.WILDFLOWERS.getDefaultState(), 1)),
                        128));
        register(context,
                FIREFLY_BUSH_KEY,
                Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig(
                        new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                                .add(CrabsBackportBlocks.FIREFLY_BUSH.getDefaultState(), 1)),
                        128));
        register(context,
                DRY_GRASS,
                Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig(
                        new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                                .add(CrabsBackportBlocks.TALL_DRY_GRASS.getDefaultState(), 1)
                                .add(CrabsBackportBlocks.SHORT_DRY_GRASS.getDefaultState(), 1)),
                        64
                ));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(CrabsBackport.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(block)));
    }
}
