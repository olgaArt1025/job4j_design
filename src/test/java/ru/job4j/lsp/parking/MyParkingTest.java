package ru.job4j.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@Ignore
public class MyParkingTest {

    @Test
    public void whenParkTheTruck() {
        MyParking myParking = new MyParking(10, 2);
        Car kamaz = new Truck("kamaz", 2, "V1256DU");
        assertTrue(myParking.parkTheCar(kamaz));
        assertThat(myParking.getParkingPlaceTruck(), is(9));
    }

    @Test
    public void whenParkPassengerCar() {
        MyParking myParking = new MyParking(4, 2);
        Car volkswagen = new PassengerCar("B8", "V285NU");
        Car opel = new PassengerCar("Opel Astra", "V287NP");
        assertTrue(myParking.parkTheCar(volkswagen));
        assertTrue(myParking.parkTheCar(opel));
        assertThat(myParking.getParkingPlacePassenger(), is(0));
    }

    @Test
    public void whenParkTheTruckNoPakingPlaceTruck() {
        MyParking myParking = new MyParking(0, 3);
        Car kamaz = new Truck("kamaz", 3, "V126NU");
        assertTrue(myParking.parkTheCar(kamaz));
        assertThat(myParking.getParkingPlacePassenger(), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenParkTruckWithSize4AtCarPlaceThenFalse() {
        MyParking parking = new MyParking(0, 2);
        Truck truck = new Truck("Mercedes-Benz Actros", 4, "V124NW");
       parking.parkTheCar(truck);
    }

    @Test
    public void whenCarsCountAtParkingIsTwo() {
        MyParking parking = new MyParking(1, 1);
        Car toyota = new PassengerCar("Corolla", "I524NW");
        Car volvo = new Truck("FH16", 2, "O524NW");
        parking.parkTheCar(toyota);
        parking.parkTheCar(volvo);
        assertThat(parking.countedCarsInParking(), is(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenParkTruckWithSize1() {
        MyParking parking = new MyParking(5, 2);
        Truck truck = new Truck("Mercedes-Benz Actros", 1, "V724NW");
    }
}