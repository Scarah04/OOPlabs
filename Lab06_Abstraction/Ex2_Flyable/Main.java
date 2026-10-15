// Lab 6 - Exercise 2 (Basic): interface shared by unrelated classes
interface Flyable { void fly(); }
class Bird implements Flyable {
    public void fly() { System.out.println("Bird flaps its wings and flies"); }
}
class Aeroplane implements Flyable {
    public void fly() { System.out.println("Aeroplane uses engines and flies"); }
}

public class Main {
    public static void main(String[] args) {
        Flyable[] things = { new Bird(), new Aeroplane() };
        for (Flyable f : things) f.fly();
    }
}
