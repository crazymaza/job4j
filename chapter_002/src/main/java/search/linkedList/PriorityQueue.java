package search.linkedList;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * <p>
     * {value}index - индекс элемента в массиве.
     * Проходимся по всему массиву {value}tasks и сравниваем приоритет
     * всех элементов коллекции.
     * Если элемент не null и если приоритет элемента больще приоритета {value}task,
     * то тогда мы выходим из цикла и итерируем {value}index.
     * В противном случае мы записываем элемент в коллекцию под значением {value}index.
     *
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        for (Task t : tasks) {
            if (t != null && t.getPriority() > task.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
