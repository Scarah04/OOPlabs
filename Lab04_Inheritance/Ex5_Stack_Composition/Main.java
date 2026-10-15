import java.util.ArrayList;

// Lab 4 - Exercise 5 (Challenge): composition instead of inheritance
/* A "Stack extends ArrayList" would wrongly expose add(index, x), remove(index), get(i)...
   so callers could break the last-in-first-out rule. Using composition we expose only
   push / pop / peek / isEmpty. */
class Stack {
    private final ArrayList<Integer> items = new ArrayList<>();
    void push(int x) { items.add(x); }
    int pop()  { return items.remove(items.size() - 1); }
    int peek() { return items.get(items.size() - 1); }
    boolean isEmpty() { return items.isEmpty(); }
}

public class Main {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1); s.push(2); s.push(3);
        System.out.println("peek: " + s.peek());
        while (!s.isEmpty()) System.out.println("pop: " + s.pop());
    }
}
