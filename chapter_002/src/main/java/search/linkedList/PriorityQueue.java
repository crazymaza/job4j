package search.linkedList;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.isEmpty()) {
            tasks.add(task);
        }
        if (task.getPriority() < tasks.getFirst().getPriority()
                && tasks.getFirst() != null) {
            tasks.addFirst(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
