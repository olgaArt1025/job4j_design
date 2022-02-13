package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public static <T> T max(List<T> value, Comparator<T> comparator) {
        return sort(value, comparator.reversed());
    }

    public static  <T> T min(List<T> value, Comparator<T> comparator) {
        return sort(value, comparator);
    }

    private static  <T> T sort(List<T> value, Comparator<T> comparator) {
        T rst = value.get(0);
        for (T element : value) {
            rst = comparator.compare(element, rst) < 0 ? element : rst;
        }
        return rst;
    }
}
