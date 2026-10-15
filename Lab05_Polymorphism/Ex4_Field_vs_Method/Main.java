// Lab 5 - Exercise 4 (Intermediate): methods are polymorphic, fields are not
class Parent {
    String name = "Parent field";
    String who() { return "Parent method"; }
}
class Child extends Parent {
    String name = "Child field";
    @Override String who() { return "Child method"; }
}

public class Main {
    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println(p.who());    // Child method  (decided at run time by actual object)
        System.out.println(p.name);     // Parent field  (decided at compile time by reference type)
        /* Explanation: overridden methods use dynamic dispatch (the JVM looks at the real
           object). Fields are hidden, not overridden, so the declared type of the
           reference (Parent) decides which field is read. */
    }
}
