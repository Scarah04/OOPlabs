// Lab 3 - Exercise 2 (Basic): getGrade() computed, not stored
class Student {
    private String name;
    private int marks;

    Student(String name, int marks) { this.name = name; this.marks = marks; }

    String getName() { return name; }

    String getGrade() {
        if (marks >= 75) return "A";
        if (marks >= 60) return "B";
        if (marks >= 50) return "C";
        return "F";
    }
}

public class Main {
    public static void main(String[] args) {
        Student[] list = { new Student("Ann", 82), new Student("Ben", 64),
                           new Student("Cat", 51), new Student("Dan", 30) };
        for (Student s : list) System.out.println(s.getName() + " -> " + s.getGrade());
    }
}
