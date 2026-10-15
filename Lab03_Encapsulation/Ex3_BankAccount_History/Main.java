import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Lab 3 - Exercise 3 (Intermediate): transaction history, unmodifiable copy
class BankAccount {
    private final String owner;
    private double balance;
    private final List<String> history = new ArrayList<>();

    BankAccount(String owner, double opening) {
        this.owner = owner;
        this.balance = opening;
        history.add("Opened with " + opening);
    }

    void deposit(double amount) {
        if (amount <= 0) { history.add("Rejected deposit " + amount); return; }
        balance += amount;
        history.add("Deposit " + amount);
    }

    boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) { history.add("Rejected withdrawal " + amount); return false; }
        balance -= amount;
        history.add("Withdraw " + amount);
        return true;
    }

    double getBalance() { return balance; }

    List<String> getHistory() {
        return Collections.unmodifiableList(new ArrayList<>(history));
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Tariro", 100);
        acc.deposit(50);
        acc.withdraw(30);
        acc.withdraw(1000);
        for (String line : acc.getHistory()) System.out.println(line);
        System.out.println("Balance: " + acc.getBalance());
        try {
            acc.getHistory().add("hacked");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify history from outside.");
        }
    }
}
