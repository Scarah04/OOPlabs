import java.util.Iterator;

// Lab 9 - Exercise 4 (Intermediate): static nested Node + inner Iterator
class MyLinkedList implements Iterable<String> {
    private static class Node {
        String value; Node next;
        Node(String v) { value = v; }
    }
    private Node head, tail;

    void add(String v) {
        Node n = new Node(v);
        if (head == null) head = tail = n;
        else { tail.next = n; tail = n; }
    }

    // inner (non-static) class: has access to 'head' of the outer object
    private class ListIterator implements Iterator<String> {
        private Node current = head;
        public boolean hasNext() { return current != null; }
        public String next() { String v = current.value; current = current.next; return v; }
    }

    public Iterator<String> iterator() { return new ListIterator(); }
}

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("one"); list.add("two"); list.add("three");
        for (String s : list) System.out.println(s);
    }
}
