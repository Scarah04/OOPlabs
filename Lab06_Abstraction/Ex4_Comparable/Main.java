import java.util.*;

// Lab 6 - Exercise 4 (Intermediate): Comparable (by name) and Comparator (by marks)
class Student implements Comparable<Student> {
    String name; int marks;
    Student(String name, int marks) { this.name = name; this.marks = marks; }
    public int compareTo(Student o) { return name.compareTo(o.name); }
    public String toString() { return name + "(" + marks + ")"; }
}

public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
            new Student("Zodwa", 70), new Student("Alex", 90), new Student("Mary", 55)));
        Collections.sort(list);
        System.out.println("By name:  " + list);
        Comparator<Student> byMarks = (a, b) -> Integer.compare(b.marks, a.marks);
        list.sort(byMarks);
        System.out.println("By marks: " + list);
    }
}
