package fr.bank.account.domain;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class BankTest {

    private static final ZonedDateTime ZONED_DATE_TIME = ZonedDateTime.of(2017, 11, 27, 22, 32, 4, 0, ZoneId.of("Europe/Paris"));

    @Test
    public void deposit() {
        Bank bank = Bank.createBank(() -> ZONED_DATE_TIME);

        Account account = Account.createAccount(64600L);

        Amount actual = bank.deposit(account, 5400L);

        assertThat(actual.toLong()).isEqualTo(70000L);
    }

    @Test
    public void withdraw() {
        Bank bank = Bank.createBank(() -> ZONED_DATE_TIME);

        Account account = Account.createAccount(65400L);

        Amount actual = bank.withdraw(account, 5400L);

        assertThat(actual.toLong()).isEqualTo(60000L);
    }

}
