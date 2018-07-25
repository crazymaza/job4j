package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        int a = 0, b = 0;
        for (boolean aData : data) {
            if (!aData) {
                a++;
            } else {
                b++;
            }
            if (a >= 1) {
                result = false;
            }
            if (a == 0 || b == 0) {
                result = true;
            }
        }
        return result;
    }
}
