package crab.backport;

import crab.backport.datagen.*;
import crab.backport.world.CrabsbackportConfiguredFeatures;
import crab.backport.world.CrabsbackportPlacedFeatures;
import crab.backport.world.gen.features.CrabsBackportFeatures;
import crab.backport.world.gen.features.CrabsBackportTreeDecorators;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class CrabsBackportDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();


	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {

	}
}
