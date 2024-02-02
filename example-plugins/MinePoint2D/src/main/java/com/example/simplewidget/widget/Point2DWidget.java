package com.example.simplewidget.widget; 

import java.util.Map;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import com.example.simplewidget.data.MyPoint2D;

@Description(name = "MyPoint2D", dataTypes = MyPoint2D.class, summary = "ddfsfd")
@ParametrizedController("Point2DWidget.fxml")
public final class Point2DWidget extends SimpleAnnotatedWidget<MyPoint2D> {

   @FXML
   private Pane root;

   @FXML
   private Slider xSlider;

   @FXML
   private Slider ySlider;

   @FXML
   private void initialize() {
      xSlider.valueProperty().bind(dataOrDefault.map(MyPoint2D::getX));
      ySlider.valueProperty().bind(dataOrDefault.map(MyPoint2D::getY));
   }

   @Override
   public Pane getView() {
      return root;
   }

 }