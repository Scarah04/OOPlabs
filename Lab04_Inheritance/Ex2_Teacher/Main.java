// Lab 4 - Exercise 2 (Basic): Student and Teacher share Person code
class Person {
    String name; int age;
    Person(String name, int age) { this.name = name; this.age = age; }
    void display() { System.out.println("Name: " + name + ", Age: " + age); }
}
class Student extends Person {
    String course;
    Student(String n, int a, String course) { super(n, a); this.course = course; }
}
class Teacher extends Person {
    String subject;
    Teacher(String n, int a, String subject) { super(n, a); this.subject = subject; }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Nyasha", 20, "IT");
        Teacher t = new Teacher("Mr Moyo", 45, "Maths");
        s.display();   // both use the SAME display() inherited from Person
        t.display();
    }
}
