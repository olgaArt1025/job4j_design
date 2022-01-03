package ru.job4j.serialization.java;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "documents ")
public class Documents {
    @XmlAttribute
    private  String pts;
    @XmlAttribute
    private  String  vin;

    public Documents() {
    }

    public Documents(String pts, String vin) {
        this.pts = pts;
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Documents{"
                + "pts='" + pts + '\''
                + ", vin='" + vin + '\''
                + '}';
    }
}
