// Lab 7 - Exercise 4 (Intermediate): withdraw throws exception
class InsufficientFundsException extends Exception {
    final double shortBy;
    InsufficientFundsException(double shortBy) {
        super("Insufficient funds, short by " + shortBy);
        this.shortBy = shortBy;
    }
}

class BankAccount {
    private double balance;
    BankAccount(double b) { balance = b; }
    void withdraw(double amt) throws InsufficientFundsException {
        if (amt > balance) throw new InsufficientFundsException(amt - balance);
        balance -= amt;
    }
    double getBalance() { return balance; }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(100);
        try {
            acc.withdraw(40);
            System.out.println("Balance: " + acc.getBalance());
            acc.withdraw(100);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        /* TRADE-OFFS: A boolean return can be silently ignored; a checked exception forces
           the caller to handle failure and can carry details (shortBy). But exceptions add
           boilerplate and are slower, so use them for exceptional cases, not normal flow. */
    }
}
