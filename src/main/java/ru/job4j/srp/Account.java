package ru.job4j.srp;

/**
 * реализацию вывода имени объекта Account необходимо вынести отдельно
 */

public class Account {
    private int id;
    private String name;

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println(this.name);
    }
}
