package me;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

import me.widget.MyFieldWidget;
import me.data.type.FieldType;

import java.util.List;
import java.util.Map;

@Description(
    group = "me",
    name = "MyField",
    version = "2019.1.1",
    summary="Field Which is Mine"
)
public final class MyFieldPlugin extends Plugin {
  @Override
  public List<ComponentType> getComponents() {
    return List.of(
      WidgetType.forAnnotatedWidget(MyFieldWidget.class)
      );
    }

    @Override
    public List<DataType> getDataTypes() {
      return List.of(
          FieldType.Instance
      );
    }
    
  @Override
  public Map<DataType, ComponentType> getDefaultComponents() {
    return Map.of(
        FieldType.Instance, WidgetType.forAnnotatedWidget(MyFieldWidget.class)
    );
  }
}