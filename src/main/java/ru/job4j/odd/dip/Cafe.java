package ru.job4j.odd.dip;

/**
 * нарушается принцип DIP тем,
 * что класс Cafe самостоятельно создает класс Coffee.
 */

public class Cafe {
    void mixDrink() {
        Coffee coffee = new Coffee();
        coffee.mixCoffee();
    }

    public  class Coffee {
        void mixCoffee() {
            System.out.println("Cappuccino");
        }
    }

}
