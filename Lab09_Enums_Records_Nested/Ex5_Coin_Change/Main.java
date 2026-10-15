import java.util.*;

// Lab 9 - Exercise 5 (Challenge): enum with fields and greedy coin change
enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);
    private final int value;
    Coin(int value) { this.value = value; }
    int getValue() { return value; }

    static Map<Coin, Integer> fewestCoins(int amount) {
        Map<Coin, Integer> result = new LinkedHashMap<>();
        Coin[] all = values();
        for (int i = all.length - 1; i >= 0; i--) {      // largest coin first
            int count = amount / all[i].value;
            if (count > 0) { result.put(all[i], count); amount %= all[i].value; }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] amounts = {41, 99, 5, 30};
        for (int a : amounts) System.out.println(a + " cents -> " + Coin.fewestCoins(a));
    }
}
