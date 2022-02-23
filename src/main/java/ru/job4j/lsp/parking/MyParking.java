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
        int size = car.getSize();
        boolean rsl = false;
        if (size == PassengerCar.SIZE) {
            if (freeParking(car)) {
                cars.add(car);
                rsl = true;
            }
        }
        if (size > PassengerCar.SIZE) {
            if (freeParkingTruck(car)) {
                cars.add(car);
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public boolean freeParking(Car car) {
        boolean result = false;
        if (parkingPlacePassenger > 0) {
            parkingPlacePassenger = parkingPlacePassenger - car.getSize();
            result = true;

        }
        return result;
    }

    @Override
    public boolean freeParkingTruck(Car car) {
        boolean result = false;
        if (parkingPlaceTruck > 0) {
            parkingPlaceTruck = parkingPlaceTruck - 1;
            result = true;
        } else if (parkingPlacePassenger >= car.getSize()) {
            parkingPlacePassenger = parkingPlacePassenger - car.getSize();
            result = true;
        }
        return result;
    }

    @Override
    public int countedCarsInParking() {
        return cars.size();
    }
}
