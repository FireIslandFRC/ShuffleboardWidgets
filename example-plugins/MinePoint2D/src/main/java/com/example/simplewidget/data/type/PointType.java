package com.example.simplewidget.data.type;

import com.example.simplewidget.data.MyPoint2D;
import edu.wpi.first.shuffleboard.api.data.ComplexDataType;
import edu.wpi.first.shuffleboard.api.data.DataType;
import java.util.Map;
import java.util.function.Function;

public final class PointType extends ComplexDataType<MyPoint2D> {

   private static final String NAME = "MyPoint2D";
   public static final PointType Instance = new PointType();

   private PointType() {
      super(NAME, MyPoint2D.class);
   }

   @Override
   public Function<Map<String, Object>, MyPoint2D> fromMap() {
      return map -> {
         return new MyPoint2D((double) map.getOrDefault("x", 0.0), (double) map.getOrDefault("y", 0.0));
      };
   }

   @Override
   public MyPoint2D getDefaultValue() {
      // use default values of 0 for X and Y coordinates
      return new MyPoint2D(0, 0);
   }

}