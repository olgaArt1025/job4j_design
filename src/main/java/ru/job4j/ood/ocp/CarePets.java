package ru.job4j.ood.ocp;

import java.util.List;

/**
 * Нарушен принцип OCP
 * если мы решим завести рыбок,
 * то уход(duty) за ними - мытье аквариума,
 * в данном случае наследование от класса Dog
 * не возможно.
 */

public class CarePets {

    private static class Dog {
        public String duty() {
            return "walk";
        }
    }

    public static void main(String[] args) {
        List<Dog> dog = List.of(new Dog());
        dog.forEach(Dog::duty);
    }
}
