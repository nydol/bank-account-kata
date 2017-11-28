package fr.bank.account;

import fr.bank.account.domain.Account;
import fr.bank.account.domain.Bank;

import java.time.ZonedDateTime;

public class Main {

    public static void main(String[] args) {
        Bank bank = Bank.createBank(ZonedDateTime::now);

        Account myAccount = Account.createAccount(0L);

        bank.deposit(myAccount, 25600L);
        bank.withdraw(myAccount, 12800L);
        bank.deposit(myAccount, 25600L);
        bank.deposit(myAccount, 12800L);
        bank.deposit(myAccount, 51200L);

        System.out.println(myAccount.toString());
    }

}
