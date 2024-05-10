package com.example.simplewidget.widget;

import edu.wpi.first.shuffleboard.api.prefs.Group;
import edu.wpi.first.shuffleboard.api.prefs.Setting;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;

import com.google.common.collect.ImmutableList;

import java.util.List;

import javax.management.ValueExp;

import javafx.beans.property.BooleanPropertyBase;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

import javafx.scene.layout.Pane;
import org.fxmisc.easybind.EasyBind;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.value.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javafx.stage.Stage;
import javafx.util.Duration;

import com.example.simplewidget.data.PlannerDisplayData;

@Description(name = "Planner Display", dataTypes = {PlannerDisplayData.class})
@ParametrizedController("PlannerDisplayWidget.fxml")
public class PlannerDisplayWidget extends SimpleAnnotatedWidget<PlannerDisplayData> {
    @FXML
    private Pane root;

    @FXML
    private TextField text;

    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;

    @FXML
    private void initialize() {
      graphicsContext = canvas.getGraphicsContext2D();
      //graphicsContext.setFill(Color.rgb(1, 1, 1));
        dataProperty().addListener((__, prev, cur) -> {
          graphicsContext.fillRect(0, 0, 10, 10);
          text.setText("" + cur.getValue());
        });
    }

  @Override
  public List<Group> getSettings() {
    return ImmutableList.of(

    );
  }

  @Override
  public Pane getView() {
    return root;
  }

  @FXML
  public void setValue() {
    setData(getData().withValue(Double.parseDouble(text.getText())));
  }
}