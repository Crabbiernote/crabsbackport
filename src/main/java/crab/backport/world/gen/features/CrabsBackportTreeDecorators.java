package crab.backport.world.gen.features;

import crab.backport.CrabsBackport;
import com.mojang.serialization.Codec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class CrabsBackportTreeDecorators {
    public static final TreeDecoratorType<AttachedToLogsTreeDecorator> ATTACHED_TO_LOGS =
            register("attached_to_logs", AttachedToLogsTreeDecorator.CODEC);

    private static <P extends TreeDecorator> TreeDecoratorType<P> register(String id, Codec<P> codec) {
        return Registry.register(Registries.TREE_DECORATOR_TYPE, new Identifier(CrabsBackport.MOD_ID, id), new TreeDecoratorType<>(codec));
    }

    public static void init() {
        CrabsBackport.LOGGER.info("Registering tree decorators for " + CrabsBackport.MOD_ID);
        // Force static initialization by referencing the field
        CrabsBackport.LOGGER.debug("Registered ATTACHED_TO_LOGS: " + ATTACHED_TO_LOGS);
    }
}