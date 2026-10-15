import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {
    public static final int MAX_LOANS = 3;
    private final String id;
    private final String name;
    private final List<Loan> loans = new ArrayList<>();

    public Member(String id, String name) {
        if (id == null || id.isBlank() || name == null || name.isBlank())
            throw new IllegalArgumentException("id and name must not be empty");
        this.id = id;
        this.name = name;
    }

    public String getId()   { return id; }
    public String getName() { return name; }
    public List<Loan> getLoans() { return Collections.unmodifiableList(loans); }

    void addLoan(Loan loan) throws MemberLimitExceededException {
        if (loans.size() >= MAX_LOANS)
            throw new MemberLimitExceededException(name + " already has " + MAX_LOANS + " loans");
        loans.add(loan);
    }
    void removeLoan(Loan loan) { loans.remove(loan); }

    @Override
    public String toString() { return "Member " + id + ": " + name + " (" + loans.size() + " loans)"; }
}
