// Lab 2 - Exercise 5 (Challenge): static factory methods + private constructor
class Temperature {
    private final double celsius;
    private Temperature(double celsius) { this.celsius = celsius; }

    static Temperature fromCelsius(double c)    { return new Temperature(c); }
    static Temperature fromFahrenheit(double f) { return new Temperature((f - 32) * 5 / 9); }

    double getCelsius()    { return celsius; }
    double getFahrenheit() { return celsius * 9 / 5 + 32; }
}

public class Main {
    public static void main(String[] args) {
        Temperature t1 = Temperature.fromCelsius(100);
        Temperature t2 = Temperature.fromFahrenheit(32);
        System.out.println("t1: " + t1.getCelsius() + " C = " + t1.getFahrenheit() + " F");
        System.out.println("t2: " + t2.getCelsius() + " C = " + t2.getFahrenheit() + " F");
        /* WHY FACTORIES: Both units are a double, so two constructors Temperature(double)
           would clash. Factory methods have names (fromCelsius / fromFahrenheit) that say
           what the argument means, and they can validate or return cached objects. */
    }
}
