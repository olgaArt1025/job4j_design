package ru.job4j.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenPut() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Olga");
        String rsl = map.get(1);
        assertThat(rsl, is("Olga"));
    }
    @Test
    public void whenPutAndGetValue() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("first", 154);
        map.put("second", 258);
        assertThat(map.get("first"), is(154));
        assertThat(map.get("second"), is(258));
    }

    @Test
    public void whenPutSameIndexThenFalseAndAnotherIndexThenTrue() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "first");
        assertFalse(map.put(1, "first"));
        assertTrue(map.put(2, "second"));
    }

    @Test
    public void whenRemove() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("first", 1);
        map.put("second", 2);
        map.remove("first");
        map.remove("second");
        assertThat(map.get("first"), is(nullValue()));
        assertThat(map.get("second"), is(nullValue()));
    }

    @Test
    public void iterator() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "first");
        map.put(2, "second");
        map.put(3, "third");
        Iterator<Integer> it = map.iterator();
        assertTrue(it.hasNext());
        assertThat(it.next(), is(1));
        assertTrue(it.hasNext());
        assertThat(it.next(), is(2));
        assertTrue(it.hasNext());
        assertThat(it.next(), is(3));
        assertFalse(it.hasNext());
    }

    @Test
    public void whenPutSimpleIntegerKeyThenGetValueByIndexOrder() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "first");
        map.put(2, "second");
        Iterator<Integer> it = map.iterator();
        assertThat(map.get(it.next()), is("first"));
        assertThat(map.get(it.next()), is("second"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenPutWhileAfterIteratorThenMustBeException() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "first");
        map.put(2, "second");
        Iterator<Integer> it = map.iterator();
        map.put(3, "third");
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenRemoveAfterIteratorThenMustBeException() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "first");
        map.put(2, "second");
        Iterator<Integer> it = map.iterator();
        map.remove(1);
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyMapIteratorNextThenThrowException() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        Iterator<Integer> it = map.iterator();
        it.next();
    }

    @Test
    public void whenGetIteratorFromEmptyListThenHasNextReturnFalse() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        Assert.assertFalse(map.iterator().hasNext());
    }
}
