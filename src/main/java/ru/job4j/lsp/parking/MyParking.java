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

    public int getParkingPlaceTruck() {
        return parkingPlaceTruck;
    }

    public int getParkingPlacePassenger() {
        return parkingPlacePassenger;
    }

    @Override
    public boolean parkTheCar(Car car) {
        return false;
    }

    @Override
    public void freeParking(Car car) {

    }

    @Override
    public void freeParkingTruck(Car car) {

    }

    @Override
    public int countedCarsInParking() {
        return 0;
    }

}
