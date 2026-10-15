// Lab 6 - Exercise 3 (Intermediate): abstract Account
abstract class Account {
    protected double balance;
    Account(double opening) { balance = opening; }
    void deposit(double amt) { if (amt > 0) balance += amt; }
    abstract double monthlyFee();
    void applyFee() { balance -= monthlyFee(); }
}
class SavingsAccount extends Account {
    SavingsAccount(double o) { super(o); }
    double monthlyFee() { return 2.0; }
}
class CurrentAccount extends Account {
    CurrentAccount(double o) { super(o); }
    double monthlyFee() { return 10.0; }
}

public class Main {
    public static void main(String[] args) {
        Account[] accts = { new SavingsAccount(100), new CurrentAccount(100) };
        for (Account a : accts) {
            a.deposit(50);
            a.applyFee();
            System.out.println(a.getClass().getSimpleName() + " balance after fee: " + a.balance);
        }
    }
}
