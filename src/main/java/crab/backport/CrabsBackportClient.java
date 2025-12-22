package crab.backport;

import crab.backport.block.CrabsBackportBlocks;
import crab.backport.block.entity.CrabsBackportBlockEntities;
import crab.backport.client.render.block.entity.ShelfBlockEntityRenderer;
import crab.backport.particles.FireflyParticle;
import crab.backport.particles.PaleOakLeavesParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT)
public class CrabsBackportClient implements ClientModInitializer {
    public static DefaultParticleType FIREFLY = CrabsBackport.FIREFLY;
    public static DefaultParticleType PALE_OAK_LEAVES = CrabsBackport.PALE_OAK_LEAVES;

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(FIREFLY, FireflyParticle.FireflyFactory::new);
        ParticleFactoryRegistry.getInstance().register(PALE_OAK_LEAVES, PaleOakLeavesParticle.PaleOakLeavesFactory::new);

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
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.PALE_OAK_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.PALE_OAK_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.PALE_OAK_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.PALE_OAK_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.PALE_HANGING_MOSS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CrabsBackportBlocks.POTTED_PALE_OAK_SAPLING, RenderLayer.getCutout());
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return GrassColors.getColor(0.5, 1.0);
            }
            return BiomeColors.getGrassColor(world, pos);
        }, CrabsBackportBlocks.BUSH);
        ColorProviderRegistry.ITEM.register((stack, layer) -> GrassColors.getColor(0.5, 1.0), CrabsBackportBlocks.BUSH);
        BlockEntityRendererFactories.register(CrabsBackportBlockEntities.SHELF_BLOCK_ENTITY, ShelfBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(CrabsBackportBlockEntities.PALE_OAK_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(CrabsBackportBlockEntities.PALE_OAK_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);
    }
}
