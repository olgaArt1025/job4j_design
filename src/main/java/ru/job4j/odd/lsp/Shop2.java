package ru.job4j.odd.lsp;

import java.util.List;

/**
 * В классе Shop2 условие получение скидки при большом заказе отсутствует.
 * это ослабление постусловия
 * что нарушает контракт
 */

public class Shop2 extends Shop {
    private List<Dress> orders;

    public Shop2(List<Dress> orders) {
        super(orders);
    }

    @Override
    public int buy(List<Dress> orders) {
        int sum = 0;
        for (Dress order : orders) {
            sum += order.getPrice();
        }
        return sum;
    }
}
