package ru.job4j.odd.dip;

/**
 * нарушает принцип DIP тем,
 * что класс Student зависит от класса Book,
 * студент не сможет прочитать информацию из других источников, кроме книги.
 */

public class Student {
    public void read(Book book) {
        System.out.println(book.getContent());
    }
}

class Book {
    public String getContent() {
        return "Интерфейс";
    }
}
