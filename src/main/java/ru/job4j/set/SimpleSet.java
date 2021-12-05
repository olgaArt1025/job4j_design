package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.*;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(16);

    @Override
    public boolean add(T value) {
        if (contains(value)) {
            return false;
        }
        set.add(value);
        return true;
    }

    @Override
    public boolean contains(T value) {
            for (final T e : set) {
                if (Objects.deepEquals(value, e)) {
                    return true;
                }
            }
            return false;
        }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
