// Lab 7 - Exercise 5 (Challenge): return inside try, print inside finally
public class Main {
    static int test() {
        try {
            System.out.println("in try");
            return 1;
        } finally {
            System.out.println("in finally");   // runs BEFORE the method actually returns
        }
    }
    public static void main(String[] args) {
        int r = test();
        System.out.println("returned " + r);
        // Output: in try / in finally / returned 1
        // finally always runs when the try block is left (even via return) so cleanup code
        // such as closing files is guaranteed.
    }
}
