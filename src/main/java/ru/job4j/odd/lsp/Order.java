package ru.job4j.odd.lsp;

public class Order {

    public int buy(int price, int count) {
        if (price < 0) {
            throw new IllegalStateException("The price can't be negative");
        }
        return count * price;
    }
}
