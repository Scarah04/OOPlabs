// Lab 4 - Exercise 4 (Intermediate): why "Dog extends Animal" fails
class Animal {
    String name;
    Animal(String name) { this.name = name; }   // NO no-argument constructor
}

/* This version does NOT compile:
   class Dog extends Animal { }
   error: constructor Animal in class Animal cannot be applied to given types
   Reason: every constructor must call super(...) first. If we write nothing, Java inserts
   super() automatically, but Animal has no no-arg constructor, so compilation fails.
   Fix: call super(name) explicitly, as below. */
class Dog extends Animal {
    Dog(String name) { super(name); }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog("Rex");
        System.out.println("Dog name: " + d.name);
    }
}
