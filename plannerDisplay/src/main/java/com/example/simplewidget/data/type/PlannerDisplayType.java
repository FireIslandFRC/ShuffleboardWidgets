package com.example.simplewidget.data.type;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.data.ComplexDataType;
import java.util.Map;
import java.util.function.Function;

import com.example.simplewidget.data.PlannerDisplayData;

public class PlannerDisplayType extends ComplexDataType<PlannerDisplayData> {

    public static final PlannerDisplayType Instance = new PlannerDisplayType();

    private PlannerDisplayType() {
        super("PlannerDisplayType", PlannerDisplayData.class);
    }

    @Override
    public Function<Map<String, Object>, PlannerDisplayData> fromMap() {
       return map -> {
          return new PlannerDisplayData((double)map.getOrDefault("value", 0.0));
       };
    }
 
    @Override
    public PlannerDisplayData getDefaultValue() {
       return new PlannerDisplayData(0);
    } 
}
