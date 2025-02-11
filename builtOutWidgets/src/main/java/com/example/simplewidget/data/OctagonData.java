package com.example.simplewidget.data;

import com.google.common.collect.ImmutableMap;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

import com.example.simplewidget.data.type.BetterPIDControllerType;

import java.util.Map;
import java.util.Objects;

public class OctagonData extends ComplexData<OctagonData> {
    private final int button;
    private final int level;

    public OctagonData(int button, int level) {
        this.button = button;
        this.level = level;
    }

    public OctagonData(Map<String, Object> map) {
        this(
            (int)map.getOrDefault("button", 0),
            (int)map.getOrDefault("level", 0));
    }

    public int getButton() {
        return button;
    }

    public int getLevel() {
        return level;
    }

    public OctagonData withButton(int button) {
        return new OctagonData(button, level);
    }

    public OctagonData withLevel(int level) {
        return new OctagonData(button, level);
    }

    @Override
    public Map<String, Object> asMap() {
        return ImmutableMap.<String, Object>builder()
            .put("button", button)
            .put("level", level)
            .build();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OctagonData that = (OctagonData) obj;
        return this.button == that.button && this.level == that.level;
    }

  @Override
  public int hashCode() {
    return Objects.hash(button, level);
  }

  @Override
  public String toString() {
    return String.format("Octagon(button=%s, level=%s)",
        button, level);
  }

  @Override
  public String toHumanReadableString() {
    return String.format("button=%d level=%d", button, level);
  }
}
