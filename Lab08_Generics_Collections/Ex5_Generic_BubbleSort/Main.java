import java.util.Arrays;

// Lab 8 - Exercise 5 (Challenge)
public class Main {
    static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Integer[] nums = {5, 2, 9, 1, 7};
        String[] words = {"pear", "apple", "mango", "banana"};
        bubbleSort(nums);
        bubbleSort(words);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(words));
        /* int[] will not work: generics only work with reference types (objects). A type
           parameter T cannot be the primitive int, and int[] is not a T[] for any T.
           Use Integer[] (boxing) instead. */
    }
}
