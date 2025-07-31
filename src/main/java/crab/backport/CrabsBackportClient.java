package crab.backport;

import crab.backport.block.CrabsBackportBlocks;
import crab.backport.block.entity.CrabsBackportBlockEntities;
import crab.backport.client.render.block.entity.ShelfBlockEntityRenderer;
import crab.backport.particles.FireflyParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT)
public class CrabsBackportClient implements ClientModInitializer {
    public static DefaultParticleType FIREFLY = CrabsBackport.FIREFLY;

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(FIREFLY, FireflyParticle.FireflyFactory::new);

        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.LEAF_LITTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WILDFLOWERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.FIREFLY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.SHORT_DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.TALL_DRY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.EXPOSED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WEATHERED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.OXIDIZED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WAXED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.EXPOSED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WEATHERED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.OXIDIZED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WAXED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.COPPER_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.EXPOSED_COPPER_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WEATHERED_COPPER_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.OXIDIZED_COPPER_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WAXED_COPPER_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WAXED_EXPOSED_COPPER_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WAXED_WEATHERED_COPPER_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.WAXED_OXIDIZED_COPPER_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.CACTUS_FLOWER, RenderLayer.getCutout());
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return GrassColors.getColor(0.5, 1.0);
            }
            return BiomeColors.getGrassColor(world, pos);
        }, CrabsBackportBlocks.BUSH);
        ColorProviderRegistry.ITEM.register((stack, layer) -> GrassColors.getColor(0.5, 1.0), CrabsBackportBlocks.BUSH);
        BlockEntityRendererFactories.register(CrabsBackportBlockEntities.SHELF_BLOCK_ENTITY, ShelfBlockEntityRenderer::new);
    }
}
