package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDesc", 123L);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDesc", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "descTwo", 1234L);
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()), is(next));
    }

    @Test
    public void whenEditingItemWhichIsNot() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDesc", 123L);
        Item next = new Item("test2", "descTwo", 1234L);
        final boolean replace = tracker.replace(previous.getId(), next);
        assertFalse(replace);
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item deleted = new Item("test1", "testDesc", 123L);
        Item itemTwo = new Item("test2", "testDesc2", 1234L);
        Item itemThree = new Item("test4", "testDesc3", 12345L);
        tracker.add(deleted);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.delete(deleted.getId());
        List<Item> expected = new ArrayList<>();
        expected.add(itemTwo);
        expected.add(itemThree);
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenFindItemByName() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("test5", "testDesc", 123L);
        Item itemOne1 = new Item("test5", "testDesc", 123L);
        Item itemTwo = new Item("test2", "testDesc2", 1234L);
        Item itemThree = new Item("test4", "testDesc3", 12345L);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.add(itemOne1);
        List<Item> expected = new ArrayList<>();
        expected.add(itemOne);
        expected.add(itemOne1);
        assertThat(tracker.findByName(itemOne.getName()), is(expected));
    }

    @Test
    public void whenYouFindAnItemById() {
        Tracker tracker = new Tracker();
        Item wanted = new Item("test1", "testDesc", 123L);
        tracker.add(wanted);
        Item item = new Item("test2", "descTwo", 1234L);
        tracker.add(item);
        assertThat(tracker.findById(wanted.getId()), is(wanted));
    }

    @Test
    public void whenYouGetAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDesc", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "descTwo", 1234L);
        tracker.add(item2);
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        assertThat(tracker.getAll(), is(expected));
    }


}
