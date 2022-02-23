package ru.job4j.lsp.parking;

public interface Parking {

    boolean parkTheCar(Car car);

    boolean freeParking(Car car);

    boolean freeParkingTruck(Car car);

    int countedCarsInParking();

}
