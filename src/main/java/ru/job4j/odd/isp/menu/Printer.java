package ru.job4j.odd.isp.menu;

import java.util.Collections;

public class Printer implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo info : menu) {
            String str = "--" + info.getNumber() + info.getName();
            int length = info.getNumber().length();
            String s = "--";
            str = str.replace(s, String.join("", Collections.nCopies(length, s)));
            System.out.println(str);
        }
    }
}
