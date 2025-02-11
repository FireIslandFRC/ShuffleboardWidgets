package com.example.simplewidget.data.type;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;
import com.example.simplewidget.data.OctagonData;

import java.util.Map;
import java.util.function.Function;

public class OctagonType extends ComplexDataType<OctagonData> {

  public static final OctagonType Instance = new OctagonType();

  private OctagonType() {
    super("Octagon", OctagonData.class);
  }

  @Override
  public Function<Map<String, Object>, OctagonData> fromMap() {
    return OctagonData::new;
  }

  @Override
  public OctagonData getDefaultValue() {
    return new OctagonData(0, 0);
  }

}
