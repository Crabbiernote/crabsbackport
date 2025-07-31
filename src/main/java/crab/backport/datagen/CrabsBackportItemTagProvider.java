package crab.backport.datagen;

import crab.backport.item.CrabsBackportItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class CrabsBackportItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public CrabsBackportItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(CrabsBackportItems.MUSIC_DISC_LAVA_CHICKEN)
                .add(CrabsBackportItems.MUSIC_DISC_TEARS)
                .add(CrabsBackportItems.MUSIC_DISC_PRECIPICE)
                .add(CrabsBackportItems.MUSIC_DISC_CREATOR)
                .add(CrabsBackportItems.MUSIC_DISC_CREATOR_MUSIC_BOX);

    }
}
