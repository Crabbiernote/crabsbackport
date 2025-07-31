package crab.backport.entity.effect;

import crab.backport.CrabsBackport;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CrabsbackportStatusEffects {


    private static StatusEffect register(String id, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(CrabsBackport.MOD_ID, id), statusEffect);
    }
}
