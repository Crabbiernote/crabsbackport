package crab.backport;


import crab.backport.datagen.CrabsBackportItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;


public class CrabsBackportDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(CrabsBackportItemTagProvider::new);

    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
    }
}
