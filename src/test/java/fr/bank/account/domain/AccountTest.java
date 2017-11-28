package fr.bank.account.domain;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private static final ZonedDateTime ZONED_DATE_TIME = ZonedDateTime.of(2017, 11, 27, 22, 9, 1, 0, ZoneId.of("Europe/Paris"));

    @Test
    public void test_createAccount() throws Exception {
        Account account = Account.createAccount(42600L);

        assertThat(account.toString()).isEqualTo("Balance = 42600\nOperations : \n");
    }

    @Test
    public void test_addOperation() throws Exception {
        Account account = Account.createAccount(42600L);
        ZonedDateTime depositDate = ZONED_DATE_TIME.plusHours(1);
        ZonedDateTime withdrawDate = ZONED_DATE_TIME.plusHours(2);

        account.addOperation(Operation.deposit(depositDate, Amount.valueOf(7400L)));
        account.addOperation(Operation.withdrawal(withdrawDate, Amount.valueOf(5000L)));

        assertThat(account.toString()).isEqualTo("Balance = 45000\nOperations : \n" +
                "DEPOSIT;" + depositDate + ";7400\n" +
                "WITHDRAWAL;" + withdrawDate + ";5000");
    }

}
