import java.util.*;

// Lab 10 - Exercise 4 (Intermediate)
record Student(String name, int marks) { }

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Zodwa", 80), new Student("Alex", 90), new Student("Mary", 55),
            new Student("Peter", 70), new Student("Bella", 85));
        double avg = students.stream().mapToInt(Student::marks).average().orElse(0);
        System.out.println("Class average: " + avg);
        students.stream()
                .filter(s -> s.marks() > avg)
                .map(Student::name)
                .sorted()
                .forEach(System.out::println);
    }
}
