// Lab 2 - Exercise 4 (Intermediate): static and instance initialiser blocks
class Demo {
    static { System.out.println("static block 1"); }
    { System.out.println("instance block 1"); }
    Demo() { System.out.println("constructor"); }
    static { System.out.println("static block 2"); }
    { System.out.println("instance block 2"); }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("main starts");
        new Demo();
        System.out.println("--- second object ---");
        new Demo();
        /* Predicted output: "main starts", then (when Demo is first used) static block 1,
           static block 2 (once only, in order), then for each object: instance block 1,
           instance block 2, constructor. */
    }
}
