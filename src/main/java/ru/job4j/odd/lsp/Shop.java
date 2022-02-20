package ru.job4j.odd.lsp;

import java.util.List;

public class Shop {
    private List<Dress> orders;

    public Shop(List<Dress> orders) {
        this.orders = orders;
    }

    public int buy(List<Dress> orders) {
        int sum = 0;
        for (Dress order : orders) {
            sum += order.getPrice();
        }
        if (sum >= 1000) {
            sum -= 100;
        }
        return sum;
    }
}
