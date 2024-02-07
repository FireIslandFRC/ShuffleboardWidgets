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
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import org.fxmisc.easybind.EasyBind;

@Description(name = "SometimesText", dataTypes = {Number.class})
@ParametrizedController("SometimesTextWidget.fxml")
public class SometimesTextWidget extends SimpleAnnotatedWidget<Object> {

  @FXML
  private StackPane root;

  @FXML
  private TextField textField;

  @FXML
  private ToggleButton itDoesntMatter;

 @FXML
  private void initialize() {
    StackPane.setMargin(textField, new Insets(10, 10, 10, 10));
    StackPane.setMargin(itDoesntMatter, new Insets(100, 10, 100, 10));

    dataProperty().addListener((__, prev, cur) -> {
      if (cur != null) {
        if (cur instanceof String) {
          textField.setText(cur.toString());
        }
      }
    });

    textField.textProperty().addListener((__, oldText, newText) -> {
      if (getData() instanceof Boolean) {
        // TODO maybe disable boolean text entry entirely? No point in typing "true" or "false" every time
        // Especially since checkboxes and toggle buttons exist
        setData(Boolean.valueOf(newText));
      } else {
        setData(newText);
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
    return (Pane)root;
  }

}
