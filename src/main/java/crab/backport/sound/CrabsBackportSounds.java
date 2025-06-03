package crab.backport.sound;

import crab.backport.CrabsBackport;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class CrabsBackportSounds {
    public static final SoundEvent FIREFLY_BUSH_IDLE = registerSoundEvent("firefly_bush_idle");
    public static final SoundEvent BLOCK_LEAF_LITTER_BREAK = registerSoundEvent("block.leaf_litter.break");
    public static final SoundEvent BLOCK_LEAF_LITTER_STEP = registerSoundEvent("block.leaf_litter.step");
    public static final SoundEvent BLOCK_LEAF_LITTER_PLACE = registerSoundEvent("block.leaf_litter.place");
    public static final SoundEvent BLOCK_LEAF_LITTER_HIT = registerSoundEvent("block.leaf_litter.hit");
    public static final SoundEvent BLOCK_LEAF_LITTER_FALL = registerSoundEvent("block.leaf_litter.fall");
    public static final SoundEvent COPPER_DOOR_CLOSE = registerSoundEvent("block.copper_door.close");
    public static final SoundEvent COPPER_DOOR_OPEN = registerSoundEvent("block.copper_door.open");
    public static final SoundEvent COPPER_TRAPDOOR_CLOSE = registerSoundEvent("block.copper_trapdoor.close");
    public static final SoundEvent COPPER_TRAPDOOR_OPEN = registerSoundEvent("block.copper_trapdoor.open");
    public static final SoundEvent COPPER_GRATE_BREAK = registerSoundEvent("block.copper_grate.break");
    public static final SoundEvent COPPER_GRATE_STEP = registerSoundEvent("block.copper_grate.step");
    public static final SoundEvent COPPER_GRATE_PLACE = registerSoundEvent("block.copper_grate.place");
    public static final SoundEvent COPPER_GRATE_HIT = registerSoundEvent("block.copper_grate.hit");
    public static final SoundEvent COPPER_GRATE_FALL = registerSoundEvent("block.copper_grate.fall");
    public static final SoundEvent CACTUS_FLOWER_BREAK = registerSoundEvent("block.cactus_flower.break");
    public static final SoundEvent CACTUS_FLOWER_PLACE = registerSoundEvent("block.cactus_flower.place");


    public static final BlockSoundGroup LEAF_LITTER_SOUNDS = new BlockSoundGroup(1.0F, 0.8F,
            CrabsBackportSounds.BLOCK_LEAF_LITTER_BREAK, CrabsBackportSounds.BLOCK_LEAF_LITTER_STEP, CrabsBackportSounds.BLOCK_LEAF_LITTER_PLACE,
            CrabsBackportSounds.BLOCK_LEAF_LITTER_HIT, CrabsBackportSounds.BLOCK_LEAF_LITTER_FALL);
    public static final BlockSoundGroup COPPER_GRATE = new BlockSoundGroup(1.0F, 1.0F,
    CrabsBackportSounds.COPPER_GRATE_BREAK, CrabsBackportSounds.COPPER_GRATE_STEP, CrabsBackportSounds.COPPER_GRATE_PLACE,
    CrabsBackportSounds.COPPER_GRATE_HIT, CrabsBackportSounds.COPPER_GRATE_FALL);
    public static final BlockSoundGroup CACTUS_FLOWER_SOUNDS = new BlockSoundGroup(1.0F, 0.8F,
            CACTUS_FLOWER_BREAK, SoundEvents.INTENTIONALLY_EMPTY, CACTUS_FLOWER_PLACE, SoundEvents.INTENTIONALLY_EMPTY,SoundEvents.INTENTIONALLY_EMPTY);



    public static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(CrabsBackport.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registerSounds() {
        CrabsBackport.LOGGER.info("Registering Sounds for " + CrabsBackport.MOD_ID);
    }
}
