package fr.bank.account.domain;

import java.time.ZonedDateTime;

abstract class Operation {

    private final ZonedDateTime date;

    private final Amount amount;

    Operation(ZonedDateTime date, Amount amount) {
        this.date = date;
        this.amount = amount;
    }

    static Operation deposit(ZonedDateTime date, Amount amount) {
        return new Deposit(date, amount);
    }

    static Operation withdrawal(ZonedDateTime date, Amount amount) {
        return new Withdrawal(date, amount);
    }

    ZonedDateTime getDate() {
        return date;
    }

    Amount getAmount() {
        return amount;
    }

    abstract Amount applyTo(Amount amount);

}
