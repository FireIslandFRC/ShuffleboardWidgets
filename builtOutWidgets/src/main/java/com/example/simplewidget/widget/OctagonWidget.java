package com.example.simplewidget.widget;

import edu.wpi.first.shuffleboard.api.components.NumberField;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import com.example.simplewidget.data.OctagonData;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

@Description(name = "Octagon", dataTypes = OctagonData.class)
@ParametrizedController("Octagon.fxml")
public class OctagonWidget extends SimpleAnnotatedWidget<OctagonData> {

  @FXML
  private Pane root;
  
  private Circle[] reef;
  private Circle[] levels;

  private Paint on = Paint.valueOf("#ff8800");
  private Paint off = Paint.valueOf("#000000");

  @FXML
  private void initialize() {
    reef = new Circle[12];
    for (int i = 0; i < 12; i++) {
      Circle circle = (Circle)root.getChildren().get(i);
      int index = Integer.parseInt(circle.getId());
      if (index < 12) reef[index] = circle;
      else levels[index - 12] = circle;
    }

    dataProperty().addListener((__, oldData, newData) -> {
      if (oldData != null) {
        reef[oldData.getButton()].setFill(off);
        levels[oldData.getButton()].setFill(off);
      }
      if (newData != null) {
        reef[newData.getLevel()].setFill(on);
        levels[newData.getLevel()].setFill(on);
      }
    });
  }

  @Override
  public Pane getView() {
    return root;
  }
}
