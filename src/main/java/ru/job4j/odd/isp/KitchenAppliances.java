package ru.job4j.odd.isp;

public interface KitchenAppliances {
    /**
     *  Избыточное количество методов в интерфейсе:
     *  Для Духовки нужен только метод bake, продукты она не режет,
     *  а функция grill есть не вовсех духовках.
     *  Комбайну нужны только методы cutting, mixing и squeezing.
     */

    void  mixing();
    void  cutting();
    void squeezing();
    void  grill();
    void bake();

}
