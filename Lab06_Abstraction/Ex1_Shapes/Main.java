// Lab 6 - Exercise 1 (Basic): abstract Shape
abstract class Shape {
    abstract double area();
    abstract double perimeter();
    void show() {
        System.out.printf("%s: area=%.2f perimeter=%.2f%n", getClass().getSimpleName(), area(), perimeter());
    }
}
class Circle extends Shape {
    double r;
    Circle(double r) { this.r = r; }
    double area() { return Math.PI * r * r; }
    double perimeter() { return 2 * Math.PI * r; }
}
class Rectangle extends Shape {
    double w, h;
    Rectangle(double w, double h) { this.w = w; this.h = h; }
    double area() { return w * h; }
    double perimeter() { return 2 * (w + h); }
}
class Square extends Rectangle {
    Square(double s) { super(s, s); }
}

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(3), new Rectangle(4, 5), new Square(4) };
        for (Shape s : shapes) s.show();
    }
}
