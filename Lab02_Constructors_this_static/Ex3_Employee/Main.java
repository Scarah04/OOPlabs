// Lab 2 - Exercise 3 (Intermediate): auto id, overloaded constructors, copy constructor
class Employee {
    private static int nextId = 1;
    private final int employeeId;
    private String name;
    private String department;
    private double salary;

    Employee() { this("Unknown"); }
    Employee(String name) { this(name, "General"); }
    Employee(String name, String department) { this(name, department, 0.0); }
    Employee(String name, String department, double salary) {
        this.employeeId = nextId++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    // copy constructor (gets a NEW id)
    Employee(Employee other) { this(other.name, other.department, other.salary); }

    public String toString() {
        return "Employee#" + employeeId + " " + name + ", " + department + ", $" + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee("Alice");
        Employee e3 = new Employee("Bob", "IT");
        Employee e4 = new Employee("Carol", "Finance", 4500);
        Employee e5 = new Employee(e4);
        System.out.println(e1); System.out.println(e2); System.out.println(e3);
        System.out.println(e4); System.out.println(e5);
    }
}
