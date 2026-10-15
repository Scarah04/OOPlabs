// Lab 4 - Exercise 1 (Basic): Person and Student
class Person {
    String name; int age;
    Person(String name, int age) { this.name = name; this.age = age; }
    void display() { System.out.println("Name: " + name + ", Age: " + age); }
}

class Student extends Person {
    String course;
    Student(String name, int age, String course) { super(name, age); this.course = course; }
    @Override void display() { super.display(); System.out.println("Course: " + course); }
}

public class Main {
    public static void main(String[] args) {
        new Person("Tawanda", 40).display();
        new Student("Nyasha", 20, "Computer Science").display();
    }
}
