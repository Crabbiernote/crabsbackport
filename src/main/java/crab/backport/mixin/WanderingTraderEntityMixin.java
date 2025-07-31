package crab.backport.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.TradeOffers;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(WanderingTraderEntity.class)
public class WanderingTraderEntityMixin extends MerchantEntity {

    @Unique
    protected final Random random = Random.create();

    public WanderingTraderEntityMixin(EntityType<? extends MerchantEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "fillRecipes", at = @At("HEAD"))
    public void newfillRecipes(CallbackInfo ci) {
        TradeOffers.Factory[] factorys = TradeOffers.WANDERING_TRADER_TRADES.get(1);
        TradeOffers.Factory[] factorys2 = TradeOffers.WANDERING_TRADER_TRADES.get(2);
        TradeOffers.Factory[] factorys3 = TradeOffers.WANDERING_TRADER_TRADES.get(3);

        if (factorys != null && factorys2 != null && factorys3 != null) {
            TradeOfferList tradeOfferList = this.getOffers();
            int j;
            for (j = 0; j < 2; j++) {

                int i = this.random.nextInt(factorys2.length);
                TradeOffers.Factory factory = factorys2[i];
                TradeOffer tradeOffer = factory.create(this, this.random);
                if (tradeOffer != null) {
                    tradeOfferList.add(tradeOffer);
                }
            }
            for (j = 0; j < 2; j++) {
                int i = this.random.nextInt(factorys3.length);
                TradeOffers.Factory factory1 = factorys3[i];
                TradeOffer tradeOffer1 = factory1.create(this, this.random);
                if (tradeOffer1 != null) {
                    tradeOfferList.add(tradeOffer1);
                }
            }
            this.fillRecipesFromPool(tradeOfferList, factorys, 3);
        }
    }

    @Override
    public void afterUsing(TradeOffer offer) {
    }

    @Override
    public void fillRecipes() {
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
