package fr.bank.account.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Account {

    private Amount balance;

    private final List<Operation> operations = new ArrayList<>();

    private Account(Amount initialBalance) {
        this.balance = initialBalance;
    }

    /**
     * Create a new Account with initial balance
     * @param balance the initial balance
     * @return a new account
     */
    public static Account createAccount(long balance) {
        return new Account(Amount.valueOf(balance));
    }

    Amount addOperation(Operation operation) {
        operations.add(operation);

        balance = operation.applyTo(balance);

        return balance;
    }

    @Override
    public String toString() {
        return "Balance = " + balance + "\n" +
               "Operations : \n" +
                operations.stream().map(Operation::toString).collect(Collectors.joining("\n"));
    }
}
