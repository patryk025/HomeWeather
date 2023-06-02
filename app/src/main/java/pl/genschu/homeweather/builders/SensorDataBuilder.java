package pl.genschu.homeweather.builders;

import pl.genschu.homeweather.objects.SensorDataObject;

public class SensorDataBuilder {
    private int idx;
    private String name;
    private String engine;
    private String data;
    private String unitSymbol;

    public SensorDataBuilder addIdx(int idx) {
        this.idx = idx;
        return this;
    }

    public SensorDataBuilder addName(String name) {
        this.name = name;
        return this;
    }

    public SensorDataBuilder addEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public SensorDataBuilder addData(String data) {
        this.data = data;
        return this;
    }

    public SensorDataBuilder addUnitSymbol(String unitSymbol) {
        this.unitSymbol = unitSymbol;
        return this;
    }

    public SensorDataObject build() {
        return new SensorDataObject(idx, name, engine, data, unitSymbol);
    }
}
