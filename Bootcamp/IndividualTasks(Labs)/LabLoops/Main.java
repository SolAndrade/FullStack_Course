public class Main {
    // 1. Write a method in Java to get the difference between
    // the largest and smallest values in an array of integers.
    // The length of the array must be 1 and above.
    public static int getDiff(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max - min;
    }

    // Application
    // int[] arr = {6, 1, 2, 7, 4, 5, 9};
    // int diff = getDiff(arr);
    // System.out.println("The difference is: " + diff);

    // 2. Write a method in Java to find the smallest and
    // second smallest elements of a given array and print
    // it in the console.

    public static void findSmallNbr(int [] array) {
        int min = array[0];
        int secMin = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                secMin = min;
                min = array[i];
            } else if (array[i] < secMin && array[i] != min) {
                secMin = array[i];
            }
        }
        System.out.println("The smallest element is: " + min);
        System.out.println("The second smallest element is: " + secMin);
    }

    // Application
    // int[] arr = {6, 1, 2, 7, 4, 5, 9};
    // findSmaillNbr(arr);

    // 3. Write a method in Java that resolves this mathematical
    // expression where x and y are two variables pre-set in
    // your code.

    public static double mathExpression(double x, double y) {
        double result = Math.pow(x, 2) + Math.pow(((4 * y) / 5) - x, 2);
        return result;
    }

    // Application
    // double x = 2;
    // double y = 3;
    // double result = mathExpression(x, y);
    // System.out.println(result);
}
