package crab.backport.entity.effect;

import com.google.common.annotations.VisibleForTesting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

public class OozingStatusEffect extends StatusEffect {
    private final ToIntFunction slimeCountFunction;

    public OozingStatusEffect(StatusEffectCategory statusEffectCategory, int color, ToIntFunction slimeCountFunction) {
        super(statusEffectCategory, color);
        this.slimeCountFunction = slimeCountFunction;

    }

    @VisibleForTesting
    protected static int getSlimesToSpawn(int maxEntityCramming, OozingStatusEffect.SlimeCounter slimeCounter, int potentialSlimes) {
        return maxEntityCramming < 1 ? potentialSlimes : MathHelper.clamp(0, maxEntityCramming - slimeCounter.count(maxEntityCramming), potentialSlimes);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        World world = entity.getWorld();
        Entity.RemovalReason reason = entity.getRemovalReason();
        if (reason == Entity.RemovalReason.KILLED) {
            int i = this.slimeCountFunction.applyAsInt(entity.getRandom());
            int j = world.getGameRules().getInt(GameRules.MAX_ENTITY_CRAMMING);
            int k = getSlimesToSpawn(j, OozingStatusEffect.SlimeCounter.around(entity), i);

            for (int l = 0; l < k; l++) {
                this.spawnSlime(entity.getWorld(), entity.getX(), entity.getY() + 0.5, entity.getZ());
            }
        }
    }

    private void spawnSlime(World world, double x, double y, double z) {
        SlimeEntity slimeEntity = EntityType.SLIME.create(world);
        if (slimeEntity != null) {
            slimeEntity.setSize(2, true);
            slimeEntity.refreshPositionAndAngles(x, y, z, world.getRandom().nextFloat() * 360.0F, 0.0F);
            world.spawnEntity(slimeEntity);
        }
    }

    @FunctionalInterface
    protected interface SlimeCounter {
        int count(int limit);

        static OozingStatusEffect.SlimeCounter around(LivingEntity entity) {
            return limit -> {
                List<SlimeEntity> list = new ArrayList();
                entity.getWorld().collectEntitiesByType(EntityType.SLIME, entity.getBoundingBox().expand(2.0), slime -> slime != entity, list, limit);
                return list.size();
            };
        }
    }
}
