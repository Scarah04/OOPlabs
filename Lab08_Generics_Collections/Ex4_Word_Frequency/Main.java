import java.util.*;

// Lab 8 - Exercise 4 (Intermediate): word frequency sorted descending
public class Main {
    public static void main(String[] args) {
        String text = "the quick brown fox jumps over the lazy dog the fox barks and the dog runs";
        Map<String, Integer> freq = new HashMap<>();
        for (String w : text.toLowerCase().split("\\W+")) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort((a, b) -> {
            int c = b.getValue() - a.getValue();
            return c != 0 ? c : a.getKey().compareTo(b.getKey());
        });
        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}
