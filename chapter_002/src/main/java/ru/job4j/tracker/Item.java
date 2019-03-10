package ru.job4j.tracker;

/**
 * Класс заявки.
 * {value} name - название заявки.
 * {value} id - идентификатор заявки.
 * {value} description - описание заявки.
 * {value} create - число когда была создана.
 * {value} comments - комментарий к заявки.
 */
public class Item {
    private String name;
    private String id;
    private String description;
    private long create;
    private String[] comments;
    private final String ln = System.lineSeparator();

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public long getCreate() {
        return create;
    }

    public String[] getComments() {
        return comments;
    }

    /**
     * Переопределили метод toString, чтобы сделать проще код вывода заявки в классе StartUI.
     * Данный метод будет применяться при выводе всех заявок, нахождении по id и названию.
     *
     * @return вывод заявки в выбранном формате.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id заявки: ")
                .append(this.getId())
                .append(ln)
                .append("Название заявки: ")
                .append(this.getName())
                .append(ln)
                .append("Описание заявки: ")
                .append(this.getDescription())
                .append(ln)
                .append("-------------");
        return sb.toString();
    }

}
