package crab.backport.block;

import crab.backport.CrabsBackport;
import crab.backport.sound.CrabsBackportSounds;
import crab.backport.world.tree.PaleOakSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.createLightLevelFromLitBlockState;

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

    //Tuff

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

    //Foliage

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

    //Copper stuff

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


    public static final Block COPPER_BULB = registerBlock("copper_bulb",
            new OxidizableBulbBlock(
                    FabricBlockSettings.create()
                    .mapColor(MapColor.ORANGE)
                    .strength(3.0F, 6.0F)
                    .sounds(CrabsBackportSounds.COPPER_BULB)
                    .requiresTool()
                    .solidBlock(Blocks::never)
                    .luminance(createLightLevelFromLitBlockState(15)),
                    Oxidizable.OxidationLevel.UNAFFECTED));

    public static final Block EXPOSED_COPPER_BULB = registerBlock("exposed_copper_bulb",
            new OxidizableBulbBlock(FabricBlockSettings.copyOf(CrabsBackportBlocks.COPPER_BULB)
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    .luminance(createLightLevelFromLitBlockState(12)),
                    Oxidizable.OxidationLevel.EXPOSED));
    public static final Block WEATHERED_COPPER_BULB = registerBlock("weathered_copper_bulb",
            new OxidizableBulbBlock(FabricBlockSettings.copyOf(CrabsBackportBlocks.COPPER_BULB)
                    .mapColor(MapColor.DARK_AQUA)
                    .luminance(createLightLevelFromLitBlockState(8)),
                    Oxidizable.OxidationLevel.WEATHERED));
    public static final Block OXIDIZED_COPPER_BULB = registerBlock("oxidized_copper_bulb",
            new OxidizableBulbBlock(FabricBlockSettings.copyOf(CrabsBackportBlocks.COPPER_BULB)
                    .mapColor(MapColor.TEAL)
                    .luminance(createLightLevelFromLitBlockState(4)),
                    Oxidizable.OxidationLevel.OXIDIZED));
    public static final Block WAXED_COPPER_BULB = registerBlock("waxed_copper_bulb",
            new BulbBlock(FabricBlockSettings.copyOf(CrabsBackportBlocks.COPPER_BULB)));
    public static final Block WAXED_EXPOSED_COPPER_BULB = registerBlock("waxed_exposed_copper_bulb",
            new BulbBlock(FabricBlockSettings.copyOf(CrabsBackportBlocks.EXPOSED_COPPER_BULB)));
    public static final Block WAXED_WEATHERED_COPPER_BULB = registerBlock("waxed_weathered_copper_bulb",
            new BulbBlock(FabricBlockSettings.copyOf(CrabsBackportBlocks.WEATHERED_COPPER_BULB)));
    public static final Block WAXED_OXIDIZED_COPPER_BULB = registerBlock("waxed_oxidized_copper_bulb",
            new BulbBlock(FabricBlockSettings.copyOf(CrabsBackportBlocks.OXIDIZED_COPPER_BULB)));

    //Shelves

    public static final Block OAK_SHELF = registerBlock("oak_shelf",
            new ShelfBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).burnable().strength(2.0F, 3.0F)));
    public static final Block ACACIA_SHELF = registerBlock("acacia_shelf",
            new ShelfBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).burnable().strength(2.0F, 3.0F)));
    public static final Block BAMBOO_SHELF = registerBlock("bamboo_shelf",
            new ShelfBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).burnable().strength(2.0F, 3.0F)));
    public static final Block BIRCH_SHELF = registerBlock("birch_shelf",
            new ShelfBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).burnable().strength(2.0F, 3.0F)));
    public static final Block CHERRY_SHELF = registerBlock("cherry_shelf",
            new ShelfBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).burnable().strength(2.0F, 3.0F)));
    public static final Block CRIMSON_SHELF = registerBlock("crimson_shelf",
            new ShelfBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).burnable().strength(2.0F, 3.0F)));
    public static final Block DARK_OAK_SHELF = registerBlock("dark_oak_shelf",
            new ShelfBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).burnable().strength(2.0F, 3.0F)));
    public static final Block JUNGLE_SHELF = registerBlock("jungle_shelf",
            new ShelfBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).burnable().strength(2.0F, 3.0F)));
    public static final Block MANGROVE_SHELF = registerBlock("mangrove_shelf",
            new ShelfBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).burnable().strength(2.0F, 3.0F)));
    public static final Block PALE_OAK_SHELF = registerBlock("pale_oak_shelf",
            new ShelfBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).burnable().strength(2.0F, 3.0F)));
    public static final Block SPRUCE_SHELF = registerBlock("spruce_shelf",
            new ShelfBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).burnable().strength(2.0F, 3.0F)));
    public static final Block WARPED_SHELF = registerBlock("warped_shelf",
            new ShelfBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).sounds(BlockSoundGroup.CHISELED_BOOKSHELF).burnable().strength(2.0F, 3.0F)));

    //PALE OAK
    public static final Block PALE_OAK_LOG = registerBlock("pale_oak_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.STONE_GRAY)));
    public static final Block STRIPPED_PALE_OAK_LOG = registerBlock("stripped_pale_oak_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.OFF_WHITE)));
    public static final Block PALE_OAK_WOOD = registerBlock("pale_oak_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.STONE_GRAY)));
    public static final Block STRIPPED_PALE_OAK_WOOD = registerBlock("stripped_pale_oak_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.OFF_WHITE)));
    public static final Block PALE_OAK_PLANKS = registerBlock("pale_oak_planks",
            new Block(FabricBlockSettings.create()
                    .mapColor(MapColor.OFF_WHITE)
                    .instrument(Instrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));
    public static final Block PALE_OAK_LEAVES = registerBlock("pale_oak_leaves",
            new PaleOakLeavesBlock(FabricBlockSettings.create()
                    .mapColor(MapColor.IRON_GRAY)
                    .strength(0.2F)
                    .nonOpaque()
                    .sounds(BlockSoundGroup.GRASS)
                    .allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never )
                    .burnable()
                    .ticksRandomly()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));

    public static final Block PALE_OAK_SLAB = registerBlock("pale_oak_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).mapColor(MapColor.OFF_WHITE)
                    .instrument(Instrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));
    public static final Block PALE_OAK_STAIRS = registerBlock("pale_oak_stairs",
            new StairsBlock(CrabsBackportBlocks.PALE_OAK_PLANKS.getDefaultState(),
                    FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).mapColor(MapColor.OFF_WHITE)
                            .instrument(Instrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()));
    public static final Block PALE_OAK_FENCE = registerBlock("pale_oak_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(MapColor.OFF_WHITE)
                    .instrument(Instrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));

    public static final Block PALE_OAK_FENCE_GATE = registerBlock("pale_oak_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(MapColor.OFF_WHITE)
                    .instrument(Instrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable(),
                    CrabsBackportWoodTypes.PALE_OAK));
    public static final Block PALE_OAK_BUTTON = registerBlock("pale_oak_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).mapColor(MapColor.OFF_WHITE)
                    .instrument(Instrument.BASS)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable(),
                    CrabsBackportBlockSetTypes.PALE_OAK,
                    30,
                    true));
    public static final Block PALE_OAK_DOOR = registerBlock("pale_oak_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).mapColor(MapColor.OFF_WHITE)
                    .instrument(Instrument.BASS)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable(),
                    CrabsBackportBlockSetTypes.PALE_OAK));

    public static final Block PALE_OAK_TRAPDOOR = registerBlock("pale_oak_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).mapColor(MapColor.OFF_WHITE)
                    .instrument(Instrument.BASS)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .nonOpaque(),
                    CrabsBackportBlockSetTypes.PALE_OAK));
    public static final Block PALE_OAK_PRESSURE_PLATE = registerBlock("pale_oak_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.OFF_WHITE),
                    CrabsBackportBlockSetTypes.PALE_OAK));

    public static final Block PALE_OAK_SAPLING = registerBlock("pale_oak_sapling",
            new SaplingBlock(new PaleOakSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block POTTED_PALE_OAK_SAPLING = registerBlock("potted_pale_oak_sapling",
            new FlowerPotBlock(PALE_OAK_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_DARK_OAK_SAPLING).nonOpaque()));
    public static final Block PALE_OAK_SIGN = registerBlockWithoutItem("pale_oak_sign",
        new PaleOakSignBlock(FabricBlockSettings.create()
                .mapColor(MapColor.OFF_WHITE)
                .solid()
                .noCollision()
                .instrument(Instrument.BASS)
                .strength(1.0F)
                .burnable(),
                CrabsBackportWoodTypes.PALE_OAK));

    public static final Block PALE_OAK_WALL_SIGN =registerBlockWithoutItem("pale_oak_wall_sign",
        new PaleOakWallSignBlock(FabricBlockSettings.create()
                .mapColor(MapColor.OFF_WHITE)
                .solid()
                .noCollision()
                .instrument(Instrument.BASS)
                .strength(1.0F)
                .burnable(),
                CrabsBackportWoodTypes.PALE_OAK));

    public static final Block PALE_OAK_HANGING_SIGN = registerBlockWithoutItem("hanging_pale_oak_sign",
        new PaleOakHangingSignBlock(FabricBlockSettings.create()
                .mapColor(MapColor.OFF_WHITE)
                .solid()
                .noCollision()
                .instrument(Instrument.BASS)
                .strength(1.0F)
                .burnable(),
                CrabsBackportWoodTypes.PALE_OAK));

public static final Block PALE_OAK_HANGING_WALL_SIGN = registerBlockWithoutItem("pale_oak_hanging_wall_sign",
        new PaleOakWallHangingSign(FabricBlockSettings.create()
                .mapColor(MapColor.OFF_WHITE)
                .solid()
                .noCollision()
                .instrument(Instrument.BASS)
                .strength(1.0F)
                .burnable(),
                CrabsBackportWoodTypes.PALE_OAK));
public static final Block PALE_MOSS_BLOCK = registerBlock("pale_moss_block",
        new PaleMossBlock(FabricBlockSettings.create()
                .burnable()
                .mapColor(MapColor.OFF_WHITE)
                .strength(0.1F)
                .sounds(BlockSoundGroup.MOSS_BLOCK)
                .pistonBehavior(PistonBehavior.DESTROY)
                .requiresTool()));
public static final Block PALE_MOSS_CARPET = registerBlock("pale_moss_carpet",
        new CarpetBlock(FabricBlockSettings.create()
                .burnable()
                .mapColor(MapColor.OFF_WHITE)
                .strength(0.1F)
                .sounds(BlockSoundGroup.MOSS_CARPET)
                .pistonBehavior(PistonBehavior.DESTROY)
        ));

    public static final Block PALE_HANGING_MOSS = registerBlock("pale_hanging_moss",
            new HangingMossBlock(FabricBlockSettings.create()
                    .burnable()
                    .mapColor(MapColor.OFF_WHITE)
                    .breakInstantly()
                    .sounds(BlockSoundGroup.MOSS_CARPET)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .noCollision()
            ));

public static final BlockFamily PALE_OAK_FAMILY = BlockFamilies.register(CrabsBackportBlocks.PALE_OAK_PLANKS)
        .sign(PALE_OAK_SIGN, PALE_OAK_WALL_SIGN)
        .group("wooden").unlockCriterionName("has_planks").build();

    private static Block registerBlock(String name, Block block) {
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CrabsBackport.MOD_ID, name), block);
    }
    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(CrabsBackport.MOD_ID, name), block);
    }

    public static BlockItem registerBlockItems(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(CrabsBackport.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    public static void registerBlocks() {
        CrabsBackport.LOGGER.info("Registering Blocks for " + CrabsBackport.MOD_ID);
    }
    public static class CrabsBackportWoodTypes{
        public static final WoodType PALE_OAK = WoodTypeBuilder.copyOf(WoodType.OAK).register(Identifier.of(CrabsBackport.MOD_ID, "pale_oak"), CrabsBackportBlockSetTypes.PALE_OAK);
    }
    public static class CrabsBackportBlockSetTypes{
        public static BlockSetType PALE_OAK =register(new BlockSetType("pale_oak"));
        public static BlockSetType register(BlockSetType blockSetType){
            return blockSetType;

        }
    }

}

