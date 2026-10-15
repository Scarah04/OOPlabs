import java.util.*;

// Lab 11 - Design patterns: Singleton, Factory, Strategy, Observer
// ---------- SINGLETON ----------
class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();
    private final String institution = "Example University";
    private AppConfig() { }
    static AppConfig getInstance() { return INSTANCE; }
    String getInstitution() { return institution; }
}

// ---------- FACTORY ----------
interface Shape { double area(); }
class Circle implements Shape {
    double r; Circle(double r) { this.r = r; }
    public double area() { return Math.PI * r * r; }
}
class Square implements Shape {
    double s; Square(double s) { this.s = s; }
    public double area() { return s * s; }
}
class ShapeFactory {
    static Shape create(String type, double size) {
        switch (type.toLowerCase()) {
            case "circle": return new Circle(size);
            case "square": return new Square(size);
            default: throw new IllegalArgumentException("Unknown shape: " + type);
        }
    }
}

// ---------- STRATEGY ----------
interface DiscountStrategy { double apply(double price); }
class NoDiscount implements DiscountStrategy { public double apply(double p) { return p; } }
class StudentDiscount implements DiscountStrategy { public double apply(double p) { return p * 0.8; } }
class Cart {
    private DiscountStrategy strategy;
    Cart(DiscountStrategy s) { strategy = s; }
    void setStrategy(DiscountStrategy s) { strategy = s; }
    double checkout(double total) { return strategy.apply(total); }
}

// ---------- OBSERVER ----------
interface Observer { void update(String message); }
class NewsAgency {
    private final List<Observer> observers = new ArrayList<>();
    void subscribe(Observer o) { observers.add(o); }
    void publish(String news) { for (Observer o : observers) o.update(news); }
}
class Subscriber implements Observer {
    private final String name;
    Subscriber(String name) { this.name = name; }
    public void update(String message) { System.out.println(name + " received: " + message); }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("== Singleton ==");
        System.out.println(AppConfig.getInstance().getInstitution());
        System.out.println("Same instance? " + (AppConfig.getInstance() == AppConfig.getInstance()));

        System.out.println("== Factory ==");
        System.out.printf("Circle area: %.2f%n", ShapeFactory.create("circle", 2).area());
        System.out.printf("Square area: %.2f%n", ShapeFactory.create("square", 3).area());

        System.out.println("== Strategy ==");
        Cart cart = new Cart(new NoDiscount());
        System.out.println("No discount: " + cart.checkout(100));
        cart.setStrategy(new StudentDiscount());
        System.out.println("Student discount: " + cart.checkout(100));

        System.out.println("== Observer ==");
        NewsAgency agency = new NewsAgency();
        agency.subscribe(new Subscriber("Alice"));
        agency.subscribe(new Subscriber("Bob"));
        agency.publish("Lab 11 is published!");
    }
}
