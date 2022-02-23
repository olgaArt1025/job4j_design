package ru.job4j.lsp.parking;

public interface Parking {

    boolean parkTheCar(Car car);

    void freeParking(Car car);

    void freeParkingTruck(Car car);

    int countedCarsInParking();

}
