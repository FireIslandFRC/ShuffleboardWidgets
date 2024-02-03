package com.example.simplewidget.data.type;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;
import com.example.simplewidget.data.GyroData;

import java.util.Map;
import java.util.function.Function;

public final class GyroType extends ComplexDataType<GyroData> {

  public static final GyroType Instance = new GyroType();

  private GyroType() {
    super("RadiableGyro", GyroData.class);
  }

  @Override
  public Function<Map<String, Object>, GyroData> fromMap() {
    return GyroData::new;
  }

  @Override
  public GyroData getDefaultValue() {
    return new GyroData(0);
  }

}
