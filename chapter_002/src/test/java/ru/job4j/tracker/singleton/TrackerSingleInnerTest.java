package ru.job4j.tracker.singleton;

import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleInnerTest {
    private TrackerSingleInner trackerSingletonComp = TrackerSingleInner.getInstance();

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Item item = new Item("test1", "testDesc", 123L);
        trackerSingletonComp.add(item);
        assertThat(trackerSingletonComp.getAll().get(0), is(item));
    }
}
