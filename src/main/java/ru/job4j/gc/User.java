package ru.job4j.gc;

public class User {
    private int age;
    private String name;

    public User() {
    }

    public User(int age) {
        this.age = age;
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", age, name);
    }


        /**
         *          User user1 = new User(); пустой объект без полей занимает 16 байт (12 + 4 Выравнивание)
         *          User user2 = new User(48); -объект содержит тип данных int , поэтому его размер равен 12 + 4 = 16 байтам.
         *          User user3 = new User(4, "Name"); объект содержит тип данных int  и String,
         *                                             поэтому его размер равен 12 + 4 + 56 = 72 байтам.
          */


        /**
         *          Задаем размер  хипа для нашей программы , с помощью ключей -Xmx4m -Xms4m
         *          (при уменьшении размера хипа сборщик мусора вызывается чаще).
         *          В программе в цикле создаются объекты new User() без ссылок на эти объекты.
         *          При нехватке памяти запускается GC и стирает из памяти объекты, не имеющие на них ссылок.
         *          При вызове метода finalize() сборщик мусора добавляет соответствующие объекты в специальный список,
         *          вызывая статический метод java.lang.ref.Finalizer.register(Object).Если какой-то finalize() зависает,
         *          то он подвешивает поток «Finalizer». Отсюда возникает ошибка  недостатка памяти,  GC не успевает очищать
         *          достаточное количество памяти для создания новых объектов.
         *          Ошибка java.lang.OutOfMemoryError появляется после создания ~19000 объектов
         */

}
