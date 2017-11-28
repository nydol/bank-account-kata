package fr.bank.account.domain;

import java.time.ZonedDateTime;

class Deposit extends Operation {

    Deposit(ZonedDateTime date, Amount amount) {
        super(date, amount);
    }

    @Override
    Amount applyTo(Amount amount) {
        return amount.add(getAmount());
    }

    @Override
    public String toString() {
        return String.format("DEPOSIT;%s;%s", getDate(), getAmount());
    }

}
