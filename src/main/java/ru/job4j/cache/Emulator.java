package ru.job4j.cache;

import java.io.*;

import java.util.Scanner;

public class Emulator {
    private DirFileCache cache;

    private void showMenu() {
        String[] menu = {
                "Указать кэшируемую директорию", "Загрузить содержимое файла в кэш",
                "Получить содержимое файла из кэша",
                "Выход"
        };
        System.out.println("Меню:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    private void init(Scanner scanner) throws IOException {
        boolean work = true;
        while (work) {
            showMenu();
            System.out.println("Выберите пункт:");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                dirCache();
            } else if (select == 1) {
                uploadCash();
            } else if (select == 2) {
                getCache();
            } else if (select == 3) {
                work = false;
            }
        }
    }

    public void dirCache() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Укажите кэшируемую директорию:");
        String path = sc.nextLine();
        File file = new File(path);
        if (file.isDirectory()) {
            cache = new DirFileCache(path);
        } else {
            throw new IllegalArgumentException("Директории не существует " + file.isDirectory());
        }
    }

    public void uploadCash() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Укажите название файла, чтобы загрузить содержимое файла из кэша");
        String path = sc.nextLine();
        cache.get(path);
    }

    public void getCache() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Укажите название файла, чтобы получить содержимое файла из кэша");
        String path = sc.nextLine();
        System.out.println(cache.get(path));
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Emulator emulator = new Emulator();
        emulator.init(scanner);
    }
}
