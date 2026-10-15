import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Library lib = new Library();
        Path dataDir = Paths.get("library_data");
        lib.load(dataDir);
        Scanner in = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add item   2. Register member   3. Borrow   4. Return");
            System.out.println("5. List overdue   6. Search by title   7. List all   0. Save and exit");
            System.out.print("Choice: ");
            if (!in.hasNextLine()) break;
            String choice = in.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Type (book/dvd): ");  String type = in.nextLine().trim();
                        System.out.print("Id: ");               String id = in.nextLine().trim();
                        System.out.print("Title: ");            String title = in.nextLine().trim();
                        lib.addItem(type.equalsIgnoreCase("dvd") ? new Dvd(id, title) : new Book(id, title));
                        System.out.println("Item added.");
                    }
                    case "2" -> {
                        System.out.print("Member id: ");  String id = in.nextLine().trim();
                        System.out.print("Name: ");       String name = in.nextLine().trim();
                        lib.addMember(new Member(id, name));
                        System.out.println("Member registered.");
                    }
                    case "3" -> {
                        System.out.print("Member id: ");  String m = in.nextLine().trim();
                        System.out.print("Item id: ");    String i = in.nextLine().trim();
                        lib.borrow(m, i, LocalDate.now());
                        System.out.println("Borrowed.");
                    }
                    case "4" -> {
                        System.out.print("Item id: ");  lib.giveBack(in.nextLine().trim());
                        System.out.println("Returned.");
                    }
                    case "5" -> {
                        var list = lib.overdue(LocalDate.now());
                        if (list.isEmpty()) System.out.println("No overdue items.");
                        list.forEach(System.out::println);
                    }
                    case "6" -> {
                        System.out.print("Search text: ");
                        lib.searchByTitle(in.nextLine()).forEach(System.out::println);
                    }
                    case "7" -> {
                        lib.getItems().forEach(System.out::println);
                        lib.getMembers().forEach(System.out::println);
                    }
                    case "0" -> running = false;
                    default -> System.out.println("Invalid choice.");
                }
            } catch (ItemNotAvailableException | MemberLimitExceededException e) {
                System.out.println("Cannot borrow: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        lib.save(dataDir);
        System.out.println("Data saved to " + dataDir + ". Goodbye.");
    }
}
