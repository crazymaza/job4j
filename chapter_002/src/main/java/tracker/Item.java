package tracker;

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


}
