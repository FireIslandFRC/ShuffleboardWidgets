package com.example.simplewidget.data;

import edu.wpi.first.shuffleboard.api.data.ComplexData;
import java.util.Map;
import java.util.Objects;

public class SometimesTextData extends ComplexData<SometimesTextData> {

    private final boolean sometimes;
    private final String text;

    public SometimesTextData(boolean sometimes, String text) {
        this.sometimes = sometimes;
        this.text = text;
    }

    public SometimesTextData(Map<String, Object> map) {
        this((boolean) map.getOrDefault("sometimes", true),
            (String) map.getOrDefault("text", ""));
    }

    @Override
    public Map<String, Object> asMap() {
        return Map.of("sometimes", sometimes, "text", text);
    }

    public boolean getSometimes() {

        return sometimes;
    }

    public String getText() {
        
        return text;
    }

    public SometimesTextData withSometimes(boolean sometimes) {
        return new SometimesTextData(sometimes, text);
    }

    public SometimesTextData withText(String text) {
        return new SometimesTextData(sometimes, text);
    }

  @Override
  public int hashCode() {
    return Objects.hash(sometimes, text);
  }

  @Override
  public String toString() {
    return String.format("SometimesTextData(sometimes=%d, text=%s)",
        sometimes, text);
  }

  @Override
  public String toHumanReadableString() {
    return String.format("sometimes=%.3f, text=%.3f", sometimes, text);
  }
}
