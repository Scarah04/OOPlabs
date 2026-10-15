// Lab 5 - Exercise 5 (Challenge): instanceof pattern matching vs polymorphic process()
interface Payment { void process(); }
class CardPayment implements Payment {
    String cardNo; double amount;
    CardPayment(String c, double a) { cardNo = c; amount = a; }
    public void process() { System.out.println("[poly] Charging card " + cardNo + " $" + amount); }
}
class MobileMoneyPayment implements Payment {
    String phone; double amount;
    MobileMoneyPayment(String p, double a) { phone = p; amount = a; }
    public void process() { System.out.println("[poly] Mobile money from " + phone + " $" + amount); }
}

class PaymentProcessor {
    // Version 1: instanceof pattern matching - must be edited for every new payment type
    void pay(Payment p) {
        if (p instanceof CardPayment c) {
            System.out.println("[instanceof] Charging card " + c.cardNo + " $" + c.amount);
        } else if (p instanceof MobileMoneyPayment m) {
            System.out.println("[instanceof] Mobile money from " + m.phone + " $" + m.amount);
        } else {
            System.out.println("Unknown payment type");
        }
    }
    // Version 2: polymorphic - new types just implement process(); this method never changes
    void payPoly(Payment p) { p.process(); }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor proc = new PaymentProcessor();
        Payment[] list = { new CardPayment("1234-5678", 50), new MobileMoneyPayment("0771234567", 20) };
        for (Payment p : list) proc.pay(p);
        for (Payment p : list) proc.payPoly(p);
        // Comparison: the polymorphic design follows the open/closed principle.
    }
}
