package tracker;

import java.util.Random;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private final static Random RANDOM = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RANDOM.nextInt(100));
    }

    public void replace(String id, Item item) {
        for (int index = 0; index != items.length; index++) {
            if (items[index].getId().equals(id)) {
                items[index] = item;
                break;
            }
        }
    }

    public void delete(String id) {
        for (int index = 0; index != items.length; index++) {
            if (items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, position--);
            }
        }
    }

    public Item[] getAll() {
        return items;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[position];
        for (int index = 0; index != items.length; index++) {
            if (items[index] != null && items[index].getName().equals(key)) {
                result[index] = items[index];
            }
        }
        return result;
    }





}
