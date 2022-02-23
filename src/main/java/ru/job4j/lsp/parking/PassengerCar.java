package ru.job4j.lsp.parking;

public class PassengerCar extends Car {
    private String  model;
    private int size;
    private String number;

    public PassengerCar(String model, int size, String number) {
        super(model, size, number);
    }


    @Override
    public void validate(int size) {
        if (size != 1) {
            throw new IllegalArgumentException();
        }
    }
}
