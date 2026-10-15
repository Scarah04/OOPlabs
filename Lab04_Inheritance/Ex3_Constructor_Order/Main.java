// Lab 4 - Exercise 3 (Intermediate): multilevel inheritance, constructor order
class Vehicle {
    Vehicle() { System.out.println("Vehicle constructor"); }
}
class Car extends Vehicle {
    Car() { System.out.println("Car constructor"); }
}
class ElectricCar extends Car {
    ElectricCar() { System.out.println("ElectricCar constructor"); }
}

public class Main {
    public static void main(String[] args) {
        new ElectricCar();   // order: Vehicle -> Car -> ElectricCar
    }
}
