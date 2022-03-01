package ru.job4j.odd.isp.menu;

import java.util.Collections;

public class Printer implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo info : menu) {
            String result = String.join("--".repeat(info.getNumber().length()),
                    "", info.getNumber() + info.getName());
            System.out.println(result);
        }
    }
}
