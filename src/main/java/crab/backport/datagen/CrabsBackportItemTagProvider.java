package crab.backport.datagen;

import crab.backport.block.CrabsBackportBlocks;
import crab.backport.block.CrabsBackportTags;
import crab.backport.item.CrabsBackportItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class CrabsBackportItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public CrabsBackportItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
            .add(CrabsBackportBlocks.PALE_OAK_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(CrabsBackportBlocks.PALE_OAK_LOG.asItem())
                .add(CrabsBackportBlocks.STRIPPED_PALE_OAK_LOG.asItem())
                .add(CrabsBackportBlocks.PALE_OAK_WOOD.asItem())
                .add(CrabsBackportBlocks.STRIPPED_PALE_OAK_WOOD.asItem());
        getOrCreateTagBuilder(CrabsBackportTags.Items.PALE_OAK_LOGS)
                .add(CrabsBackportBlocks.PALE_OAK_LOG.asItem())
                .add(CrabsBackportBlocks.STRIPPED_PALE_OAK_LOG.asItem())
                .add(CrabsBackportBlocks.PALE_OAK_WOOD.asItem())
                .add(CrabsBackportBlocks.STRIPPED_PALE_OAK_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.SIGNS)
                .add(CrabsBackportItems.PALE_OAK_SIGN);
        getOrCreateTagBuilder(ItemTags.HANGING_SIGNS)
                .add(CrabsBackportItems.PALE_OAK_HANGING_SIGN);
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(CrabsBackportBlocks.PALE_OAK_TRAPDOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                .add(CrabsBackportBlocks.PALE_OAK_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(CrabsBackportBlocks.PALE_OAK_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
            .add(CrabsBackportBlocks.PALE_OAK_FENCE_GATE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
            .add(CrabsBackportBlocks.PALE_OAK_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
            .add(CrabsBackportBlocks.PALE_OAK_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
            .add(CrabsBackportBlocks.PALE_OAK_BUTTON.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
            .add(CrabsBackportBlocks.PALE_OAK_PRESSURE_PLATE.asItem());

    }
    }
    
