// Lab 9 - Exercise 1 (Basic)
enum Level { LOW, MEDIUM, HIGH }

public class Main {
    static void advice(Level l) {
        switch (l) {
            case LOW:    System.out.println("LOW: relax, nothing to do."); break;
            case MEDIUM: System.out.println("MEDIUM: keep an eye on it."); break;
            case HIGH:   System.out.println("HIGH: act immediately!"); break;
        }
    }
    public static void main(String[] args) {
        for (Level l : Level.values()) advice(l);
    }
}
