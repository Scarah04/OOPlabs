// Lab 3 - Exercise 1 (Basic): private fields and validating setter
class Student {
    private String name;
    private int marks;

    Student(String name, int marks) { this.name = name; setMarks(marks); }

    String getName() { return name; }
    int getMarks()   { return marks; }

    void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            System.out.println("Rejected invalid marks: " + marks);
            return;
        }
        this.marks = marks;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Farai", 70);
        System.out.println(s.getName() + ": " + s.getMarks());
        s.setMarks(150);
        s.setMarks(-5);
        s.setMarks(85);
        System.out.println(s.getName() + ": " + s.getMarks());
    }
}
