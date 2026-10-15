import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

// Lab 10 - Exercise 5 (Challenge): load learners.csv, group by band, one report per band
record Learner(String name, int marks) {
    String band() { return marks >= 75 ? "A" : marks >= 60 ? "B" : "C"; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Path csv = Paths.get("learners.csv");
        if (!Files.exists(csv)) {      // create sample data so the program runs out of the box
            Files.write(csv, List.of("name,marks", "Ann,82", "Ben,64", "Cat,51", "Dan,90", "Eve,70", "Finn,40"));
        }
        List<Learner> learners = Files.readAllLines(csv).stream()
            .skip(1)
            .map(line -> line.split(","))
            .map(p -> new Learner(p[0].trim(), Integer.parseInt(p[1].trim())))
            .collect(Collectors.toList());

        Map<String, List<Learner>> byBand = learners.stream()
            .collect(Collectors.groupingBy(Learner::band, TreeMap::new, Collectors.toList()));

        for (Map.Entry<String, List<Learner>> e : byBand.entrySet()) {
            List<String> report = new ArrayList<>();
            report.add("Band " + e.getKey() + " report (" + e.getValue().size() + " learners)");
            for (Learner l : e.getValue()) report.add(l.name() + " - " + l.marks());
            Path out = Paths.get("report_band_" + e.getKey() + ".txt");
            Files.write(out, report);
            System.out.println("Wrote " + out);
        }
    }
}
