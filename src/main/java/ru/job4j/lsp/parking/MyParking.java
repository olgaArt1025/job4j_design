package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class MyParking implements Parking {
    private int parkingPlaceTruck;
    private int parkingPlacePassenger;
    private List<Car> cars = new ArrayList<>();

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
        int s = car.getSize();
        boolean rsl = false;
        if (s == 1) {
            freeParking(car);
            cars.add(car);
            rsl = true;
        }
        if (s > 1) {
            freeParkingTruck(car);
            cars.add(car);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public void freeParking(Car car) {
        if (parkingPlacePassenger > 0) {
            parkingPlacePassenger = parkingPlacePassenger - car.getSize();
        } else {
            System.out.println("There are no parking spaces");
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void freeParkingTruck(Car car) {
        if (parkingPlaceTruck > 0) {
            parkingPlaceTruck = parkingPlaceTruck - 1;
        } else if (parkingPlacePassenger >= car.getSize()) {
            parkingPlacePassenger = parkingPlacePassenger - car.getSize();
        } else {
            System.out.println("There are no parking spaces");
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int countedCarsInParking() {
        return cars.size();
    }
}
