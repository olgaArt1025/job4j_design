package ru.job4j.ood.ocp;

import java.util.ArrayList;

/**
 * Нарушен принцип OCP
 * если мы решим завести новое животное,
 * то придется переписать метод petsSound,
 * что бы узнать звук издаваемый им.
 */


public class Pets {
    private String name;

    public Pets(String name) {
        this.name = name;
    }

    public String petsSound(ArrayList<Pets> pets) {
        String str = null;
        for (Pets animal : pets) {
            if (animal.name.equals("dog")) {
                str = "barking";
            } else if (animal.name.equals("cat")) {
                str = "meows";
            }
        }
        return str;
    }
}

