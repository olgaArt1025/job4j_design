package ru.job4j.odd.lsp;

/**
 * В классе OnlineOrder усилено предусловие.
 * Это нарушение контракта.
 */

public class OnlineOrder extends Order {

    @Override
    public int buy(int price, int count) {
        if (price < 500) {
            throw new IllegalStateException("The price can't be less than 500");
        }
        return count * price;
    }
}
