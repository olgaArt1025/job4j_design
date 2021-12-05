package ru.job4j.set;

import org.junit.Assert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAdd() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));
        assertFalse(set.contains(4));
        assertTrue(set.add(4));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddAfterGetIteratorThenMustBeException() {
        SimpleSet<Integer> set = new SimpleSet<>();
        Iterator<Integer> iterator = set.iterator();
        set.add(4);
        iterator.next();
    }

    @Test
    public void whenGetIteratorFromEmptyListThenHasNextReturnFalse() {
        SimpleSet<Integer> set = new SimpleSet<>();
        Assert.assertFalse(set.iterator().hasNext());
    }
}