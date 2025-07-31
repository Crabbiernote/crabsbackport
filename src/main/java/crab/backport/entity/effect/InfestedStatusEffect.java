package crab.backport.entity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.random.Random;

import java.util.function.ToIntFunction;

public class InfestedStatusEffect extends StatusEffect {
    private final float silverfishChance;
    private final ToIntFunction<Random> silverfishCountFunction;

    public InfestedStatusEffect(StatusEffectCategory statusEffectCategory, int color, float silverfishChance, ToIntFunction<Random> silverfishCountFunction) {
        super(statusEffectCategory, color);
        this.silverfishChance = silverfishChance;
        this.silverfishCountFunction = silverfishCountFunction;
    }
//    @Override
//    public void onEntityDamage(ServerWorld world, LivingEntity entity, int amplifier, DamageSource source, float amount) {
//        if (entity.getRandom().nextFloat() <= this.silverfishChance) {
//            int i = this.silverfishCountFunction.applyAsInt(entity.getRandom());
//
//            for (int j = 0; j < i; j++) {
//                this.spawnSilverfish(world, entity, entity.getX(), entity.getY() + entity.getHeight() / 2.0, entity.getZ());
//            }
//        }
//    }
//


}
