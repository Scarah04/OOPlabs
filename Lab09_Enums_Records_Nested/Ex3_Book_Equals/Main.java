import java.util.*;

// Lab 9 - Exercise 3 (Intermediate): equals/hashCode by ISBN
class Book {
    private final String isbn;
    private final String title;
    Book(String isbn, String title) { this.isbn = isbn; this.title = title; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        return isbn.equals(((Book) o).isbn);
    }
    @Override public int hashCode() { return isbn.hashCode(); }
    @Override public String toString() { return title + " [" + isbn + "]"; }
}

public class Main {
    public static void main(String[] args) {
        Set<Book> books = new HashSet<>();
        System.out.println(books.add(new Book("111", "Java Basics")));        // true
        System.out.println(books.add(new Book("111", "Java Basics 2nd")));   // false - duplicate ISBN
        System.out.println(books.add(new Book("222", "OOP in Java")));       // true
        System.out.println("Size: " + books.size() + " -> " + books);
    }
}
