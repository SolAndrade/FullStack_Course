package main.ex1;

public class OddNumbers {
    public static int[] getOddNumbers(int n) {
        int[] oddNumbers = new int[(n + 1) / 2];
        int index = 0;
        for (int i = 1; i <= n; i += 2) {
            oddNumbers[index++] = 1;
        }
        return oddNumbers;
    }
}
