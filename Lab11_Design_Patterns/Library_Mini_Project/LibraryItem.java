public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;

    protected LibraryItem(String id, String title) {
        if (id == null || id.isBlank() || title == null || title.isBlank())
            throw new IllegalArgumentException("id and title must not be empty");
        this.id = id;
        this.title = title;
    }

    public abstract int loanPeriodDays();
    public abstract String getType();

    public String getId()        { return id; }
    public String getTitle()     { return title; }
    public boolean isAvailable() { return available; }
    void setAvailable(boolean available) { this.available = available; }

    @Override
    public void borrow(Member member) throws ItemNotAvailableException {
        if (!available) throw new ItemNotAvailableException(title + " is already on loan");
        available = false;
    }

    @Override
    public void giveBack() { available = true; }

    @Override
    public String toString() {
        return getType() + " " + id + ": " + title + (available ? " [available]" : " [on loan]");
    }
}
