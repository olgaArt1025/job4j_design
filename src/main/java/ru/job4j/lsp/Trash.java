package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Strategy {
    List<Food> foodTrash = new ArrayList<>();

    public List<Food> getFoodTrash() {
        return foodTrash;
    }

    @Override
    public boolean add(Food foods) {
        boolean rsl = foods.storage() >= 1;
        if (rsl) {
            foodTrash.add(foods);
        }
        return rsl;
    }

    @Override
    public void delete(Food foods) {
        foodTrash.remove(foods);
    }
}
