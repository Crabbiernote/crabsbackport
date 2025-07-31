package crab.backport.mixin;

import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BeaconBlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import static net.minecraft.client.render.block.entity.BeaconBlockEntityRenderer.BEAM_TEXTURE;

@Mixin(BeaconBlockEntityRenderer.class)
public abstract class BeaconBlockEntityRendererMixin {
    @Shadow
    public static void renderBeam(
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            Identifier textureId,
            float tickDelta,
            float heightScale,
            long worldTime,
            int yOffset,
            int maxY,
            float[] color,
            float innerRadius,
            float outerRadius
    ) {
    }

    @Shadow
    protected static void renderBeam(MatrixStack matrices, VertexConsumerProvider vertexConsumers, float tickDelta, long worldTime, int yOffset, int maxY, float[] color) {
    }

    private static final ThreadLocal<BeaconBlockEntity> currentBeacon = new ThreadLocal<>();

    @Inject(method = "render", at = @At("HEAD"))
    private void storeBeaconEntity(BeaconBlockEntity beaconBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j, CallbackInfo ci) {
        currentBeacon.set(beaconBlockEntity);
        long l = beaconBlockEntity.getWorld().getTime();
        List<BeaconBlockEntity.BeamSegment> list = beaconBlockEntity.getBeamSegments();
        int k = 0;

        for (int m = 0; m < list.size(); m++) {
            BeaconBlockEntity.BeamSegment beamSegment = (BeaconBlockEntity.BeamSegment) list.get(m);
            renderBeam(matrixStack, vertexConsumerProvider, f, l, k, m == list.size() - 1 ? 2024 : beamSegment.getHeight(), beamSegment.getColor());
            k += beamSegment.getHeight();
        }
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void clearBeaconEntity(BeaconBlockEntity beaconBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j, CallbackInfo ci) {
        currentBeacon.remove();
    }


    @Inject(method = "renderBeam(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;FJII[F)V", at = @At("HEAD"))
    private static void makebeambeeg(MatrixStack matrices, VertexConsumerProvider vertexConsumers, float tickDelta, long worldTime, int yOffset, int maxY, float[] color, CallbackInfo ci) {
        BeaconBlockEntity beaconBlockEntity = currentBeacon.get();
        if (beaconBlockEntity == null) return;

        ClientPlayerEntity clientPlayerEntity = MinecraftClient.getInstance().player;
        if (clientPlayerEntity == null) return;
        Vec3d cameraPos = clientPlayerEntity.getCameraPosVec(tickDelta);
        float distance = (float) cameraPos.subtract(beaconBlockEntity.getPos().toCenterPos()).horizontalLength();
        float scale = clientPlayerEntity.isUsingSpyglass() ? 1.0F : Math.max(1.0F, distance / 64.0F); // Example scaling
        renderBeam(matrices, vertexConsumers, BEAM_TEXTURE, tickDelta, scale, worldTime, yOffset, maxY, color, 0.2F * scale, 0.25F * scale);
    }
}