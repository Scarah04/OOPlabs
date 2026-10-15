import java.util.*;

// Lab 7 - Exercise 1 (Basic): read two ints and divide
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Enter first integer: ");
            int a = Integer.parseInt(in.nextLine().trim());
            System.out.print("Enter second integer: ");
            int b = Integer.parseInt(in.nextLine().trim());
            System.out.println(a + " / " + b + " = " + (a / b));
        } catch (NumberFormatException e) {
            System.out.println("Error: input was not a whole number.");
        } catch (ArithmeticException e) {
            System.out.println("Error: cannot divide by zero.");
        } catch (NoSuchElementException e) {
            System.out.println("Error: no input supplied.");
        }
    }
}
