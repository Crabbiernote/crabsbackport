package crab.backport.datagen;

import crab.backport.CrabsBackportClient;
import crab.backport.block.CrabsBackportBlocks;
import crab.backport.item.CrabsBackportItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class CrabsBackportModelProvider extends FabricModelProvider {
    public CrabsBackportModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool paleoakpool = blockStateModelGenerator.registerCubeAllModelTexturePool(CrabsBackportBlocks.PALE_OAK_PLANKS);
        paleoakpool.family(CrabsBackportBlocks.PALE_OAK_FAMILY);
        paleoakpool.stairs(CrabsBackportBlocks.PALE_OAK_STAIRS);
        paleoakpool.slab(CrabsBackportBlocks.PALE_OAK_SLAB);
        paleoakpool.button(CrabsBackportBlocks.PALE_OAK_BUTTON);
        paleoakpool.fence(CrabsBackportBlocks.PALE_OAK_FENCE);
        paleoakpool.fenceGate(CrabsBackportBlocks.PALE_OAK_FENCE_GATE);
        paleoakpool.pressurePlate(CrabsBackportBlocks.PALE_OAK_PRESSURE_PLATE);
        blockStateModelGenerator.registerLog(CrabsBackportBlocks.PALE_OAK_LOG).log(CrabsBackportBlocks.PALE_OAK_LOG).wood(CrabsBackportBlocks.PALE_OAK_WOOD);
        blockStateModelGenerator.registerLog(CrabsBackportBlocks.STRIPPED_PALE_OAK_LOG).log(CrabsBackportBlocks.STRIPPED_PALE_OAK_LOG).wood(CrabsBackportBlocks.STRIPPED_PALE_OAK_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(CrabsBackportBlocks.PALE_OAK_LEAVES);
        blockStateModelGenerator.registerHangingSign(
                CrabsBackportBlocks.STRIPPED_PALE_OAK_LOG,
                CrabsBackportBlocks.PALE_OAK_HANGING_SIGN,
                CrabsBackportBlocks.PALE_OAK_HANGING_WALL_SIGN
        );
        blockStateModelGenerator.registerDoor(CrabsBackportBlocks.PALE_OAK_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(CrabsBackportBlocks.PALE_OAK_TRAPDOOR);
        blockStateModelGenerator.registerFlowerPotPlant(CrabsBackportBlocks.PALE_OAK_SAPLING, CrabsBackportBlocks.POTTED_PALE_OAK_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerWoolAndCarpet(CrabsBackportBlocks.PALE_MOSS_BLOCK, CrabsBackportBlocks.PALE_MOSS_CARPET);



    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
