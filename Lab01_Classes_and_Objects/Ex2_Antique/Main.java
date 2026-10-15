// Lab 1 - Exercise 2 (Basic): isAntique() - more than 25 years old
class Car {
    String brand;
    int year;
    int mileage;

    void display() {
        System.out.println(brand + " (" + year + ") " + mileage + " km, antique: " + isAntique());
    }

    boolean isAntique() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - year > 25;
    }
}

public class Main {
    public static void main(String[] args) {
        Car a = new Car(); a.brand = "Ford";  a.year = 1995; a.mileage = 210000;
        Car b = new Car(); b.brand = "Honda"; b.year = 2022; b.mileage = 15000;
        a.display();
        b.display();
    }
}
