package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Strategy {
    private final List<Food> foodShop = new ArrayList<>();

    @Override
    public boolean add(Food foods) {
        boolean rsl = accept(foods);
        if (rsl) {
            if (storage(foods) > 0.75) {
                foods.setPrice(foods.getPrice() * foods.getDiscount());
            }
            foodShop.add(foods);
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        return storage(food) > 0.25 && storage(food) <= 1;
    }

    @Override
    public void clear() {
        foodShop.clear();
    }

    @Override
    public void delete(Food foods) {
        foodShop.remove(foods);
    }

    @Override
    public List<Food> getAll() {
        return List.copyOf(foodShop);
    }
}
