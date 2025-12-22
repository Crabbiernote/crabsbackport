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
    public static final SoundEvent BLOCK_SHELF_BREAK = registerSoundEvent("block.shelf.break");
    public static final SoundEvent BLOCK_SHELF_STEP = registerSoundEvent("block.shelf.step");
    public static final SoundEvent BLOCK_SHELF_PLACE = registerSoundEvent("block.shelf.place");
    public static final SoundEvent BLOCK_SHELF_HIT = registerSoundEvent("block.shelf.hit");
    public static final SoundEvent BLOCK_SHELF_FALL = registerSoundEvent("block.shelf.fall");
    public static final SoundEvent BLOCK_SHELF_ACTIVATE = registerSoundEvent("block.shelf.activate");
    public static final SoundEvent BLOCK_SHELF_DEACTIVATE = registerSoundEvent("block.shelf.deactivate");
    public static final SoundEvent BLOCK_SHELF_MULTI_SWAP = registerSoundEvent("block.shelf.multi_swap");
    public static final SoundEvent BLOCK_SHELF_SINGLE_SWAP = registerSoundEvent("block.shelf.single_swap");
    public static final SoundEvent BLOCK_SHELF_PLACE_ITEM = registerSoundEvent("block.shelf.place_item");
    public static final SoundEvent LAVA_CHICKEN = registerSoundEvent("music_disc.lava_chicken");
    public static final SoundEvent TEARS = registerSoundEvent("music_disc.tears");
    public static final SoundEvent PRECIPICE = registerSoundEvent("music_disc.precipice");
    public static final SoundEvent CREATOR = registerSoundEvent("music_disc.creator");
    public static final SoundEvent CREATOR_MUSIC_BOX = registerSoundEvent("music_disc.creator_music_box");
    public static final SoundEvent BLOCK_COPPER_BULB_TURN_ON = registerSoundEvent("block.copper_bulb.turn_on");
    public static final SoundEvent BLOCK_COPPER_BULB_TURN_OFF = registerSoundEvent("block.copper_bulb.turn_off");
    public static final SoundEvent BLOCK_COPPER_BULB_BREAK = registerSoundEvent("block.copper_bulb.break");
    public static final SoundEvent BLOCK_COPPER_BULB_STEP = registerSoundEvent("block.copper_bulb.step");
    public static final SoundEvent BLOCK_COPPER_BULB_PLACE = registerSoundEvent("block.copper_bulb.place");
    public static final SoundEvent BLOCK_COPPER_BULB_HIT = registerSoundEvent("block.copper_bulb.hit");
    public static final SoundEvent BLOCK_COPPER_BULB_FALL = registerSoundEvent("block.copper_bulb.fall");
    public static final SoundEvent PALE_HANGING_MOSS_IDLE = registerSoundEvent("block.pale_hanging_moss.idle");

    public static final BlockSoundGroup LEAF_LITTER_SOUNDS = new BlockSoundGroup(1.0F, 0.8F,
            CrabsBackportSounds.BLOCK_LEAF_LITTER_BREAK,
            CrabsBackportSounds.BLOCK_LEAF_LITTER_STEP,
            CrabsBackportSounds.BLOCK_LEAF_LITTER_PLACE,
            CrabsBackportSounds.BLOCK_LEAF_LITTER_HIT,
            CrabsBackportSounds.BLOCK_LEAF_LITTER_FALL
    );

    public static final BlockSoundGroup COPPER_BULB = new BlockSoundGroup(1.0F, 1.0F,
            CrabsBackportSounds.BLOCK_COPPER_BULB_BREAK,
            CrabsBackportSounds.BLOCK_COPPER_BULB_STEP,
            CrabsBackportSounds.BLOCK_COPPER_BULB_PLACE,
            CrabsBackportSounds.BLOCK_COPPER_BULB_HIT,
            CrabsBackportSounds.BLOCK_COPPER_BULB_FALL
    );
    public static final BlockSoundGroup COPPER_GRATE = new BlockSoundGroup(1.0F, 1.0F,
            CrabsBackportSounds.COPPER_GRATE_BREAK,
            CrabsBackportSounds.COPPER_GRATE_STEP,
            CrabsBackportSounds.COPPER_GRATE_PLACE,
            CrabsBackportSounds.COPPER_GRATE_HIT,
            CrabsBackportSounds.COPPER_GRATE_FALL
    );
    public static final BlockSoundGroup CACTUS_FLOWER_SOUNDS = new BlockSoundGroup(1.0F, 0.8F,
            CACTUS_FLOWER_BREAK,
            SoundEvents.INTENTIONALLY_EMPTY,
            CACTUS_FLOWER_PLACE,
            SoundEvents.INTENTIONALLY_EMPTY,
            SoundEvents.INTENTIONALLY_EMPTY
    );

    public static final BlockSoundGroup SHELF = new BlockSoundGroup(1.0F, 1.0F,
            BLOCK_SHELF_BREAK,
            BLOCK_SHELF_STEP,
            BLOCK_SHELF_PLACE,
            BLOCK_SHELF_HIT,
            BLOCK_SHELF_FALL
    );


    public static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(CrabsBackport.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        CrabsBackport.LOGGER.info("Registering Sounds for " + CrabsBackport.MOD_ID);
    }
}
