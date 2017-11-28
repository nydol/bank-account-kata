package fr.bank.account.domain;

import java.time.ZonedDateTime;
import java.util.function.Supplier;

public class Bank {

    private final Supplier<ZonedDateTime> timeSupplier;

    private Bank(Supplier<ZonedDateTime> timeSupplier) {
        this.timeSupplier = timeSupplier;
    }

    /**
     * Create a new bank
     * @param timeSupplier supplier of ZonedDateTime
     * @return a new bank
     */
    public static Bank createBank(Supplier<ZonedDateTime> timeSupplier) {
        return new Bank(timeSupplier);
    }

    /**
     * Deposit amount into
     * @param account account on which to deposit
     * @param amount amount to deposit
     * @return new account balance
     */
    public Amount deposit(Account account, long amount) {
        return account.addOperation(Operation.deposit(timeSupplier.get(), Amount.valueOf(amount)));
    }

    /**
     * Withdraw amount from account
     * @param account account on which to withdraw
     * @param amount amount to withdraw
     * @return new account balance
     */
    public Amount withdraw(Account account, long amount) {
        return account.addOperation(Operation.withdrawal(timeSupplier.get(), Amount.valueOf(amount)));
    }

}
