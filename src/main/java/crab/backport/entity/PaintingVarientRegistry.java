package crab.backport.entity;

import crab.backport.CrabsBackport;
import crab.backport.block.CrabsBackportBlocks;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PaintingVarientRegistry {
    public static final PaintingVariant MEDITATIVE =  registerPaintingVariant("meditative", new PaintingVariant(16, 16));
    public static final PaintingVariant PRAIRIE_RIDE =  registerPaintingVariant("prairie_ride", new PaintingVariant(16, 32));
    public static final PaintingVariant BAROQUE =  registerPaintingVariant("baroque", new PaintingVariant(32, 32));
    public static final PaintingVariant HUMBLE =  registerPaintingVariant("humble", new PaintingVariant(32, 32));
    public static final PaintingVariant UNPACKED =  registerPaintingVariant("unpacked", new PaintingVariant(64, 64));
    public static final PaintingVariant BOUQUET =  registerPaintingVariant("bouquet", new PaintingVariant(48, 48));
    public static final PaintingVariant CAVEBIRD =  registerPaintingVariant("cavebird", new PaintingVariant(48, 48));
    public static final PaintingVariant COTAN =  registerPaintingVariant("cotan", new PaintingVariant(48, 48));
    public static final PaintingVariant ENDBOSS =  registerPaintingVariant("endboss", new PaintingVariant(48, 48));
    public static final PaintingVariant FERN =  registerPaintingVariant("fern", new PaintingVariant(48, 48));
    public static final PaintingVariant OWLEMONS =  registerPaintingVariant("owlemons", new PaintingVariant(48, 48));
    public static final PaintingVariant SUNFLOWERS =  registerPaintingVariant("sunflowers", new PaintingVariant(48, 48));
    public static final PaintingVariant TIDES =  registerPaintingVariant("tides", new PaintingVariant(48, 48));
    public static final PaintingVariant BACKYARD =  registerPaintingVariant("backyard", new PaintingVariant(48, 64));
    public static final PaintingVariant POND =  registerPaintingVariant("pond", new PaintingVariant(48, 64));
    public static final PaintingVariant CHANGING =  registerPaintingVariant("changing", new PaintingVariant(64, 32));
    public static final PaintingVariant FINDING =  registerPaintingVariant("finding", new PaintingVariant(64, 32));
    public static final PaintingVariant LOWMIST =  registerPaintingVariant("lowmist", new PaintingVariant(64, 32));
    public static final PaintingVariant PASSAGE =  registerPaintingVariant("passage", new PaintingVariant(64, 32));
    public static final PaintingVariant ORB =  registerPaintingVariant("orb", new PaintingVariant(64, 64));


    public static PaintingVariant registerPaintingVariant(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(CrabsBackport.MOD_ID, name), paintingVariant);
    }


    public static void registerPaintingVariants(){
        CrabsBackport.LOGGER.info("Registering Painting Variants");
    }
}
