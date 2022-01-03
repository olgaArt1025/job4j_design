package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Car {
    int age;
    boolean automaticTransmission;
    private final Documents documents;
    private final String[] description;

    public Car(int age, boolean automaticTransmission, Documents documents, String[] description) {
        this.age = age;
        this.automaticTransmission = automaticTransmission;
        this.documents = documents;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Car{"
                + "age=" + age
                + ", automaticTransmission=" + automaticTransmission
                + ", documents=" + documents
                + ", description=" + Arrays.toString(description)
                + '}';
    }

    public static void main(String[] args) {
        final Car car = new Car(2, true, new Documents("11-111", "WYGD14YTK0085"),
                new String[] {"Ford Focus", "red"});

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));

        /* Модифицируем json-строку */
        final String personJson =
                "{"
                        + "\"age\":4,"
                        + "\"automaticTransmission\":false,"
                        + "\"documents\":"
                        + "{"
                        + "\"pts\":\"22-111\","
                        + "\"vin\":\"WTRC14YTI58285\""
                        + "},"
                        + "\"description\":"
                        + "[\"Volkswagen Passat B8\",\"blue\"]"
                        + "}";
        final Car carMod = gson.fromJson(personJson, Car.class);
        System.out.println(carMod);
    }
}
