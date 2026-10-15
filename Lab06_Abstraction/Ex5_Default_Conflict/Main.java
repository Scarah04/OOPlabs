// Lab 6 - Exercise 5 (Challenge): default method conflict
interface A { default void hello() { System.out.println("Hello from A"); } }
interface B { default void hello() { System.out.println("Hello from B"); } }

class C implements A, B {
    // Both interfaces provide hello(), so the compiler forces us to override it.
    @Override public void hello() {
        A.super.hello();
        B.super.hello();
        System.out.println("Hello from C");
    }
}

public class Main {
    public static void main(String[] args) {
        new C().hello();
        /* RULE: if a class inherits two default methods with the same signature, it must
           override the method itself. It may pick one with InterfaceName.super.method(). */
    }
}
