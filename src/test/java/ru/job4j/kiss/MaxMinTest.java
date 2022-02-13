package ru.job4j.kiss;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MaxMinTest {

    @Test
    public void max() {
        List<Integer> list = new java.util.ArrayList<>(List.of(4, 10, 7, 9));
        int expected = 10;
        int result = MaxMin.max(list, Integer::compare);
        assertEquals(result, expected);
    }

    @Test
    public void min() {
        List<Integer> list = new java.util.ArrayList<>(List.of(8, 5, 7, 1));
        int expected = 1;
        int result = MaxMin.min(list, Integer::compare);
        assertEquals(result, expected);
    }
}