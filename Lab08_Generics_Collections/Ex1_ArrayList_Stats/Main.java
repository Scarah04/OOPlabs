import java.util.*;

// Lab 8 - Exercise 1 (Basic)
public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(4, 9, 1, 7, 3, 12, 8, 5, 10, 2));
        int sum = 0;
        for (int n : nums) sum += n;
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + Collections.max(nums));
        List<Integer> rev = new ArrayList<>(nums);
        Collections.reverse(rev);
        System.out.println("Reversed: " + rev);
    }
}
