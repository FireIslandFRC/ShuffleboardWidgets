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
import javafx.scene.control.TextField;

import javafx.scene.layout.Pane;
import org.fxmisc.easybind.EasyBind;

@Description(name = "TestWidget", dataTypes = {Number.class, String.class})
@ParametrizedController("FxmlWidget.fxml")
public class TestWidget extends SimpleAnnotatedWidget<Object> {

  @FXML
  private Pane root;

  @FXML
  private void initialize() {
    dataProperty().addListener((__, prev, cur) -> {
      if (cur != null) {

      }
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

}
