package ru.job4j.srp;


/**Класс Delivery работает с доставкой  заказов интернет магазина
 * carDeliveryTime  используются без зависимости.
 * способ дастаки может поменяться.
 */

public class Delivery {
    public int distance;
    public int speed;

    public Delivery(int distance, int speed) {
        this.distance = distance;
        this.speed = speed;
    }

    void carDeliveryTime(int distance, int speed) {
        int time = distance / speed;
    }
}
