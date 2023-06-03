package pl.genschu.homeweather.objects;

public class SensorDataObject {
    private int idx;
    private String name;
    private String engine;
    private String data;
    private String unitSymbol;
    private String date;

    public SensorDataObject(int idx, String name, String engine, String data, String unitSymbol, String date) {
        this.idx = idx;
        this.name = name;
        this.engine = engine;
        this.data = data;
        this.unitSymbol = unitSymbol;
        this.date = date;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
