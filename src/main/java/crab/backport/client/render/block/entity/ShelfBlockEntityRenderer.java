package crab.backport.client.render.block.entity;

import crab.backport.block.ShelfBlock;
import crab.backport.block.entity.ShelfBlockEntity;
import it.unimi.dsi.fastutil.HashCommon;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;

@Environment(EnvType.CLIENT)
public class ShelfBlockEntityRenderer implements BlockEntityRenderer<ShelfBlockEntity> {
    private final ItemRenderer itemRenderer;

    public ShelfBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(ShelfBlockEntity shelfBlockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        Direction direction = (Direction) shelfBlockEntity.getCachedState().get(ShelfBlock.FACING);
        DefaultedList<ItemStack> defaultedList = shelfBlockEntity.getHeldStacks();
        int k = HashCommon.long2int(shelfBlockEntity.getPos().asLong());
        float g = direction.getAxis().isHorizontal() ? 180.0F - getpositiveHorizontalDegrees(direction) : 180.0F;

        for (int l = 0; l < defaultedList.size(); l++) {
            ItemStack itemStack = (ItemStack) defaultedList.get(l);
            if (!itemStack.isEmpty()) {
                this.renderItem(shelfBlockEntity, matrices, vertexConsumers, light, overlay, l, shelfBlockEntity.getPos(), direction, g, itemStack, k);
            }
        }
    }

    private void renderItem(
            ShelfBlockEntity entity,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            int overlay,
            int itemIndex,
            BlockPos pos,
            Direction facing,
            float f,
            ItemStack stack,
            int i
    ) {
        float g = (1 - itemIndex) * 0.3125F;
        Vec3d vec3d = new Vec3d(g, 0.0, 0.3125);
        matrices.push();
        matrices.translate(0.5F, 0.5F, 0.5F);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f));
        matrices.translate(vec3d.x, vec3d.y, vec3d.z);
        matrices.scale(0.25F, 0.25F, 0.25F);
        Vec3d vec3d2 = pos.toCenterPos().add(vec3d.rotateY(f * (float) (Math.PI / 180.0)));
        this.itemRenderer
                .renderItem(stack, ModelTransformationMode.FIXED, light, overlay, matrices, vertexConsumers, entity.getWorld(), i + itemIndex);
        matrices.pop();
    }

    public float getpositiveHorizontalDegrees(Direction direction) {
        return (direction.getHorizontal() & 3) * 90;
    }


}
