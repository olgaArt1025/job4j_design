package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
    int age;
    boolean automaticTransmission;
    private final Documents documents;
    private final String[] description;

    public Car(int age, boolean automaticTransmission, Documents documents, String... description) {
        this.age = age;
        this.automaticTransmission = automaticTransmission;
        this.documents = documents;
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public boolean isAutomaticTransmission() {
        return automaticTransmission;
    }

    public Documents getDocuments() {
        return documents;
    }

    public String[] getDescription() {
        return description;
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
        /* JSONObject из json-строки строки */
        JSONObject jsonContact = new JSONObject("{\"pts\":\"22-111\", \"vin\":\"WTRC14YTI58285\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Volkswagen Passat B8");
        list.add("blue");
        JSONArray jsonStatuses = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Car car = new Car(2, true, new Documents("11-111", "WYGD14YTK0085"),
                "Ford Focus", "red");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("age", car.getAge());
        jsonObject.put("automaticTransmission", car.isAutomaticTransmission());
        jsonObject.put("documents", jsonContact);
        jsonObject.put("description", jsonStatuses);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(car).toString());
    }
}
