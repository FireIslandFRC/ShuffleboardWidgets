package com.example.simplewidget.widget;

import eu.hansolo.medusa.Gauge;

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
import javafx.stage.Stage;
import javafx.util.Duration;

@Description(name = "Loading Bar", dataTypes = {Number.class})
@ParametrizedController("LoadingBarringWidget.fxml")
public class LoadingBarringWidget extends SimpleAnnotatedWidget<Number> {

  @FXML
  private Pane root;
  @FXML
  private ProgressBar loadingBar;

  private static final String RED_BAR    = "red-bar";
  private static final String YELLOW_BAR = "yellow-bar";
  private static final String ORANGE_BAR = "orange-bar";
  private static final String GREEN_BAR  = "green-bar";
  private static final String[] barColorStyleClasses = { RED_BAR, ORANGE_BAR, YELLOW_BAR, GREEN_BAR };

  @FXML
  private void initialize() {
    dataProperty().addListener((__, prev, cur) -> {
      if (cur != null) {
        if (cur instanceof Number) {
          loadingBar.setProgress(((Number)cur).doubleValue());
        }
      }
    });
    loadingBar.progressProperty().addListener(new ChangeListener<Number>() {
      @Override public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        double progress = newValue == null ? 0 : newValue.doubleValue();
        if (progress < 0.2) {
          setBarStyleClass(loadingBar, RED_BAR);
        } else if (progress < 0.4) {
          setBarStyleClass(loadingBar, ORANGE_BAR);
        } else if (progress < 0.6) {
          setBarStyleClass(loadingBar, YELLOW_BAR);
        } else {
          setBarStyleClass(loadingBar, GREEN_BAR);
        }
      }

      private void setBarStyleClass(ProgressBar loadingBar, String barStyleClass) {
        loadingBar.getStyleClass().removeAll(barColorStyleClasses);
        loadingBar.getStyleClass().add(barStyleClass);
      }
    });
  }

  @Override
  public Pane getView() {
    return root;
  }

}
