// Lab 2 - Exercise 2 (Basic): static counter
class Circle {
    private static int count = 0;
    double radius;

    Circle(double radius) { this.radius = radius; count++; }
    Circle() { this(1.0); }

    static int getCount() { return count; }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Circles: " + Circle.getCount());
        new Circle(); new Circle(3); new Circle(4.5);
        System.out.println("Circles: " + Circle.getCount());
    }
}
