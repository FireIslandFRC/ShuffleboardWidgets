package com.example.simplewidget.data;

import com.google.common.collect.ImmutableMap;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

import java.util.Map;
import java.util.Objects;

public final class PlannerDisplayData extends ComplexData<PlannerDisplayData> {

  private final double value;

  public PlannerDisplayData(double value) {
    this.value = value;
  }

  public PlannerDisplayData(Map<String, Object> map) {
    this((Double) map.getOrDefault("Value", 0.0));
  }

  @Override
  public Map<String, Object> asMap() {
    return ImmutableMap.of("Value", value);
  }
  
  /**
   * Version of getValue that always returns value between 0 and 360.
   * This is guaranteed to be displayed properly by the Gyro widget. 
   */
  public double getWrappedValue() {
    if (value < 0) {
      return ((value % 360) + 360) % 360;
    } else {
      return value % 360;
    }
  }

  public double getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.format("PlannerDisplayData(value=%s)", value);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    PlannerDisplayData that = (PlannerDisplayData) obj;
    return this.value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toHumanReadableString() {
    return value + " Degrees";
  }

  public PlannerDisplayData withValue(double value) {
    return new PlannerDisplayData(value);
  }

}
