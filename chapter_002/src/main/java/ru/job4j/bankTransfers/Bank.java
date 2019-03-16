package ru.job4j.bankTransfers;

import java.util.*;

public class Bank {
    private Map<User, List<Account>> banks = new HashMap<>();
    private final static Random RND = new Random();

    public Map<User, List<Account>> getBanks() {
        return banks;
    }

    /**
     * Добавление пользователя в банк.
     *
     * @param user - пользователь.
     */
    public void addUser(User user) {
        banks.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаление пользователя из банка.
     *
     * @param user - пользователь.
     */
    public void deleteUser(User user) {
        banks.remove(user);
    }

    /**
     * Генерация случайного номера счёта.
     *
     * @return - случайный номер счёта.
     */
    private String generatedId() {
        return String.valueOf(System.currentTimeMillis() + RND.nextInt(100));
    }

    /**
     * Добавление счёта пользователю.
     *
     * @param passport - паспорт пользователю.
     * @param account  - счёт, который добавляется.
     */
    public void addAccountToUser(String passport, Account account) {
        int index = 0;
        for (Map.Entry<User, List<Account>> user : banks.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                account.setRequisites(generatedId());
                user.getValue().add(index++, account);
                banks.put(user.getKey(), user.getValue());
            }
        }
    }

    /**
     * Удаление счёта пользователя.
     *
     * @param passport - паспорт пользователя.
     * @param account  - счёт для удаления.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> user : banks.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                user.getValue().remove(account);
            }
        }
    }

    /**
     * Получение списка счетов пользователя.
     *
     * @param passport - паспорт пользователя.
     * @return - список счетов пользователя.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = new ArrayList<>();
        for (Map.Entry<User, List<Account>> user : banks.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                accounts.addAll(user.getValue());
            }
        }
        return accounts;
    }

    /**
     * Перевод с счета на счет.
     *
     * @param srcPassport  - паспорт пользователя.
     * @param srcRequisite - счёт с которого переводят.
     * @param destPassport - паспорт пользователя которому переводят.
     * @param dstRequisite - счет на который переводят.
     * @param amount       - сумма перевода.
     * @return - если счет не найден или недостаточно средств, то вернётся false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dstRequisite, double amount) {
        boolean find = false;
        for (Map.Entry<User, List<Account>> user : banks.entrySet()) {
            if (user.getKey().getPassport().equals(srcPassport)) {
                for (Account account : user.getValue()) {
                    if (amount <= account.getValue() && srcRequisite.equals(account.getRequisites())) {
                        account.setValue(account.getValue() - amount);
                        find = true;
                    }
                }
            }
            if (user.getKey().getPassport().equals(destPassport)) {
                for (Account destAccount : user.getValue()) {
                    if (destAccount.getRequisites().equals(dstRequisite)) {
                        destAccount.setValue(destAccount.getValue() + amount);
                    }

                }
            }
        }
        return find;
    }
}

