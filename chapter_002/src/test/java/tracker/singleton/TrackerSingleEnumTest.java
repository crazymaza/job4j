package tracker.singleton;

import org.junit.Test;
import tracker.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleEnumTest {
    private TrackerSingleEnum tse = TrackerSingleEnum.TRACKER_SINGLE_ENUM;

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Item item = new Item("test1", "testDesc", 123L);
        tse.add(item);
        assertThat(tse.getAll().get(0), is(item));
    }
}
