package ru.job4j.serialization.json;

public class Documents {
    private final String pts;
    private final String  vin;

    public Documents(String pts, String vin) {
        this.pts = pts;
        this.vin = vin;
    }
    public String getPts() {
        return pts;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public String toString() {
        return "Documents{"
                + "pts='" + pts + '\''
                + ", vin='" + vin + '\''
                + '}';
    }
}
