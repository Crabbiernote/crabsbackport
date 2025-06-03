package crab.backport.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class FireflyParticle extends SpriteBillboardParticle {
    private static final float field_56500 = 0.5F;
    private static final float field_56501 = 0.3F;
    private static final int MIN_MAX_AGE = 36;
    private static final int MAX_MAX_AGE = 180;
    protected FireflyParticle(ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
        super(clientWorld, d, e, f, g, h, i);
        this.ascending = true;
        this.velocityMultiplier = 0.96F;
        this.scale *= 0.75F;
        this.velocityY *= 0.8F;
        this.velocityX *= 0.8F;
        this.velocityZ *= 0.8F;
    }
    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }
    @Override
    public int getBrightness(float tint) {
        float f = MathHelper.clamp(((float)this.age + tint) / (float)this.maxAge, 0.0F, 1.0F);
        if (f > 0.5F) {
            float g = (1.0F - f) / 0.5F;
            return (int)(255.0F * g);
        } else if (f < 0.3F) {
            float g = f / 0.3F;
            return (int)(255.0F * g);
        } else {
            return 255;
        }
    }
    @Override
    public void tick() {
        super.tick();
        if (!this.world.getBlockState(BlockPos.ofFloored(this.x, this.y, this.z)).isAir()) {
            this.markDead();
        } else {
            if (Math.random() > 0.95 || this.age == 1) {
                this.setVelocity(-0.05F + 0.1F * Math.random(), -0.05F + 0.1F * Math.random(), -0.05F + 0.1F * Math.random());
            }
        }
    }
    @Environment(EnvType.CLIENT)
    public static class FireflyFactory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public FireflyFactory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(DefaultParticleType simpleParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            FireflyParticle fireflyParticle = new FireflyParticle(
                    clientWorld, d, e, f, 0.5 - clientWorld.random.nextDouble(), clientWorld.random.nextBoolean() ? h : -h, 0.5 - clientWorld.random.nextDouble()
            );
            fireflyParticle.setMaxAge(clientWorld.random.nextBetween(36, 180));
            fireflyParticle.scale(1.5F);
            fireflyParticle.setSprite(this.spriteProvider);
            return fireflyParticle;
        }
    }

}

