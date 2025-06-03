package crab.backport.world.loottable;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class LootTableEditing {
    public static final Identifier RUINED_PORTAL_CHEST =
            new Identifier("minecraft", "chests/ruined_portal");
    public static final Identifier CARTOGRAPHER_HOUSE =
            new Identifier("minecraft", "chests/village/village_cartographer");
    public static final Identifier TANNERY_HOUSE =
            new Identifier("minecraft", "chests/village/village_tannery");
    public static final Identifier WEAPONSMITH_HOUSE =
            new Identifier("minecraft", "chests/village/village_weaponsmith");
    public static final Identifier PLAINS_HOUSE =
            new Identifier("minecraft", "chests/village/village_plains_house");
    public static final Identifier SAVANNAH_HOUSE =
            new Identifier("minecraft", "chests/village/village_savanna_house");
    public static final Identifier SNOWY_HOUSE =
            new Identifier("minecraft", "chests/village/village_snowy_house");
    public static final Identifier DESERT_HOUSE =
            new Identifier("minecraft", "chests/village/village_desert_house");

    public static void editLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (RUINED_PORTAL_CHEST.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6666F))
                        .with(ItemEntry.builder(Items.LODESTONE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (TANNERY_HOUSE.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.33333F))
                        .with(ItemEntry.builder(Items.BUNDLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (PLAINS_HOUSE.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.33333F))
                        .with(ItemEntry.builder(Items.BUNDLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (CARTOGRAPHER_HOUSE.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.33333F))
                        .with(ItemEntry.builder(Items.BUNDLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (WEAPONSMITH_HOUSE.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.33333F))
                        .with(ItemEntry.builder(Items.BUNDLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (SAVANNAH_HOUSE.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.33333F))
                        .with(ItemEntry.builder(Items.BUNDLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (SNOWY_HOUSE.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.33333F))
                        .with(ItemEntry.builder(Items.BUNDLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (DESERT_HOUSE.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.33333F))
                        .with(ItemEntry.builder(Items.BUNDLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });


    }
}
