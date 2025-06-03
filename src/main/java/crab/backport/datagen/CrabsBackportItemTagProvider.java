package crab.backport.datagen;

import crab.backport.block.CrabsBackportBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CrabsBackportItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public CrabsBackportItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable FabricTagProvider.BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.FLOWERS).add(
                CrabsBackportBlocks.WILDFLOWERS.asItem()
        );

    }
}
