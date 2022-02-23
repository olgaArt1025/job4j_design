package ru.job4j.lsp.parking;

public class Truck extends Car {
    private String  model;
    private int size;
    private String number;

    public Truck(String model, int size, String number) {
        super(model, size, number);
    }


    @Override
    public void validate(int size) {
        if (size < 2) {
            System.out.println("Incorrect size of the truck");
            throw new IllegalArgumentException();
        }
    }
}
