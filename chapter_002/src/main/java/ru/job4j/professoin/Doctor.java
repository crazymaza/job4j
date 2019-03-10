package ru.job4j.professoin;

public class Doctor extends Profession {
    public Diagnose heal(Patient patient) {
        return new Diagnose();
    }
}
