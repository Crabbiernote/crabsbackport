package crab.backport.datagen;

import crab.backport.block.CrabsBackportBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class CrabsBackportLanguageProvider extends FabricLanguageProvider {
    public CrabsBackportLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(CrabsBackportBlocks.WAXED_COPPER_DOOR, "Waxed Copper Door");
        translationBuilder.add(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_DOOR, "Waxed Exposed Copper Door");
        translationBuilder.add(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_DOOR, "Waxed Oxidized Copper Door");
        translationBuilder.add(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_DOOR, "Waxed Weathered Copper Door");
        translationBuilder.add(CrabsBackportBlocks.COPPER_DOOR, "Copper Door");
        translationBuilder.add(CrabsBackportBlocks.EXPOSED_COPPER_DOOR, "Exposed Copper Door");
        translationBuilder.add(CrabsBackportBlocks.OXIDIZED_COPPER_DOOR, "Oxidized Copper Door");
        translationBuilder.add(CrabsBackportBlocks.WEATHERED_COPPER_DOOR, "Weathered Copper Door");


    }
}
