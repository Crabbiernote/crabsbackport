package crab.backport;

import crab.backport.block.CrabsBackportBlocks;
import crab.backport.block.OxidizableBlockRegistryistoolong;
import crab.backport.entity.PaintingVarientRegistry;
import crab.backport.entity.WanderingTraderTrades;
import crab.backport.item.CrabsBackportItemGroups;
import crab.backport.item.CrabsBackportItems;
import crab.backport.sound.CrabsBackportSounds;
import crab.backport.world.gen.CrabsBackportWorldGeneration;
import crab.backport.world.gen.features.CrabsBackportFeatures;
import crab.backport.world.gen.features.CrabsBackportTreeDecorators;
import crab.backport.world.loottable.LootTableEditing;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CrabsBackport implements ModInitializer {
	public static final String MOD_ID = "crabsbackport";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final DefaultParticleType FIREFLY = FabricParticleTypes.simple();


	@Override	public void onInitialize() {
		Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "firefly"), FIREFLY);

		CrabsBackportTreeDecorators.init();
		CrabsBackportFeatures.init();
		CrabsBackportBlocks.registerBlocks();
		CrabsBackportItems.registerModItems();
		CrabsBackportSounds.registerSounds();
		CrabsBackportItemGroups.registerItemGroups();
		CrabsBackportWorldGeneration.generateModWorldGen();
		OxidizableBlockRegistryistoolong.registerBlocks();
		WanderingTraderTrades.registerTrades();
		LootTableEditing.editLootTables();
		PaintingVarientRegistry.registerPaintingVariants();


	}
}