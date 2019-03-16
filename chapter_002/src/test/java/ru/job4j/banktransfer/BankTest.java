package ru.job4j.banktransfer;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.banktransfers.Account;
import ru.job4j.banktransfers.Bank;
import ru.job4j.banktransfers.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    private Bank bank = new Bank();
    private User firstUser = new User("Azazel", "1234");

    @Before
    public void addUserToBank() {
        bank.addUser(firstUser);
        bank.addAccountToUser("1234", new Account(234.56));
    }

    @Test
    public void whenUsersCountInBankIsNotZero() {
        int result = bank.getBanks().size();
        assertThat(result, is(1));
    }

    @Test
    public void whenAddAccountToUser() {
        int result = bank.getUserAccounts("1234").size();
        assertThat(result, is(1));
    }

    @Test
    public void whenDeleteUser() {
        bank.deleteUser(firstUser);
        int result = bank.getBanks().size();
        assertThat(result, is(0));
    }

    @Test
    public void whenDeleteAccountFromUser() {
        bank.deleteAccountFromUser("1234", bank.getUserAccounts("1234")
                .get(bank.getUserAccounts("1234").size() - 1));
        int result = bank.getUserAccounts("1234").size();
        assertThat(result, is(0));
    }

    @Test
    public void whenTransferMoneyToOtherAccount() {
        User secondUser = new User("Marshal", "12345");
        bank.addUser(secondUser);
        bank.addAccountToUser("12345", new Account(100));
        boolean transfer = bank.transferMoney(firstUser.getPassport(), bank.getUserAccounts("1234")
                        .get(0).getRequisites(),
                secondUser.getPassport(), bank.getUserAccounts("12345")
                        .get(0).getRequisites(), 50);
        double firstAmountOfMoney = bank.getUserAccounts("1234").get(0).getValue();
        double secondAmountOfMoney = bank.getUserAccounts("12345").get(0).getValue();
        assertThat(firstAmountOfMoney, is(184.56));
        assertThat(secondAmountOfMoney, is(150.0));
        assertThat(transfer, is(true));
    }

}
