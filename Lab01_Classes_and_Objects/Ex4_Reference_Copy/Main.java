// Lab 1 - Exercise 4 (Intermediate): reference assignment
class Rectangle {
    double width, height;
    Rectangle(double w, double h) { width = w; height = h; }
}

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = r1;      // copies the REFERENCE, not the object
        r2.width = 10;
        System.out.println("r1.width = " + r1.width);   // prints 10.0
        System.out.println("Same object? " + (r1 == r2));
        /* EXPLANATION (lab record):
           r1 and r2 both hold the same address, so there is only ONE Rectangle object
           on the heap. Changing the width through r2 changes the same object that r1
           points to, so r1.width prints 10.0 and not 4.0. */
    }
}
