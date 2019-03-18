package ru.job4j.banktransfers;

public class Account {
    private double value;
    private String requisites;

    public Account(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    /**
     * Перевод между счетами.
     *
     * @param accountDest - счет на который переводят.
     * @param amount      - сумма перевода.
     * @return - удалось перевести или нет.
     */
    public boolean transfer(Account accountDest, double amount) {
        boolean tr = false;
        if (value >= amount) {
            value -= amount;
            accountDest.value += amount;
            tr = true;
        }
        return tr;
    }
}
