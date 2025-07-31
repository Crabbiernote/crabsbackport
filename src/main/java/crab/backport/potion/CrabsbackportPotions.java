package crab.backport.potion;

import crab.backport.CrabsBackport;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CrabsbackportPotions {


    private static Potion register(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(CrabsBackport.MOD_ID, name), potion);
    }
}
