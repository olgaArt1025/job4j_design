package ru.job4j.lsp.parking;

public abstract class Car {
    private String  model;
    private int size;
    private String number;

    public Car(String model, int size, String number) {
        this.model = model;
        this.size = size;
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public abstract void validate(int size);
}
