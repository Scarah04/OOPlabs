// Lab 7 - Exercise 2 (Basic): ArrayIndexOutOfBoundsException
public class Main {
    static int getElement(int[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index " + index + " is invalid (valid: 0.." + (arr.length - 1) + ")");
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] data = {10, 20, 30};
        System.out.println(getElement(data, 1));
        System.out.println(getElement(data, 5));
    }
}
