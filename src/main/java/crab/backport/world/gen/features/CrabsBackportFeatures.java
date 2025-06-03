package crab.backport.world.gen.features;

import crab.backport.CrabsBackport;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class CrabsBackportFeatures {
    public static final Feature<FallenTreeFeatureConfig> FALLEN_TREE =
            registerFeature("fallen_tree", new FallenTreeFeature(FallenTreeFeatureConfig.CODEC));

    private static <T extends FeatureConfig> Feature<T> registerFeature(String name, Feature<T> feature) {
        return Registry.register(Registries.FEATURE, new Identifier(CrabsBackport.MOD_ID, name), feature);
    }

    public static void init() {
        // This method is called to trigger static initialization
        CrabsBackport.LOGGER.info("Registering features for " + CrabsBackport.MOD_ID);
    }
}
