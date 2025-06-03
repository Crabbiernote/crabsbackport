package crab.backport.mixin;

import net.minecraft.client.render.WorldRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
    @Shadow
    @Final
    private static Identifier CLOUDS = new Identifier("crabsbackport:textures/environments/clouds.png");

}
