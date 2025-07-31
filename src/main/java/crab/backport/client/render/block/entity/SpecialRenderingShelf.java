package crab.backport.client.render.block.entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public interface SpecialRenderingShelf {
    World getWorld();

    Vec3d getPos();

    float getBodyYaw();

    @Nullable
    default LivingEntity method_72393() {
        return null;
    }

    static SpecialRenderingShelf method_72392(Vec3d vec3d, Direction direction, World world) {
        return new SpecialRenderingShelf.class_11567(vec3d, getHorizontalDegrees(direction), world);
    }

    public record class_11567(Vec3d getPos, float getBodyYaw, World getWorld) implements SpecialRenderingShelf {
    }

    public static float getHorizontalDegrees(Direction direction) {
        return switch (direction) {
            case NORTH -> 180.0F;
            case SOUTH -> 0.0F;
            case WEST -> 90.0F;
            case EAST -> -90.0F;
            default -> throw new IllegalStateException("No y-Rot for vertical axis: " + direction);
        };
    }
}
