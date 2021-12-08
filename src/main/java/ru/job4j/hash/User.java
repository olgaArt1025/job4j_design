package ru.job4j.hash;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;

    }

    public static void main(String[] args) {
        User userOne = new User("Anna", 1, new GregorianCalendar(1998, Calendar.JULY, 23));
        User userTwo = new User("Anna", 1, new GregorianCalendar(1998, Calendar.JULY, 23));

        Map<User, Object> map = new HashMap<>();
        map.put(userOne, new Object());
        map.put(userTwo, new Object());

        System.out.println("Какие у них hashCode?");
        System.out.println("userOne hashcode: " + userOne.hashCode());
        System.out.println("userTwo hashcode: " + userTwo.hashCode());

        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
