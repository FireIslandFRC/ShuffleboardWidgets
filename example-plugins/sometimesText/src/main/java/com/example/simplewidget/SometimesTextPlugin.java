package com.example.simplewidget;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

import com.example.simplewidget.widget.SometimesTextWidget;

import java.util.List;
import java.util.Map;

@Description(
    group = "com.example",
    name = "SometimesText",
    version = "2019.1.1",
    summary="Widget which is an example"
)
public final class SometimesTextPlugin extends Plugin {
  
  @Override
  public List<ComponentType> getComponents() {
    return List.of(
      WidgetType.forAnnotatedWidget(SometimesTextWidget.class)
      );
    }

  //   @Override
  //   public List<DataType> getDataTypes() {
  //     return List.of(
  //         ExampleType.Instance
  //     );
  //   }
    
  // @Override
  // public Map<DataType, ComponentType> getDefaultComponents() {
  //   return Map.of(
  //       ExampleType.Instance, WidgetType.forAnnotatedWidget(ExampleWidget.class)
  //   );
  // }
}
