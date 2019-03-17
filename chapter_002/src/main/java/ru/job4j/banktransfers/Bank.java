package ru.job4j.banktransfers;

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
     * Если счёт отправки будет найден и на нём будет сумма,
     * превышающая или равная сумме перевода, то тогда с этого
     * счёта данная сумма будет снята, а на счёт зачисления добавлена.
     *
     * @param srcPassport   - паспорт пользователя.
     * @param srcRequisite  - счёт с которого переводят.
     * @param destPassport  - паспорт пользователя которому переводят.
     * @param destRequisite - счет на который переводят.
     * @param amount        - сумма перевода.
     * @return - если счет не найден или недостаточно средств, то вернётся false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean find = false;
        if (accountSearch(srcPassport, srcRequisite) && accountSearch(destPassport, destRequisite)) {
            for (Account srcAccount : getUserAccounts(srcPassport)) {
                if (srcAccount.getRequisites().equals(srcRequisite)
                        && srcAccount.getValue() >= amount) {
                    srcAccount.setValue(srcAccount.getValue() - amount);
                    for (Account destAccount : getUserAccounts(destPassport)) {
                        if (destAccount.getRequisites().equals(destRequisite)) {
                            destAccount.setValue(destAccount.getValue() + amount);
                            find = true;
                        }
                    }
                }
            }

        }
        return find;
    }

    /**
     * Если нужный счёт существует, то вернётся true.
     *
     * @param passport  - паспорт пользователя.
     * @param requisite - реквизиты счёта.
     * @return - существует счёт или нет (true / false)
     */
    private boolean accountSearch(String passport, String requisite) {
        boolean accountFound = false;
        for (Map.Entry<User, List<Account>> user : banks.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                for (Account account : user.getValue()) {
                    if (requisite.equals(account.getRequisites())) {
                        accountFound = true;
                        break;
                    }
                }
            }
        }
        return accountFound;
    }
}

