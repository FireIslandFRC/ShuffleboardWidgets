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
import com.example.simplewidget.data.LoadingBarringData;

@Description(name = "LoadingBarring", dataTypes = {LoadingBarringData.class})
@ParametrizedController("LoadingBarringWidget.fxml")
public class LoadingBarringWidget extends SimpleAnnotatedWidget<LoadingBarringData> {
    @FXML 
    public Pane root;
    // @FXML
    // public ProgressBar progressingBarring;

    @FXML
    public void initialize() {
        // dataProperty().addListener((__, prev, cur) -> {
        //     if (cur != null) {
        //         if (cur instanceof LoadingBarringData) {
        //             progressingBarring.setProgress(((LoadingBarringData) cur).getValue());
        //         }
        //     }
        // });
    }

    @Override
    public Pane getView() {
        return root;
    }
}
