package tracker.singleton;

import org.junit.Test;
import tracker.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingletonTest {
    private TrackerSingleton trackerSingleton = TrackerSingleton.getInstance();

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Item item = new Item("test1", "testDesc", 123L);
        trackerSingleton.add(item);
        assertThat(trackerSingleton.getAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Item previous = new Item("test1", "testDesc", 123L);
        trackerSingleton.add(previous);
        Item next = new Item("test2", "descTwo", 1234L);
        trackerSingleton.replace(previous.getId(), next);

        assertThat(trackerSingleton.findById(previous.getId()), is(next));
    }

    @Test(expected = NullPointerException.class)
    public void whenEditingItemWhichIsNot() {
        Item previous = new Item("test1", "testDesc", 123L);
        Item next = new Item("test2", "descTwo", 1234L);
        trackerSingleton.replace(previous.getId(), next);
    }

    @Test
    public void whenDeleteItem() {
        Item deleted = new Item("test1", "testDesc", 123L);
        Item itemTwo = new Item("test2", "testDesc2", 1234L);
        Item itemThree = new Item("test4", "testDesc3", 12345L);
        trackerSingleton.add(deleted);
        trackerSingleton.add(itemTwo);
        trackerSingleton.add(itemThree);
        trackerSingleton.delete(deleted.getId());
        Item[] expected = new Item[2];
        expected[0] = itemTwo;
        expected[1] = itemThree;
        assertThat(trackerSingleton.getAll(), is(expected));
    }

    @Test
    public void whenFindItemByName() {
        Item itemOne = new Item("test5", "testDesc", 123L);
        Item itemOne1 = new Item("test5", "testDesc", 123L);
        Item itemTwo = new Item("test2", "testDesc2", 1234L);
        Item itemThree = new Item("test4", "testDesc3", 12345L);
        trackerSingleton.add(itemOne);
        trackerSingleton.add(itemTwo);
        trackerSingleton.add(itemThree);
        trackerSingleton.add(itemOne1);
        Item[] expected = new Item[2];
        expected[0] = itemOne;
        expected[1] = itemOne1;
        assertThat(trackerSingleton.findByName(itemOne.getName()), is(expected));
    }

    @Test
    public void whenYouFindAnItemById() {
        Item wanted = new Item("test1", "testDesc", 123L);
        trackerSingleton.add(wanted);
        Item item = new Item("test2", "descTwo", 1234L);
        trackerSingleton.add(item);
        assertThat(trackerSingleton.findById(wanted.getId()), is(wanted));
    }

    @Test
    public void whenYouGetAllItems() {
        Item item1 = new Item("test1", "testDesc", 123L);
        trackerSingleton.add(item1);
        Item item2 = new Item("test2", "descTwo", 1234L);
        trackerSingleton.add(item2);
        Item[] expected = new Item[2];
        expected[0] = item1;
        expected[1] = item2;
        assertThat(trackerSingleton.getAll(), is(expected));
    }
}
