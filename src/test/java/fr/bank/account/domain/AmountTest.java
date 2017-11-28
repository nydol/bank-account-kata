package fr.bank.account.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    @Test
    public void test_valueOf() throws Exception {
        Amount actual = Amount.valueOf(14200L);

        assertThat(actual.toLong()).isEqualTo(14200L);
    }

    @Test
    public void test_add() throws Exception {
        Amount amount = Amount.valueOf(15600L);

        Amount actual = amount.add(Amount.valueOf(4400L));

        assertThat(actual.toLong()).isEqualTo(20000L);
    }

    @Test
    public void test_subtract() throws Exception {
        Amount amount = Amount.valueOf(15600L);

        Amount actual = amount.subtract(Amount.valueOf(5600L));

        assertThat(actual.toLong()).isEqualTo(10000L);
    }

}
