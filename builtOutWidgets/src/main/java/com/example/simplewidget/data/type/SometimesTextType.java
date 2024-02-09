package com.example.simplewidget.data.type;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;
import com.example.simplewidget.data.SometimesTextData;

import java.util.function.Function;
import java.util.Map;


public class SometimesTextType extends ComplexDataType<SometimesTextData> {
    private static final String NAME = "SometimesTextType";
    public static final SometimesTextType Instance = new SometimesTextType();

    private SometimesTextType() {
        super(NAME, SometimesTextData.class);
    }

    @Override
    public Function<Map<String, Object>, SometimesTextData> fromMap() {
        return SometimesTextData::new;
        // return map -> {
        //     return new SometimesTextData((boolean) map.getOrDefault("sometimes", 0.0), (String) map.getOrDefault("text", 0.0));
        // };
    }

    @Override
    public SometimesTextData getDefaultValue() {
        // use default values of 0 for X and Y coordinates
        return new SometimesTextData(true, "");
    }
}
