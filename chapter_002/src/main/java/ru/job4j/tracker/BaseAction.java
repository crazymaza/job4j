package ru.job4j.tracker;

abstract class BaseAction implements UserAction {
    private final int numberOfMenu;
    private final String name;

    public BaseAction(int numberOfMenu, String name) {
        this.numberOfMenu = numberOfMenu;
        this.name = name;
    }

    public int key() {
        return this.numberOfMenu;
    }

    public String info() {
        return String.format("%s. %s", this.numberOfMenu, this.name);
    }
}
