package ru.job4j.lsp.parking;

public interface Parking {

    boolean parkTheCar(Car car);

    int freeParking();

    int freeParkingTruck();

}
