package ru.job4j.srp;

/**Класс Order работает с заявками интернет магазина
 * в данном примере нарушен принцип единого функционала
 * deliveryMethod и payment можно вынести в отдельную абстракцию.
 */


public interface Order {
    void formationOrder();
    void deliveryMethod();
    void payment();
}
