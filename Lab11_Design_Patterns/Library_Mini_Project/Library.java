import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class Library {
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final List<Loan> loans = new ArrayList<>();

    public void addItem(LibraryItem item)   { items.put(item.getId(), item); }
    public void addMember(Member member)    { members.put(member.getId(), member); }

    public void borrow(String memberId, String itemId, LocalDate date)
            throws ItemNotAvailableException, MemberLimitExceededException {
        Member m = members.get(memberId);
        LibraryItem i = items.get(itemId);
        if (m == null) throw new IllegalArgumentException("No such member: " + memberId);
        if (i == null) throw new IllegalArgumentException("No such item: " + itemId);
        if (m.getLoans().size() >= Member.MAX_LOANS)
            throw new MemberLimitExceededException(m.getName() + " already has " + Member.MAX_LOANS + " loans");
        i.borrow(m);                        // throws ItemNotAvailableException if on loan
        Loan loan = new Loan(m, i, date);
        m.addLoan(loan);
        loans.add(loan);
    }

    public void giveBack(String itemId) {
        for (Loan l : loans) {
            if (l.getItem().getId().equals(itemId)) {
                l.getItem().giveBack();
                l.getMember().removeLoan(l);
                loans.remove(l);
                return;
            }
        }
        throw new IllegalArgumentException("Item " + itemId + " is not on loan");
    }

    public List<Loan> overdue(LocalDate today) {
        return loans.stream().filter(l -> l.isOverdue(today)).toList();
    }

    public List<LibraryItem> searchByTitle(String text) {
        return items.values().stream()
            .filter(i -> i.getTitle().toLowerCase().contains(text.toLowerCase()))
            .sorted(Comparator.comparing(LibraryItem::getTitle))
            .toList();
    }

    public Collection<LibraryItem> getItems()   { return items.values(); }
    public Collection<Member> getMembers()      { return members.values(); }
    public List<Loan> getLoans()                { return loans; }

    // ---------- CSV persistence ----------
    public void save(Path dir) throws IOException {
        Files.createDirectories(dir);
        List<String> itemLines = new ArrayList<>();
        for (LibraryItem i : items.values())
            itemLines.add(i.getType() + "," + i.getId() + "," + i.getTitle());
        Files.write(dir.resolve("items.csv"), itemLines);

        List<String> memberLines = new ArrayList<>();
        for (Member m : members.values()) memberLines.add(m.getId() + "," + m.getName());
        Files.write(dir.resolve("members.csv"), memberLines);

        List<String> loanLines = new ArrayList<>();
        for (Loan l : loans)
            loanLines.add(l.getMember().getId() + "," + l.getItem().getId() + "," + l.getBorrowedOn());
        Files.write(dir.resolve("loans.csv"), loanLines);
    }

    public void load(Path dir) throws IOException {
        Path fi = dir.resolve("items.csv"), fm = dir.resolve("members.csv"), fl = dir.resolve("loans.csv");
        if (!Files.exists(fi)) return;
        for (String line : Files.readAllLines(fi)) {
            String[] p = line.split(",", 3);
            addItem(p[0].equals("DVD") ? new Dvd(p[1], p[2]) : new Book(p[1], p[2]));
        }
        for (String line : Files.readAllLines(fm)) {
            String[] p = line.split(",", 2);
            addMember(new Member(p[0], p[1]));
        }
        for (String line : Files.readAllLines(fl)) {
            String[] p = line.split(",");
            try { borrow(p[0], p[1], LocalDate.parse(p[2])); }
            catch (Exception e) { System.out.println("Skipped bad loan record: " + line); }
        }
    }
}
