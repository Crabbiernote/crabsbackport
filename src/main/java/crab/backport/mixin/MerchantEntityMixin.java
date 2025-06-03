package crab.backport.mixin;


import com.google.common.collect.Lists;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.TradeOffers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;

@Mixin(MerchantEntity.class)
public class MerchantEntityMixin {
    protected final Random random = Random.create();

    @Inject(method = "fillRecipesFromPool", at = @At("HEAD"))
    protected void mewhenmojangchangestradesandshit(TradeOfferList recipeList, TradeOffers.Factory[] pool, int count, CallbackInfo ci){
        MerchantEntity merchantEntity = (MerchantEntity)(Object)this;
        ArrayList<TradeOffers.Factory> arrayList = Lists.newArrayList(pool);
        int i = 0;

        while (i < count && !arrayList.isEmpty()) {
            TradeOffer tradeOffer = ((TradeOffers.Factory)arrayList.remove(this.random.nextInt(arrayList.size()))).create(merchantEntity, this.random);
            if (tradeOffer != null) {
                recipeList.add(tradeOffer);
                i++;
            }
        }
    }
}