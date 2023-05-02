import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static int[] balancer(int[] numList, int sum) {


        while (sumArray(numList) < sum) {

            int lowerIndex = 0;
            int lowerValue = Integer.MAX_VALUE;

            for(int i=0; i<numList.length; i++) {
                if (numList[i] < lowerValue) {
                    lowerIndex = i;
                    lowerValue = numList[i];
                }
            }
            numList[lowerIndex]++;

        }

        return numList;
    }

    public static int sumArray(int[] array) {
        int sum = 0;
        for (int item: array) {
            sum+=item;
        }
        return sum;
    }

}
