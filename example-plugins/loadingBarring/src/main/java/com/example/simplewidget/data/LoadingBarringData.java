package com.example.simplewidget.data;

import edu.wpi.first.shuffleboard.api.data.NamedData;

import java.util.Map;

public class LoadingBarringData extends NamedData<Double> {

  public LoadingBarringData(String name, double value) {
    super(name, value);
  }

  public LoadingBarringData(Map<String, Object> map) {
    this((String) map.getOrDefault("Name", "?"), (double) map.getOrDefault("Value", 0.0));
  }

  @Override
  public String toHumanReadableString() {
    return getValue() + " Volts";
  }
}
