package fr.bank.account.domain;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {

    private static final ZonedDateTime ZONED_DATE_TIME = ZonedDateTime.of(2017, 11, 27, 22, 9, 1, 0, ZoneId.of("Europe/Paris"));

    @Test
    public void deposit() {
        Amount balance = Amount.valueOf(200000L);

        Operation actual = Operation.deposit(ZONED_DATE_TIME, Amount.valueOf(54700L));

        assertThat(actual.applyTo(balance).toLong()).isEqualTo(254700L);
        assertThat(actual.toString()).isEqualTo("DEPOSIT;" + ZONED_DATE_TIME + ";54700");
    }

    @Test
    public void withdrawal() {
        Amount balance = Amount.valueOf(200000L);

        Operation actual = Operation.withdrawal(ZONED_DATE_TIME, Amount.valueOf(57000L));

        assertThat(actual.applyTo(balance).toLong()).isEqualTo(143000L);
        assertThat(actual.toString()).isEqualTo("WITHDRAWAL;" + ZONED_DATE_TIME + ";57000");
    }

}
