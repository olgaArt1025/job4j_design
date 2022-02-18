package ru.job4j.ood.ocp;

import java.util.ArrayList;

/**
 * Нарушен принцип OCP
 * поля должны представлять сабой тип абстракций,
 * а не конкретной реализации.
 */

public class Example {
    ArrayList<Integer> arrayList;

    public Example(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }
}

