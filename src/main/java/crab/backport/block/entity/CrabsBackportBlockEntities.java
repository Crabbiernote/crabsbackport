package crab.backport.block.entity;

import crab.backport.CrabsBackport;
import crab.backport.block.CrabsBackportBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CrabsBackportBlockEntities {

    public static final BlockEntityType<ShelfBlockEntity> SHELF_BLOCK_ENTITY =
            registerBlockEntity("shelf_block_entity",
                    ShelfBlockEntity::new,
                    CrabsBackportBlocks.OAK_SHELF,
                    CrabsBackportBlocks.ACACIA_SHELF,
                    CrabsBackportBlocks.BAMBOO_SHELF,
                    CrabsBackportBlocks.BIRCH_SHELF,
                    CrabsBackportBlocks.CHERRY_SHELF,
                    CrabsBackportBlocks.CRIMSON_SHELF,
                    CrabsBackportBlocks.DARK_OAK_SHELF,
                    CrabsBackportBlocks.JUNGLE_SHELF,
                    CrabsBackportBlocks.MANGROVE_SHELF,
                    CrabsBackportBlocks.PALE_OAK_SHELF,
                    CrabsBackportBlocks.SPRUCE_SHELF,
                    CrabsBackportBlocks.WARPED_SHELF
            );

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, FabricBlockEntityTypeBuilder.Factory<T> blockEntityType, Block... block) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CrabsBackport.MOD_ID, name),
                FabricBlockEntityTypeBuilder.create(blockEntityType, block).build());
    }

    public static void registerBlockEntities() {
        CrabsBackport.LOGGER.info("Registering Block Entities for " + CrabsBackport.MOD_ID);
    }
}
