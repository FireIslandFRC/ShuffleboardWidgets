package com.example.simplewidget;

import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.data.ComplexData;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.data.DataType;

import edu.wpi.first.shuffleboard.api.widget.WidgetType;
import com.example.simplewidget.widget.Point2DWidget;
import com.example.simplewidget.data.type.PointType;

import java.util.Map;
import java.util.List;

@Description(group = "com.example", name = "MyPlugin", version = "1.2.3", summary = "An example plugin")
public class MyPlugin extends Plugin {

    @Override
    public List<DataType> getDataTypes() {
       return List.of(PointType.Instance);
    }

    @Override
    public List<ComponentType> getComponents() {
        return List.of(WidgetType.forAnnotatedWidget(Point2DWidget.class));
    }

    // @Override
    // public Map<DataType, ComponentType> getDefaultComponents() {
    //     return Map.of(PointType.Instance, WidgetType.forAnnotatedWidget(Point2DWidget.class));
    // }
}