package fr.bank.account.domain;

import java.time.ZonedDateTime;

class Withdrawal extends Operation {

    Withdrawal(ZonedDateTime date, Amount amount) {
        super(date, amount);
    }

    @Override
    Amount applyTo(Amount amount) {
        return amount.subtract(getAmount());
    }

    @Override
    public String toString() {
        return String.format("WITHDRAWAL;%s;%s", getDate(), getAmount());
    }

}
