package com.example.simplewidget.widget;

import eu.hansolo.medusa.Gauge;

import edu.wpi.first.shuffleboard.api.prefs.Group;
import edu.wpi.first.shuffleboard.api.prefs.Setting;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import com.example.simplewidget.data.GyroData;

import com.google.common.collect.ImmutableList;

import java.util.List;

import javax.management.ValueExp;

import javafx.beans.property.BooleanPropertyBase;
import javafx.beans.property.DoublePropertyBase;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javafx.scene.layout.Pane;
import org.fxmisc.easybind.EasyBind;

@Description(name = "RadiableGyro", dataTypes = { GyroData.class, Number.class })
@ParametrizedController("GyroWidget.fxml")
public class GyroWidget extends SimpleAnnotatedWidget<Object> {

  @FXML
  private Pane root;
  @FXML
  private Gauge gauge;
  @FXML
  private TextField valueLabel;

  private double angle;
  private double wrapAt;

  @FXML
  private void initialize() {
    gauge.setSkinType(Gauge.SkinType.MODERN);
    valueLabel.setEditable(false);
    dataProperty().addListener((__, prev, cur) -> {
      if (cur != null) {
        double angle = 0;
        if (cur instanceof Number) {
          angle = ((Number) cur).doubleValue();
        } else if (cur instanceof GyroData) {
          angle = ((GyroData) cur).getWrappedValue();
        } else if (cur instanceof String || cur instanceof Boolean) {
          valueLabel.setText(cur.toString());
        }
        if (wrapAt != 0)
          angle = wrapAngle(angle);
        valueLabel.setText(String.format("%1.4f", angle));
      }
    });
  }

  /**
   * Helper method to keep an angle in the range [0, 360).
   * eg wrapAngle(90) -> 90
   * wrapAngle(360) -> 0
   * wrapAngle(-15) -> 345
   */
  private double wrapAngle(double angle) {
    if (angle < 0) {
      return ((angle % (wrapAt)) + (wrapAt)) % (wrapAt);
    } else {
      return angle % (wrapAt);
    }
  }

  @Override
  public List<Group> getSettings() {
    return ImmutableList.of(
        Group.of("Visuals",
            Setting.of("Major tick spacing", gauge.majorTickSpaceProperty(), Double.class),
            Setting.of("Starting angle", gauge.startAngleProperty(), Double.class),
            Setting.of("Show tick mark ring", gauge.tickMarkRingVisibleProperty(), Boolean.class),
            Setting.of("Counter clockwise", createCounterClockwiseProperty(), Boolean.class)),
        Group.of("Numbers",
            Setting.of("Min Value", createMinvalueProperty(), Double.class),
            Setting.of("Max Value", createMaxvalueProperty(), Double.class),
            Setting.of("Wrap Angle", createWrapProperty(), Double.class)));
  }

  @Override
  public Pane getView() {
    return root;
  }

  private Property<Number> createWrapProperty() {
    return new DoublePropertyBase() {
      @Override
      public double get() {
        return wrapAt;
      }

      @Override
      public void set(double arg0) {
        wrapAt = arg0;
      }

      @Override
          public Object getBean() {
              return gauge;
          }

      @Override
      public String getName() {
        return "wrapAngle";
      }
    };
  }

  private Property<Number> createMaxvalueProperty() {
    return new DoublePropertyBase() {
      @Override
      public double get() {
        return gauge.getMaxValue();
      }

      @Override
      public void set(double arg0) {
        gauge.setMaxValue(arg0);
      }

      @Override
      public Object getBean() {
        return gauge;
      }

      @Override
      public String getName() {
        return "minValue";
      }
    };
  }

  private Property<Number> createMinvalueProperty() {
    return new DoublePropertyBase() {
      @Override
      public double get() {
        return gauge.getMinValue();
      }

      @Override
      public void set(double arg0) {
        gauge.setMinValue(arg0);
      }

      @Override
      public Object getBean() {
        return gauge;
      }

      @Override
      public String getName() {
        return "minValue";
      }
    };
  }

  private Property<Boolean> createCounterClockwiseProperty() {
    return new BooleanPropertyBase() {
      @Override
      public boolean get() {
        set(gauge.getScaleDirection() == Gauge.ScaleDirection.COUNTER_CLOCKWISE);
        return super.get();
      }

      @Override
      public void set(boolean newValue) {
        super.set(newValue);
        gauge.setScaleDirection(newValue ? Gauge.ScaleDirection.COUNTER_CLOCKWISE : Gauge.ScaleDirection.CLOCKWISE);
      }

      @Override
      public Object getBean() {
        return gauge;
      }

      @Override
      public String getName() {
        return "counterClockwise";
      }
    };
  }

}
