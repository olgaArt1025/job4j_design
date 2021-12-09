package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int modCount = 0;
    private int size = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean rsl;
        if (size >= capacity * LOAD_FACTOR) {
            expand();
        }
        if (table[indexFor(hash(key))] != null) {
            rsl = false;
        } else {
            table[indexFor(hash(key))] = new MapEntry<>(key, value);
            size++;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    private int hash(K key) {
        return  key == null ? 0 : key.hashCode();
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        MapEntry<K, V>[] newTable = new MapEntry[capacity * 2];
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                newTable[indexFor(table[i].hashCode())] = table[i];
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        V result = null;
        int i = hash(key) & (table.length - 1);
        if (table[i] != null && Objects.equals(key, table[i].key)) {
            result = table[i].value;
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int i = hash(key) & (table.length - 1);
        if (table[i] != null && Objects.equals(key, table[i].key)) {
            table[i] = null;
            size--;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int indexIt = 0;
            private int sizeIt = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (indexIt < table.length - 1 && table[indexIt] == null) {
                    indexIt++;
                }
                return sizeIt < size;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                sizeIt++;
                return table[indexIt++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
