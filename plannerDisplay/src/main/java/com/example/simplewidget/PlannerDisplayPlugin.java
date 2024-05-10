package com.example.simplewidget;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

//import com.example.simplewidget.data.type.GyroType;
import com.example.simplewidget.widget.PlannerDisplayWidget;
import com.example.simplewidget.data.type.PlannerDisplayType;
// import com.example.simplewidget.widget.LoadingBarringWidget;
// import com.example.simplewidget.widget.SometimesTextWidget;

import java.util.List;
import java.util.Map;

@Description(
    group = "com.example",
    name = "FieldWidget",
    version = "2019.1.1",
    summary="Pathplanner Field Display"
)
public class PlannerDisplayPlugin extends Plugin {
  
  @Override
  public List<DataType> getDataTypes() {
    return List.of(
        PlannerDisplayType.Instance
    );
  }

  @Override
  public List<ComponentType> getComponents() {
    return List.of(
        WidgetType.forAnnotatedWidget(PlannerDisplayWidget.class)
    );
  }
}
