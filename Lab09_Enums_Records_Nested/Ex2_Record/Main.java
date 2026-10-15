// Lab 9 - Exercise 2 (Basic)
record Student(String name, int age) { }

public class Main {
    public static void main(String[] args) {
        Student a = new Student("Tino", 21);
        Student b = new Student("Tino", 21);
        System.out.println(a);                          // toString generated
        System.out.println("a.equals(b): " + a.equals(b));   // value equality
        System.out.println("a == b: " + (a == b));
        System.out.println("name component: " + a.name());
    }
}
