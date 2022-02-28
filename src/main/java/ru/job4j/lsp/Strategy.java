package ru.job4j.lsp;

import java.time.LocalDate;
import java.util.List;

public interface Strategy {

    boolean add(Food foods);

    void delete(Food foods);

    List<Food> getAll();

    boolean accept(Food food);

    void clear();

    default double storage(Food food) {
        return ((double) (LocalDate.now().toEpochDay() - food.getCreateDate().toEpochDay())
                / (double) (food.getExpiryDate().toEpochDay() - food.getCreateDate().toEpochDay()));

    }

}
