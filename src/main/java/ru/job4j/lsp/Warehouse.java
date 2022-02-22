package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Strategy {
    private final List<Food> foodWarehouse = new ArrayList<>();

    @Override
    public boolean add(Food foods) {
        boolean rsl = accept(foods);
        if (rsl) {
            foodWarehouse.add(foods);
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        return storage(food) < 0.25;
    }

    @Override
    public void delete(Food foods) {
        foodWarehouse.remove(foods);
    }

    @Override
    public List<Food> getAll() {
        return List.copyOf(foodWarehouse);
    }
}
