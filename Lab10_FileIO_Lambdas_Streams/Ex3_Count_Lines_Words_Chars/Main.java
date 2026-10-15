import java.io.IOException;
import java.nio.file.*;
import java.util.*;

// Lab 10 - Exercise 3 (Intermediate): usage: java Main [file]  (creates sample.txt if none given)
public class Main {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get(args.length > 0 ? args[0] : "sample.txt");
        if (args.length == 0) {
            Files.writeString(file, "Hello world\nObject oriented programming\nin Java is fun\n");
        }
        List<String> lines = Files.readAllLines(file);
        int words = 0, chars = 0;
        for (String l : lines) {
            chars += l.length();
            if (!l.isBlank()) words += l.trim().split("\\s+").length;
        }
        System.out.println("File:       " + file);
        System.out.println("Lines:      " + lines.size());
        System.out.println("Words:      " + words);
        System.out.println("Characters: " + chars);
    }
}
