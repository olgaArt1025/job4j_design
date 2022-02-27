package ru.job4j.odd.dip;

/**
 * нарушает принцип DIP тем,
 * что класс Drinks зависит от класса Fruit.
 */

public class Drinks {
    private Fruit fruit;

    public void poll() {
        fruit.squeeze();

    }

    public class Fruit {

        public void squeeze() {
            System.out.println("juice");
        }

    }
}
