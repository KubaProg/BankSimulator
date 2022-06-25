package Bank;

import ClientSection.Client;

import java.util.Scanner;

public class Account {
private double balance=0;
private int accountNumber;

private String password;

private String login;
    public Account(){

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account(double balance, int accountNumber, String password, String login) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.password = password;
        this.login = login;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
