package crab.backport.world.gen;

import crab.backport.world.CrabsbackportPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class CrabsbackportVegetationGeneration {
    public static void generatedatho(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.FOREST,BiomeKeys.PLAINS, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, BiomeKeys.RIVER, BiomeKeys.FROZEN_RIVER),
                GenerationStep.Feature.VEGETAL_DECORATION, CrabsbackportPlacedFeatures.BUSH_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, CrabsbackportPlacedFeatures.BIRCH_WILDFLOWER_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MEADOW),
                GenerationStep.Feature.VEGETAL_DECORATION, CrabsbackportPlacedFeatures.MEADOW_WILDFLOWER_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SWAMP),
                GenerationStep.Feature.VEGETAL_DECORATION, CrabsbackportPlacedFeatures.FIREFLY_BUSH_SWAMP_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SWAMP),
                GenerationStep.Feature.VEGETAL_DECORATION, CrabsbackportPlacedFeatures.FIREFLY_BUSH_NEAR_WATER_SWAMP_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.FROZEN_RIVER),
                GenerationStep.Feature.VEGETAL_DECORATION, CrabsbackportPlacedFeatures.FIREFLY_BUSH_WATER_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DESERT),
                GenerationStep.Feature.VEGETAL_DECORATION, CrabsbackportPlacedFeatures.DRY_GRASS_DESERT);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BADLANDS, BiomeKeys.ERODED_BADLANDS, BiomeKeys.WOODED_BADLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, CrabsbackportPlacedFeatures.DRY_GRASS_BADLANDS);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST,BiomeKeys.FLOWER_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.DARK_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, CrabsbackportPlacedFeatures.FALLEN_BIRCH_TREE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, CrabsbackportPlacedFeatures.FALLEN_SUPER_BIRCH_TREE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.SWAMP, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_SAVANNA, BiomeKeys.WOODED_BADLANDS, BiomeKeys.DARK_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, CrabsbackportPlacedFeatures.FALLEN_OAK_TREE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.TAIGA, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA, BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.SNOWY_TAIGA, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.SNOWY_PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, CrabsbackportPlacedFeatures.FALLEN_SPRUCE_TREE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE, BiomeKeys.SPARSE_JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION, CrabsbackportPlacedFeatures.FALLEN_JUNGLE_TREE);



    }

}
