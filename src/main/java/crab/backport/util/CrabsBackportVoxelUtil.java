package crab.backport.util;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import it.unimi.dsi.fastutil.doubles.DoubleList;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.util.Util;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.DirectionTransformation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.ArrayVoxelShape;
import net.minecraft.util.shape.SimpleVoxelShape;
import net.minecraft.util.shape.VoxelSet;
import net.minecraft.util.shape.VoxelShape;

import java.util.Map;

import static net.minecraft.util.math.DirectionTransformation.*;

public class CrabsBackportVoxelUtil {
//    private static final Vec3d BLOCK_CENTER = new Vec3d(0.5, 0.5, 0.5);
//    public static Map<Direction, VoxelShape> createHorizontalFacingShapeMap(VoxelShape shape) {
//        return createHorizontalFacingShapeMap(shape, BLOCK_CENTER);
//    }
//    public static Map<Direction, VoxelShape> createHorizontalFacingShapeMap(VoxelShape shape, Vec3d anchor) {
//        return Maps.newEnumMap(
//                Map.of(
//                        Direction.NORTH,
//                        shape,
//                        Direction.EAST,
//                        transform(shape, fromRotations(AxisRotation.R0, AxisRotation.R90), anchor),
//                        Direction.SOUTH,
//                        transform(shape, fromRotations(AxisRotation.R0, AxisRotation.R180), anchor),
//                        Direction.WEST,
//                        transform(shape, fromRotations(AxisRotation.R0, AxisRotation.R270), anchor)
//                )
//        );
//    }
//    public static VoxelShape transform(VoxelShape shape, DirectionTransformation transformation) {
//        return transform(shape, transformation, BLOCK_CENTER);
//    }
//    public static VoxelShape transform(VoxelShape shape, DirectionTransformation transformation, Vec3d anchor) {
//        if (transformation == IDENTITY) {
//            return shape;
//        } else {
//            VoxelSet voxelSet = shape.voxels.transform(transformation);
//            if (shape instanceof SimpleVoxelShape && BLOCK_CENTER.equals(anchor)) {
//                 return crab.backport.mixin.SimpleVoxelShapeAccessor.create(voxelSet);;
//            } else {
//                Direction.Axis axis = transformation.map(Direction.Axis.X);
//                Direction.Axis axis2 = transformation.map(Direction.Axis.Y);
//                Direction.Axis axis3 = transformation.map(Direction.Axis.Z);
//                DoubleList doubleList = shape.getPointPositions(axis);
//                DoubleList doubleList2 = shape.getPointPositions(axis2);
//                DoubleList doubleList3 = shape.getPointPositions(axis3);
//                boolean bl = transformation.shouldFlipDirection(axis);
//                boolean bl2 = transformation.shouldFlipDirection(axis2);
//                boolean bl3 = transformation.shouldFlipDirection(axis3);
//                boolean bl4 = axis.choose(bl, bl2, bl3);
//                boolean bl5 = axis2.choose(bl, bl2, bl3);
//                boolean bl6 = axis3.choose(bl, bl2, bl3);
//                return new ArrayVoxelShape(
//                        voxelSet,
//                        transform(doubleList, bl4, anchor.getComponentAlongAxis(axis), anchor.x),
//                        transform(doubleList2, bl5, anchor.getComponentAlongAxis(axis2), anchor.y),
//                        transform(doubleList3, bl6, anchor.getComponentAlongAxis(axis3), anchor.z)
//                );
//            }
//        }
//    }
//
//    public static Map<Direction, VoxelShape> createFacingShapeMap(VoxelShape shape) {
//        return createFacingShapeMap(shape, BLOCK_CENTER);
//    }
//
//    public static Map<Direction, VoxelShape> createFacingShapeMap(VoxelShape shape, Vec3d anchor) {
//        return Maps.newEnumMap(
//                Map.of(
//                        Direction.NORTH,
//                        shape,
//                        Direction.EAST,
//                        transform(shape, fromRotations(AxisRotation.R0, AxisRotation.R90), anchor),
//                        Direction.SOUTH,
//                        transform(shape, fromRotations(AxisRotation.R0, AxisRotation.R180), anchor),
//                        Direction.WEST,
//                        transform(shape, fromRotations(AxisRotation.R0, AxisRotation.R270), anchor),
//                        Direction.UP,
//                        transform(shape, fromRotations(AxisRotation.R270, AxisRotation.R0), anchor),
//                        Direction.DOWN,
//                        transform(shape, fromRotations(AxisRotation.R90, AxisRotation.R0), anchor)
//                )
//        );
//    }
//
//    @VisibleForTesting
//    static DoubleList transform(DoubleList pointPositions, boolean flip, double component, double anchor) {
//        if (!flip && component == anchor) {
//            return pointPositions;
//        } else {
//            int i = pointPositions.size();
//            DoubleList doubleList = new DoubleArrayList(i);
//            int j = flip ? -1 : 1;
//
//            for (int k = flip ? i - 1 : 0; k >= 0 && k < i; k += j) {
//                doubleList.add(anchor + j * (pointPositions.getDouble(k) - component));
//            }
//
//            return doubleList;
//        }
//    }
//    public static DirectionTransformation fromRotations(AxisRotation x, AxisRotation y) {
//        return BY_ROTATIONS[x.ordinal()][y.ordinal()];
//    }
//    private static final DirectionTransformation[][] BY_ROTATIONS = Util.make(
//            new DirectionTransformation[AxisRotation.values().length][AxisRotation.values().length], byRotations -> {
//                for (AxisRotation axisRotation : AxisRotation.values()) {
//                    for (AxisRotation axisRotation2 : AxisRotation.values()) {
//                        DirectionTransformation directionTransformation = IDENTITY;
//
//                        for (int i = 0; i < axisRotation2.index; i++) {
//                            directionTransformation = directionTransformation.prepend(ROT_90_Y_NEG);
//                        }
//
//                        for (int i = 0; i < axisRotation.index; i++) {
//                            directionTransformation = directionTransformation.prepend(ROT_90_X_NEG);
//                        }
//
//                        byRotations[axisRotation.ordinal()][axisRotation2.ordinal()] = directionTransformation;
//                    }
//                }
//            }
//    );

}
