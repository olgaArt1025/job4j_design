package ru.job4j.odd.isp;

public class Oven implements KitchenAppliances {
    @Override
    public void mixing() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void cutting() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void squeezing() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void grill() {
        System.out.println("Fry!");
    }

    @Override
    public void bake() {
        System.out.println("Bake!");
    }
}

