// Lab 3 - Exercise 4 (Intermediate): immutable class
/* DESIGN CHOICES:
   - final class: nobody can subclass it and add mutable behaviour.
   - private final fields: set once in the constructor, never changed.
   - no setters: state cannot be modified after creation.
   - "withX" methods return a NEW object instead of changing this one. */
final class ImmutablePerson {
    private final String name;
    private final int age;

    ImmutablePerson(String name, int age) {
        if (age < 0) throw new IllegalArgumentException("age must be >= 0");
        this.name = name;
        this.age = age;
    }
    String getName() { return name; }
    int getAge()     { return age; }
    ImmutablePerson withAge(int newAge) { return new ImmutablePerson(name, newAge); }
    public String toString() { return name + " (" + age + ")"; }
}

public class Main {
    public static void main(String[] args) {
        ImmutablePerson p = new ImmutablePerson("Chipo", 20);
        ImmutablePerson older = p.withAge(21);
        System.out.println("Original: " + p);
        System.out.println("Copy:     " + older);
    }
}
