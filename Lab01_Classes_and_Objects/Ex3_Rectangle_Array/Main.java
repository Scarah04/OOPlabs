// Lab 1 - Exercise 3 (Intermediate): array of 5 rectangles, print the largest area
class Rectangle {
    double width;
    double height;

    Rectangle(double width, double height) { this.width = width; this.height = height; }

    double area()      { return width * height; }
    double perimeter() { return 2 * (width + height); }
}

public class Main {
    public static void main(String[] args) {
        Rectangle[] rects = {
            new Rectangle(2, 3), new Rectangle(5, 4), new Rectangle(1, 10),
            new Rectangle(6, 6), new Rectangle(3, 3)
        };
        Rectangle largest = rects[0];
        for (Rectangle r : rects) {
            System.out.println(r.width + " x " + r.height + " area=" + r.area() + " perimeter=" + r.perimeter());
            if (r.area() > largest.area()) largest = r;
        }
        System.out.println("Largest: " + largest.width + " x " + largest.height + " area=" + largest.area());
    }
}
