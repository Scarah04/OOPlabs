// Lab 1 - Exercise 1 (Basic): Car class with display()
class Car {
    String brand;
    int year;
    int mileage;

    void display() {
        System.out.println("Brand: " + brand + ", Year: " + year + ", Mileage: " + mileage + " km");
    }
}

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car(); c1.brand = "Toyota"; c1.year = 2018; c1.mileage = 60000;
        Car c2 = new Car(); c2.brand = "Ford";   c2.year = 1995; c2.mileage = 210000;
        Car c3 = new Car(); c3.brand = "Honda";  c3.year = 2022; c3.mileage = 15000;
        c1.display();
        c2.display();
        c3.display();
    }
}
