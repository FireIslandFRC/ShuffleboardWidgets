package com.example.simplewidget;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

import java.util.List;
import java.util.Map;
import com.example.simplewidget.widget.LoadingBarringWidget;
import com.example.simplewidget.data.type.LoadingBarringType;

@Description(
    group = "com.example",
    name = "LoadingWidget",
    version = "209.1.1",
    summary="Load Bar"
)
public final class LoadingBarringPlugin extends Plugin {

  @Override
  public List<DataType> getDataTypes() {
    return List.of(
        LoadingBarringType.Instance
    );
  }

  @Override
  public List<ComponentType> getComponents() {
    return List.of(
        WidgetType.forAnnotatedWidget(LoadingBarringWidget.class)
    );
  }

  @Override
  public Map<DataType, ComponentType> getDefaultComponents() {
    return Map.of(
        LoadingBarringType.Instance, WidgetType.forAnnotatedWidget(LoadingBarringWidget.class)
    );
  }
}
