import java.util.*;

// Lab 8 - Exercise 2 (Basic)
public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Ann", "Ben", "Ann", "Cleo", "Ben", "Dan");
        Set<String> unique = new LinkedHashSet<>(names);   // keeps first-seen order
        System.out.println("Original: " + names);
        System.out.println("Unique:   " + unique);
    }
}
