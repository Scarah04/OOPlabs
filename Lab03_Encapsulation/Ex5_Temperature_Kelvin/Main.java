// Lab 3 - Exercise 5 (Challenge): kelvin stored internally
class Temperature {
    private double kelvin;   // internal detail - could change without breaking callers

    Temperature(double celsius) { setCelsius(celsius); }

    void setCelsius(double c) {
        double k = c + 273.15;
        if (k < 0) throw new IllegalArgumentException("Below absolute zero: " + c + " C");
        kelvin = k;
    }
    double getCelsius()    { return kelvin - 273.15; }
    double getFahrenheit() { return getCelsius() * 9 / 5 + 32; }
}

public class Main {
    public static void main(String[] args) {
        Temperature t = new Temperature(25);
        System.out.println("C: " + t.getCelsius() + "  F: " + t.getFahrenheit());
        try {
            t.setCelsius(-300);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        // Callers only use getCelsius()/getFahrenheit(), so storing Celsius instead of
        // Kelvin inside the class would not require any change in this main method.
    }
}
