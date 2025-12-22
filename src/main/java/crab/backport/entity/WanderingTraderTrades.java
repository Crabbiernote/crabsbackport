package crab.backport.entity;

import crab.backport.block.CrabsBackportBlocks;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.village.TradeOffer;

public class WanderingTraderTrades {
    public static void registerTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.HAY_BLOCK, 1),
                    new ItemStack(Items.EMERALD, 1),
                    2, 1, 0.065f
            ));
        });
        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(CrabsBackportBlocks.PALE_OAK_SAPLING, 1),
                    8, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.BAKED_POTATO, 4),
                    new ItemStack(Items.EMERALD, 1),
                    2, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.FERMENTED_SPIDER_EYE, 1),
                    new ItemStack(Items.EMERALD, 3),
                    2, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.MILK_BUCKET, 1),
                    new ItemStack(Items.EMERALD, 2),
                    2, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER),
                    new ItemStack(Items.EMERALD, 1),
                    2, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.WATER_BUCKET, 1),
                    new ItemStack(Items.EMERALD, 2),
                    2, 1, 0.065f
            ));
        });


        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 5),
                    PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.LONG_INVISIBILITY),
                    1, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.OAK_LOG, 8),
                    4, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.ACACIA_LOG, 8),
                    4, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.BIRCH_LOG, 8),
                    4, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.MANGROVE_LOG, 8),
                    4, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.CHERRY_LOG, 8),
                    4, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.DARK_OAK_LOG, 8),
                    4, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.SPRUCE_LOG, 8),
                    4, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.JUNGLE_LOG, 8),
                    4, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(CrabsBackportBlocks.PALE_MOSS_BLOCK, 2),
                    5, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(CrabsBackportBlocks.WILDFLOWERS, 1),
                    12, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(CrabsBackportBlocks.TALL_DRY_GRASS, 1),
                    12, 1, 0.065f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(CrabsBackportBlocks.FIREFLY_BUSH, 1),
                    12, 1, 0.065f
            ));
        });


    }
}
