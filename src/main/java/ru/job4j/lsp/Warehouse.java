package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Strategy {
    List<Food> foodWarehouse = new ArrayList<>();

    public List<Food> getFoodWarehouse() {
        return foodWarehouse;
    }

    @Override
    public boolean add(Food foods) {
        boolean rsl = foods.storage() < 0.25;
        if (rsl) {
            foodWarehouse.add(foods);
        }
        return rsl;
    }
    @Override
    public void delete(Food foods) {
        foodWarehouse.remove(foods);
    }
}
