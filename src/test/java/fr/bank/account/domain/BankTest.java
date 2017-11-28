package fr.bank.account.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class BankTest {

    private static final ZonedDateTime ZONED_DATE_TIME = ZonedDateTime.of(2017, 11, 27, 22, 32, 4, 0, ZoneId.of("Europe/Paris"));

    @Test
    public void test_deposit() throws Exception {
        Bank bank = Bank.createBank(() -> ZONED_DATE_TIME);

        Account account = Account.createAccount(64600L);

        Amount actual = bank.deposit(account, 5400L);

        Assertions.assertThat(actual.toLong()).isEqualTo(70000L);
    }

    @Test
    public void test_withdraw() throws Exception {
        Bank bank = Bank.createBank(() -> ZONED_DATE_TIME);

        Account account = Account.createAccount(65400L);

        Amount actual = bank.withdraw(account, 5400L);

        Assertions.assertThat(actual.toLong()).isEqualTo(60000L);
    }

}
