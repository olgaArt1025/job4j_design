package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAdd() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Student"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Student"));
    }

    @Test
    public void whenReplace() {
        RoleStore store = new RoleStore();
        store.add(new Role("3", "Student"));
        store.replace("3", new Role("3", "Engineer"));
        Role result = store.findById("3");
        assertThat(result.getRole(), is("Engineer"));
    }

    @Test
    public void whenDelete() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Student"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenFindByIdNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("4", "Artist"));
        Role result = store.findById("10");
        assertNull(result);
    }
}
