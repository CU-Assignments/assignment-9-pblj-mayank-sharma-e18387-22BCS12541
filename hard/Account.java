package hard;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public Account() {}

    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getters & Setters
    public int getAccountNumber() { return accountNumber; }
    public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }

    public String getAccountHolder() { return accountHolder; }
    public void setAccountHolder(String accountHolder) { this.accountHolder = accountHolder; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    @Override
    public String toString() {
        return accountHolder + " (" + accountNumber + ") - ₹" + balance;
    }
}
