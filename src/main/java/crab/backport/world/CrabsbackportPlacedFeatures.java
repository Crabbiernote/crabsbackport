package crab.backport.world;

import crab.backport.CrabsBackport;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class CrabsbackportPlacedFeatures {
    public static final RegistryKey<PlacedFeature> BUSH_KEY = registerKey("bush");
    public static final RegistryKey<PlacedFeature> BIRCH_WILDFLOWER_KEY = registerKey("birch_wildflower");
    public static final RegistryKey<PlacedFeature> MEADOW_WILDFLOWER_KEY = registerKey("meadow_wildflower");
    public static final RegistryKey<PlacedFeature> FIREFLY_BUSH_WATER_KEY = registerKey("firefly_bush_near_water");
    public static final RegistryKey<PlacedFeature> FIREFLY_BUSH_SWAMP_KEY = registerKey("firefly_bush_swamp");
    public static final RegistryKey<PlacedFeature> FIREFLY_BUSH_NEAR_WATER_SWAMP_KEY = registerKey("firefly_bush_near_water_swamp");
    public static final RegistryKey<PlacedFeature> DRY_GRASS_DESERT = registerKey("dry_grass_desert");
    public static final RegistryKey<PlacedFeature> DRY_GRASS_BADLANDS = registerKey("dry_grass_badlands");
    public static final RegistryKey<PlacedFeature> FALLEN_BIRCH_TREE = registerKey("fallen_birch_tree");
    public static final RegistryKey<PlacedFeature> FALLEN_SUPER_BIRCH_TREE = registerKey("fallen_super_birch_tree");
    public static final RegistryKey<PlacedFeature> FALLEN_OAK_TREE = registerKey("fallen_oak_tree");
    public static final RegistryKey<PlacedFeature> FALLEN_SPRUCE_TREE = registerKey("fallen_spruce_tree");
    public static final RegistryKey<PlacedFeature> FALLEN_JUNGLE_TREE = registerKey("fallen_jungle_tree");

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context,
                BUSH_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(CrabsbackportConfiguredFeatures.BUSH_KEY),
                RarityFilterPlacementModifier.of(4),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
        register(context,
                BIRCH_WILDFLOWER_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(CrabsbackportConfiguredFeatures.BIRCH_WILDFLOWER_KEY),
                RarityFilterPlacementModifier.of(24),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
        register(context,
                MEADOW_WILDFLOWER_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(CrabsbackportConfiguredFeatures.MEADOW_WILDFLOWER_KEY),
                RarityFilterPlacementModifier.of(24),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
        register(context,
                FIREFLY_BUSH_WATER_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(CrabsbackportConfiguredFeatures.FIREFLY_BUSH_KEY),
                RarityFilterPlacementModifier.of(2),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
        register(context,
                FIREFLY_BUSH_SWAMP_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(CrabsbackportConfiguredFeatures.FIREFLY_BUSH_KEY),
                RarityFilterPlacementModifier.of(8),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
        register(context,
                FIREFLY_BUSH_NEAR_WATER_SWAMP_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(CrabsbackportConfiguredFeatures.FIREFLY_BUSH_KEY),
                RarityFilterPlacementModifier.of(3),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
        register(context,
                DRY_GRASS_BADLANDS,
                configuredFeatureRegistryEntryLookup.getOrThrow(CrabsbackportConfiguredFeatures.DRY_GRASS),
                RarityFilterPlacementModifier.of(6),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
        register(context,
                DRY_GRASS_DESERT,
                configuredFeatureRegistryEntryLookup.getOrThrow(CrabsbackportConfiguredFeatures.DRY_GRASS),
                RarityFilterPlacementModifier.of(3),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(CrabsBackport.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
