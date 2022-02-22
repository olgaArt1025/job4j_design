package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Strategy {
    private final List<Food> foodTrash = new ArrayList<>();

    @Override
    public boolean add(Food foods) {
        boolean rsl = accept(foods);
        if (rsl) {
            foodTrash.add(foods);
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        return storage(food) > 1;
    }

    @Override
    public void delete(Food foods) {
        foodTrash.remove(foods);
    }

    @Override
    public List<Food> getAll() {
        return List.copyOf(foodTrash);
    }
}
