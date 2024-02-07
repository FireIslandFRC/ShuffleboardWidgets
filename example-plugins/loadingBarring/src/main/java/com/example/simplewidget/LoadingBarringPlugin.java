package com.example.simplewidget;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

import com.example.simplewidget.widget.LoadingBarringWidget;

import java.util.List;
import java.util.Map;

@Description(
    group = "com.example",
    name = "LoadingBarring",
    version = "2019.1.1",
    summary="Load Barring"
)
public final class LoadingBarringPlugin extends Plugin {

  @Override
  public List<ComponentType> getComponents() {
    return List.of(
        WidgetType.forAnnotatedWidget(LoadingBarringWidget.class)
    );
  }

}
