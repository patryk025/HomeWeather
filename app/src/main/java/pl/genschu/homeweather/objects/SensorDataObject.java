package pl.genschu.homeweather.objects;

public class SensorDataObject {
    private int idx;
    private String engine;
    private String data;
    private String unitSymbol;

    public SensorDataObject(int idx, String engine, String data, String unitSymbol) {
        this.idx = idx;
        this.engine = engine;
        this.data = data;
        this.unitSymbol = unitSymbol;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getSensorObject() {
        return idx;
    }

    public void setensorObject(int idx) {
        this.idx = idx;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUnitSymbol() {
        return unitSymbol;
    }

    public void setUnitSymbol(String unitSymbol) {
        this.unitSymbol = unitSymbol;
    }
}
