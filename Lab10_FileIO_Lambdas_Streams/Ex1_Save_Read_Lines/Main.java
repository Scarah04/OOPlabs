import java.io.*;
import java.nio.file.*;
import java.util.*;

// Lab 10 - Exercise 1 (Basic): save five lines typed by the user, then read back
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            System.out.print("Line " + i + ": ");
            lines.add(in.hasNextLine() ? in.nextLine() : "(empty)");
        }
        Path file = Paths.get("lines.txt");
        Files.write(file, lines);
        System.out.println("--- Reading back from " + file + " ---");
        for (String l : Files.readAllLines(file)) System.out.println(l);
    }
}
