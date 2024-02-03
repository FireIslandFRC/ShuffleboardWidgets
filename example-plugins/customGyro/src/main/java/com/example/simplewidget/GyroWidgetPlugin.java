package com.example.simplewidget;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

import com.example.simplewidget.data.type.GyroType;
import com.example.simplewidget.widget.GyroWidget;

import java.util.List;
import java.util.Map;

@Description(
    group = "com.example",
    name = "RadiableWidget",
    version = "2019.1.1",
    summary="Gyro but radians"
)
public final class GyroWidgetPlugin extends Plugin {

  @Override
  public List<DataType> getDataTypes() {
    return List.of(
        GyroType.Instance
    );
  }

  @Override
  public List<ComponentType> getComponents() {
    return List.of(
        WidgetType.forAnnotatedWidget(GyroWidget.class)
    );
  }

  @Override
  public Map<DataType, ComponentType> getDefaultComponents() {
    return Map.of(
        GyroType.Instance, WidgetType.forAnnotatedWidget(GyroWidget.class)
    );
  }
}
