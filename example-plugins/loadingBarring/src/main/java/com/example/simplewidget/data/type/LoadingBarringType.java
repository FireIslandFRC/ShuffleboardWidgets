package com.example.simplewidget.data.type;

import com.example.simplewidget.data.LoadingBarringData;
import edu.wpi.first.shuffleboard.api.data.ComplexDataType;

import java.util.Map;
import java.util.function.Function;

public final class LoadingBarringType extends ComplexDataType<LoadingBarringData> {

  public static final LoadingBarringType Instance = new LoadingBarringType();

  private LoadingBarringType() {
    super("Loading Bar", LoadingBarringData.class);
  }

  @Override
  public Function<Map<String, Object>, LoadingBarringData> fromMap() {
    return LoadingBarringData::new;
  }

  @Override
  public LoadingBarringData getDefaultValue() {
    return new LoadingBarringData("example", 0);
  }

}
