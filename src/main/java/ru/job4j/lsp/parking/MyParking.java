package ru.job4j.lsp.parking;

import java.util.List;

public class MyParking implements Parking {
    private int parkingPlaceTruck;
    private int parkingPlacePassenger;
    private List<Car> cars;

    public MyParking(int parkingPlaceTruck, int parkingPlacePassenger) {
        this.parkingPlaceTruck = parkingPlaceTruck;
        this.parkingPlacePassenger = parkingPlacePassenger;
    }

    @Override
    public boolean parkTheCar(Car car) {
        return false;
    }

    @Override
    public int freeParking() {
        return 0;
    }

    @Override
    public int freeParkingTruck() {
        return 0;
    }
}
