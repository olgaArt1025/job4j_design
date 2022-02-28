package ru.job4j.odd.isp;

/**
 * с помощью данного интерфейса мы реализуем разные типы транспорта,
 * которые не смогут использовать все типы передвижения.
 * Необходимо данный интерфейс разделить на отдельные части,
 * которые составят раздельные интерфейсы.
 */


public interface Transport {
    public void swim();
    public void fly();
    public void drive();
}
