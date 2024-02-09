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
import org.fxmisc.easybind.monadic.MonadicBinding;
import edu.wpi.first.shuffleboard.api.sources.DataSourceUtils;
import edu.wpi.first.shuffleboard.api.sources.DataSource;

import com.example.simplewidget.data.SometimesTextData;

@Description(name = "Sometimes Text", dataTypes = {SometimesTextData.class})
@ParametrizedController("SometimesTextWidget.fxml")
public class SometimesTextWidget extends SimpleAnnotatedWidget<SometimesTextData> {

  @FXML
  private Pane root;

  @FXML
  private TextField textField;

  @FXML
  private ToggleButton itDoesntMatter;

 @FXML
  private void initialize() {
    dataProperty().addListener((__, prev, cur) -> {
      if (cur != null) {
        textField.setText(cur.getText());
        itDoesntMatter.setSelected(cur.getSometimes());
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

  @FXML
  public void setText() {
    setData(getData().withText(textField.getText()));
  }

  @FXML
  public void setSometimes() {
    setData(getData().withSometimes(itDoesntMatter.isSelected()));
  }

}
