// Lab 7 - Exercise 3 (Intermediate): custom checked exception
class InvalidAgeException extends Exception {
    InvalidAgeException(String message) { super(message); }
}

public class Main {
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) throw new InvalidAgeException("Age " + age + " is outside 0 to 120");
        System.out.println("Age " + age + " is valid");
    }
    public static void main(String[] args) {
        int[] ages = {25, -3, 130, 120};
        for (int a : ages) {
            try { validateAge(a); }
            catch (InvalidAgeException e) { System.out.println("Caught: " + e.getMessage()); }
        }
    }
}
