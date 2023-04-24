package ex1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimal1 {
    public static double roundHundred(BigDecimal nbr) {
        BigDecimal rounded = nbr.setScale(2, RoundingMode.HALF_UP);
        return rounded.doubleValue();
    }

    // Application

    public static void main(String[] args) {
        BigDecimal nbr = new BigDecimal("5.3829");
        double result = roundHundred(nbr);
        System.out.println(result);
    }
}
