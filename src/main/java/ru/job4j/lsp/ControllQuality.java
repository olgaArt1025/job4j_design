package ru.job4j.lsp;

import java.util.List;

public class ControllQuality {
    private final List<Strategy> strategies;

    public ControllQuality(List<Strategy> strategies) {
        this.strategies = strategies;
    }

    public List<Strategy> getStrategies() {
        return strategies;
    }

    public void add(Food food) {
        boolean rsl = false;
        for (Strategy strategy : strategies) {
            if (strategy.accept(food)) {
                strategy.add(food);
                rsl = true;
                break;
            }
        }
        if (rsl) {
            System.out.println(food.getName() + " redistributed to storage");
        } else {
            throw new IllegalArgumentException(food.getName() + " unallocated in storage");
        }
    }
}

