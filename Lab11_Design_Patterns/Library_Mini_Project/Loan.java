import java.time.LocalDate;

public class Loan {
    private final Member member;
    private final LibraryItem item;
    private final LocalDate borrowedOn;
    private final LocalDate dueOn;

    public Loan(Member member, LibraryItem item, LocalDate borrowedOn) {
        this.member = member;
        this.item = item;
        this.borrowedOn = borrowedOn;
        this.dueOn = borrowedOn.plusDays(item.loanPeriodDays());
    }

    public Member getMember()       { return member; }
    public LibraryItem getItem()    { return item; }
    public LocalDate getBorrowedOn() { return borrowedOn; }
    public LocalDate getDueOn()     { return dueOn; }
    public boolean isOverdue(LocalDate today) { return today.isAfter(dueOn); }

    @Override
    public String toString() {
        return item.getTitle() + " borrowed by " + member.getName() + " on " + borrowedOn + ", due " + dueOn;
    }
}
