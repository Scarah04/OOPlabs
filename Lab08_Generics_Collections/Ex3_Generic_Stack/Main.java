import java.util.*;

// Lab 8 - Exercise 3 (Intermediate)
class Stack<T> {
    private final List<T> items = new ArrayList<>();
    void push(T item) { items.add(item); }
    T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return items.remove(items.size() - 1);
    }
    T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return items.get(items.size() - 1);
    }
    boolean isEmpty() { return items.isEmpty(); }
}

public class Main {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("a"); s.push("b"); s.push("c");
        System.out.println("peek: " + s.peek());
        while (!s.isEmpty()) System.out.println("pop: " + s.pop());
        Stack<Integer> n = new Stack<>();
        n.push(10); n.push(20);
        System.out.println("pop: " + n.pop());
    }
}
