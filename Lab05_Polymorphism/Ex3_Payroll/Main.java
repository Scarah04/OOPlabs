// Lab 5 - Exercise 3 (Intermediate): payroll loop never changes when Intern is added
class Employee {
    String name;
    Employee(String name) { this.name = name; }
    double pay() { return 0; }
}
class FullTime extends Employee {
    double monthly;
    FullTime(String n, double m) { super(n); monthly = m; }
    @Override double pay() { return monthly; }
}
class PartTime extends Employee {
    double rate; int hours;
    PartTime(String n, double rate, int hours) { super(n); this.rate = rate; this.hours = hours; }
    @Override double pay() { return rate * hours; }
}
class Intern extends Employee {
    double stipend;
    Intern(String n, double s) { super(n); stipend = s; }
    @Override double pay() { return stipend; }
}

public class Main {
    public static void main(String[] args) {
        Employee[] staff = {
            new FullTime("Alice", 3000), new PartTime("Bob", 20, 80), new Intern("Cleo", 500)
        };
        double total = 0;
        for (Employee e : staff) {          // this loop is unchanged for new subclasses
            System.out.println(e.name + ": " + e.pay());
            total += e.pay();
        }
        System.out.println("Total payroll: " + total);
    }
}
