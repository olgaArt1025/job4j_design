package ru.job4j.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControllQualityTest {

    @Test
    public void whenShop() {
        Trash trash = new Trash();
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        ControllQuality controller = new ControllQuality(List.of(trash, shop, warehouse));
        LocalDate now = LocalDate.now();
        Food cheese = new Cheese("Bri",
                now.plusDays(30),
                now.minusDays(18),
                70, 0.5);
        controller.add(cheese);
        assertThat(shop.getAll().size(), is(1));
        assertThat(trash.getAll().size(), is(0));
        assertThat(warehouse.getAll().size(), is(0));
    }

    @Test
    public void whenShopAndDiscount() {
        Trash trash = new Trash();
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        ControllQuality controller = new ControllQuality(List.of(trash, shop, warehouse));
        LocalDate now = LocalDate.now();
        Food cookies = new Bakery("Cookies",
                now.plusDays(5),
                now.minusDays(30),
                200, 0.5);
        controller.add(cookies);
        assertThat(shop.getAll().size(), is(1));
        assertThat(shop.getAll().get(0).getPrice(), is(100.0));
        assertThat(trash.getAll().size(), is(0));
        assertThat(warehouse.getAll().size(), is(0));
    }

    @Test
    public void whenTwoProductsAddedWarehouse() {
        Trash trash = new Trash();
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        ControllQuality controller = new ControllQuality(List.of(trash, shop, warehouse));
        LocalDate now = LocalDate.now();
        Food bread = new Bakery("White bread",
                now.plusDays(5),
                now,
                52.30, 0.7);
        Food donuts = new Bakery("Donuts",
                now.plusDays(5),
                now,
                47.50, 0.4);
        controller.add(bread);
        controller.add(donuts);
        assertThat(shop.getAll().size(), is(0));
        assertThat(trash.getAll().size(), is(0));
        assertThat(warehouse.getAll().size(), is(2));
    }

    @Test
    public void whenTrash() {
        Trash trash = new Trash();
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        ControllQuality controller = new ControllQuality(List.of(trash, shop, warehouse));
        LocalDate now = LocalDate.now();
        Food bread = new Bakery("Bread",
                now.minusDays(1),
                now.minusDays(4),
                52.30, 0.7);
        controller.add(bread);
        assertThat(shop.getAll().size(), is(0));
        assertThat(trash.getAll().size(), is(1));
        assertThat(warehouse.getAll().size(), is(0));
    }
}
