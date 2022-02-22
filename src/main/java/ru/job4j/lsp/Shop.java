package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Strategy {
    List<Food> foodShop = new ArrayList<>();

    public List<Food> getFoodShop() {
        return foodShop;
    }

    @Override
    public boolean add(Food foods) {
        boolean rsl = false;
        if (foods.storage() >= 0.25 && foods.storage() <= 0.75) {
            foodShop.add(foods);
            rsl = true;
        }
        if (foods.storage() > 0.75) {
            discount(foods);
            foodShop.add(foods);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public void delete(Food foods) {
        foodShop.remove(foods);
    }

    public void discount(Food foods) {
       foods.setPrice(foods.getPrice() * foods.getDiscount());
    }
}
