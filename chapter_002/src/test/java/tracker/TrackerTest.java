package tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDesc", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDesc", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "descTwo", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
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
        assertThat(tracker.getAll()[0], is(itemTwo));
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
        Item[] expected = new Item[2];
        expected[0] = itemOne;
        expected[1] = itemOne1;
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
}
