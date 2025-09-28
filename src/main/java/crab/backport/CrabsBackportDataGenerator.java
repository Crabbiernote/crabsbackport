package crab.backport;


import crab.backport.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;


public class CrabsBackportDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(CrabsBackportItemTagProvider::new);
        pack.addProvider(CrabsBackportModelProvider::new);
        pack.addProvider(CrabsBackportBlockTagProvider::new);
        pack.addProvider(CrabsBackportLootTableProvider::new);
        pack.addProvider(CrabsBackportRecipeProvider::new);

    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
    }
}
