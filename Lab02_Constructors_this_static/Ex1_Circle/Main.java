// Lab 2 - Exercise 1 (Basic): constructors
class Circle {
    double radius;
    Circle(double radius) { this.radius = radius; }
    Circle() { this(1.0); }          // no-arg constructor defaults radius to 1.0
}

public class Main {
    public static void main(String[] args) {
        Circle a = new Circle(2.5);
        Circle b = new Circle();
        System.out.println("a.radius = " + a.radius);
        System.out.println("b.radius = " + b.radius);
    }
}
