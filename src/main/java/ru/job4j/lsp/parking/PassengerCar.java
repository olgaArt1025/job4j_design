package ru.job4j.lsp.parking;

public class PassengerCar extends Car {
    private String  model;
    private static final int SIZE = 1;
    private String number;

    public PassengerCar(String model, String number) {
        super(model, SIZE, number);
    }

    @Override
    public void validate(int size) {
        if (size != 1) {
            throw new IllegalArgumentException();
        }
    }
}
