package ru.job4j.loop;

public class Paint {
    public String rightTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int wight = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != wight; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int wight = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != wight; column++) {
                if (row >= wight - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    public String piramid(int height) {
        StringBuilder screen = new StringBuilder();
        int wight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != wight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}

