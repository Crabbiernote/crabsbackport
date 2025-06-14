package crab.backport.block;

import crab.backport.CrabsBackport;
import crab.backport.sound.CrabsBackportSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Set;

public class CrabsBackportBlocks {
    public static final BlockSetType COPPER = new BlockSetType(
            "copper",
            true,
            BlockSoundGroup.COPPER,
            CrabsBackportSounds.COPPER_DOOR_CLOSE,
            CrabsBackportSounds.COPPER_DOOR_OPEN,
            CrabsBackportSounds.COPPER_TRAPDOOR_CLOSE,
            CrabsBackportSounds.COPPER_TRAPDOOR_OPEN,
            SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON,
            SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF,
            SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON
    );
    public static final Block TUFF_STAIRS = registerBlock("tuff_stairs",
            new StairsBlock(Blocks.TUFF.getDefaultState(), FabricBlockSettings.copyOf(Blocks.TUFF)));
    public static final Block TUFF_SLAB = registerBlock("tuff_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.TUFF)));
    public static final Block TUFF_WALLS = registerBlock("tuff_walls",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.TUFF)));
    public static final Block POLISHED_TUFF = registerBlock("polished_tuff",
            new Block(FabricBlockSettings.copyOf(Blocks.TUFF)));
    public static final Block POLISHED_TUFF_STAIRS = registerBlock("polished_tuff_stairs",
            new StairsBlock(Blocks.TUFF.getDefaultState(), FabricBlockSettings.copyOf(Blocks.TUFF)));
    public static final Block POLISHED_TUFF_SLAB = registerBlock("polished_tuff_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.TUFF)));
    public static final Block POLISHED_TUFF_WALLS = registerBlock("polished_tuff_walls",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.TUFF)));
    public static final Block CHISELED_TUFF = registerBlock("chiseled_tuff",
            new Block(FabricBlockSettings.copyOf(Blocks.TUFF)));
    public static final Block TUFF_BRICKS = registerBlock("tuff_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.TUFF)));
    public static final Block TUFF_BRICK_STAIRS = registerBlock("tuff_brick_stairs",
            new StairsBlock(Blocks.TUFF.getDefaultState(), FabricBlockSettings.copyOf(Blocks.TUFF)));
    public static final Block TUFF_BRICK_SLAB = registerBlock("tuff_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.TUFF)));
    public static final Block TUFF_BRICK_WALLS = registerBlock("tuff_brick_walls",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.TUFF)));
    public static final Block CHISELED_TUFF_BRICKS = registerBlock("chiseled_tuff_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.TUFF)));
    public static final Block LEAF_LITTER = registerBlock("leaf_litter",
    new LeafLitterBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.BROWN)
                    .noCollision()
                    .sounds(CrabsBackportSounds.LEAF_LITTER_SOUNDS)
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BUSH = registerBlock("bush",
    new BushBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.DARK_GREEN)
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .burnable()
            .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block WILDFLOWERS = registerBlock("wildflowers",
            new FlowerbedBlock(FabricBlockSettings.copyOf(Blocks.PINK_PETALS).sounds(BlockSoundGroup.PINK_PETALS).mapColor(MapColor.YELLOW)));
    public static final Block CACTUS_FLOWER = registerBlock("cactus_flower",
            new CactusFlowerBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.PINK)
                            .burnable()
                            .noCollision()
                            .breakInstantly()
                            .sounds(CrabsBackportSounds.CACTUS_FLOWER_SOUNDS)
                            .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block FIREFLY_BUSH = registerBlock("firefly_bush",
            new FireflyBushBlock(
                    AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .burnable()
                    .luminance(state -> 2)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SHORT_DRY_GRASS = registerBlock("short_dry_grass",
        new ShortDryGrassBlock(AbstractBlock.Settings.create()
                .mapColor(MapColor.YELLOW)
                .replaceable()
                .noCollision()
                .breakInstantly()
                .sounds(BlockSoundGroup.GRASS)
                .burnable()
                .pistonBehavior(PistonBehavior.DESTROY)
        ));
    public static final Block TALL_DRY_GRASS = registerBlock("tall_dry_grass",
    new TallDryGrassBlock(
            AbstractBlock.Settings.create()
            .mapColor(MapColor.YELLOW)
            .replaceable()
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .burnable()
            .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block CHISELED_COPPER = registerBlock("chiseled_copper",
            new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)));
    public static final Block WEATHERED_CHISELED_COPPER = registerBlock("weathered_chiseled_copper",
    new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(Blocks.WEATHERED_COPPER)));
    public static final Block EXPOSED_CHISELED_COPPER = registerBlock("exposed_chiseled_copper",
    new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(Blocks.EXPOSED_COPPER)));
    public static final Block OXIDIZED_CHISELED_COPPER = registerBlock("oxidized_chiseled_copper",
    new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(Blocks.OXIDIZED_COPPER)));
    public static final Block WAXED_CHISELED_COPPER = registerBlock("waxed_chiseled_copper",
             new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)));
    public static final Block WAXED_WEATHERED_CHISELED_COPPER = registerBlock("waxed_weathered_chiseled_copper",
    new Block(FabricBlockSettings.copyOf(Blocks.WEATHERED_COPPER)));
    public static final Block WAXED_EXPOSED_CHISELED_COPPER = registerBlock("waxed_exposed_chiseled_copper",
    new Block(FabricBlockSettings.copyOf(Blocks.EXPOSED_COPPER)));
    public static final Block WAXED_OXIDIZED_CHISELED_COPPER = registerBlock("waxed_oxidized_chiseled_copper",
    new Block(FabricBlockSettings.copyOf(Blocks.OXIDIZED_COPPER)));
    public static final Block COPPER_TRAPDOOR = registerBlock("copper_trapdoor",
        new OxidizableTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).nonOpaque(), Oxidizable.OxidationLevel.UNAFFECTED, CrabsBackportBlocks.COPPER));
    public static final Block EXPOSED_COPPER_TRAPDOOR = registerBlock("exposed_copper_trapdoor",
    new OxidizableTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.EXPOSED_COPPER).nonOpaque(), Oxidizable.OxidationLevel.EXPOSED, CrabsBackportBlocks.COPPER));
    public static final Block WEATHERED_COPPER_TRAPDOOR = registerBlock("weathered_copper_trapdoor",
    new OxidizableTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.WEATHERED_COPPER).nonOpaque(), Oxidizable.OxidationLevel.WEATHERED, CrabsBackportBlocks.COPPER));
    public static final Block OXIDIZED_COPPER_TRAPDOOR = registerBlock("oxidized_copper_trapdoor",
    new OxidizableTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OXIDIZED_COPPER).nonOpaque(), Oxidizable.OxidationLevel.OXIDIZED, CrabsBackportBlocks.COPPER));
    public static final Block WAXED_COPPER_TRAPDOOR = registerBlock("waxed_copper_trapdoor",
    new OxidizableTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).nonOpaque(), Oxidizable.OxidationLevel.UNAFFECTED, CrabsBackportBlocks.COPPER));
    public static final Block WAXED_EXPOSED_COPPER_TRAPDOOR = registerBlock("waxed_exposed_copper_trapdoor",
    new OxidizableTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.EXPOSED_COPPER).nonOpaque(), Oxidizable.OxidationLevel.EXPOSED, CrabsBackportBlocks.COPPER));
    public static final Block WAXED_WEATHERED_COPPER_TRAPDOOR = registerBlock("waxed_weathered_copper_trapdoor",
    new OxidizableTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.WEATHERED_COPPER).nonOpaque(), Oxidizable.OxidationLevel.WEATHERED, CrabsBackportBlocks.COPPER));
    public static final Block WAXED_OXIDIZED_COPPER_TRAPDOOR = registerBlock("waxed_oxidized_copper_trapdoor",
    new OxidizableTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OXIDIZED_COPPER).nonOpaque(), Oxidizable.OxidationLevel.OXIDIZED, CrabsBackportBlocks.COPPER));
    public static final Block COPPER_DOOR = registerBlock("copper_door",
            new OxidizableDoorBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).nonOpaque(), Oxidizable.OxidationLevel.UNAFFECTED, CrabsBackportBlocks.COPPER));
    public static final Block EXPOSED_COPPER_DOOR = registerBlock("exposed_copper_door",
    new OxidizableDoorBlock(FabricBlockSettings.copyOf(Blocks.EXPOSED_COPPER).nonOpaque(), Oxidizable.OxidationLevel.EXPOSED, CrabsBackportBlocks.COPPER));
    public static final Block WEATHERED_COPPER_DOOR = registerBlock("weathered_copper_door",
    new OxidizableDoorBlock(FabricBlockSettings.copyOf(Blocks.WEATHERED_COPPER).nonOpaque(), Oxidizable.OxidationLevel.WEATHERED, CrabsBackportBlocks.COPPER));
    public static final Block OXIDIZED_COPPER_DOOR = registerBlock("oxidized_copper_door",
    new OxidizableDoorBlock(FabricBlockSettings.copyOf(Blocks.OXIDIZED_COPPER).nonOpaque(), Oxidizable.OxidationLevel.OXIDIZED, CrabsBackportBlocks.COPPER));
    public static final Block WAXED_COPPER_DOOR = registerBlock("waxed_copper_door",
    new OxidizableDoorBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).nonOpaque(), Oxidizable.OxidationLevel.UNAFFECTED, CrabsBackportBlocks.COPPER));
    public static final Block WAXED_EXPOSED_COPPER_DOOR = registerBlock("waxed_exposed_copper_door",
    new OxidizableDoorBlock(FabricBlockSettings.copyOf(Blocks.EXPOSED_COPPER).nonOpaque(), Oxidizable.OxidationLevel.EXPOSED, CrabsBackportBlocks.COPPER));
    public static final Block WAXED_OXIDIZED_COPPER_DOOR = registerBlock("waxed_oxidized_copper_door",
    new OxidizableDoorBlock(FabricBlockSettings.copyOf(Blocks.OXIDIZED_COPPER).nonOpaque(), Oxidizable.OxidationLevel.OXIDIZED, CrabsBackportBlocks.COPPER));
    public static final Block WAXED_WEATHERED_COPPER_DOOR = registerBlock("waxed_weathered_copper_door",
    new OxidizableDoorBlock(FabricBlockSettings.copyOf(Blocks.WEATHERED_COPPER).nonOpaque(), Oxidizable.OxidationLevel.WEATHERED, CrabsBackportBlocks.COPPER));
    public static final Block COPPER_GRATE = registerBlock("copper_grate",
           new OxidizableGrateBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)
                   .nonOpaque().sounds(CrabsBackportSounds.COPPER_GRATE), Oxidizable.OxidationLevel.UNAFFECTED));
    public static final Block EXPOSED_COPPER_GRATE = registerBlock("exposed_copper_grate",
    new OxidizableGrateBlock(FabricBlockSettings.copyOf(Blocks.EXPOSED_COPPER).nonOpaque().sounds(CrabsBackportSounds.COPPER_GRATE), Oxidizable.OxidationLevel.EXPOSED));
    public static final Block WEATHERED_COPPER_GRATE = registerBlock("weathered_copper_grate",
    new OxidizableGrateBlock(FabricBlockSettings.copyOf(Blocks.WEATHERED_COPPER).nonOpaque().sounds(CrabsBackportSounds.COPPER_GRATE), Oxidizable.OxidationLevel.WEATHERED));
    public static final Block OXIDIZED_COPPER_GRATE = registerBlock("oxidized_copper_grate",
    new OxidizableGrateBlock(FabricBlockSettings.copyOf(Blocks.OXIDIZED_COPPER).nonOpaque().sounds(CrabsBackportSounds.COPPER_GRATE), Oxidizable.OxidationLevel.OXIDIZED));
    public static final Block WAXED_COPPER_GRATE = registerBlock("waxed_copper_grate",
            new GrateBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).sounds(CrabsBackportSounds.COPPER_GRATE).nonOpaque()));
    public static final Block WAXED_EXPOSED_COPPER_GRATE = registerBlock("waxed_exposed_copper_grate",
    new GrateBlock(FabricBlockSettings.copyOf(Blocks.EXPOSED_COPPER).sounds(CrabsBackportSounds.COPPER_GRATE).nonOpaque()));
    public static final Block WAXED_WEATHERED_COPPER_GRATE = registerBlock("waxed_weathered_copper_grate",
    new GrateBlock(FabricBlockSettings.copyOf(Blocks.WEATHERED_COPPER).sounds(CrabsBackportSounds.COPPER_GRATE).nonOpaque()));
    public static final Block WAXED_OXIDIZED_COPPER_GRATE = registerBlock("waxed_oxidized_copper_grate",
    new GrateBlock(FabricBlockSettings.copyOf(Blocks.OXIDIZED_COPPER).sounds(CrabsBackportSounds.COPPER_GRATE).nonOpaque()));

    private static Block registerBlock(String name, Block block){
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CrabsBackport.MOD_ID, name), block);
    }
    public static BlockItem registerBlockItems(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(CrabsBackport.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    public static void registerBlocks() {
        CrabsBackport.LOGGER.info("Registering Blocks for " + CrabsBackport.MOD_ID);
    }
}
