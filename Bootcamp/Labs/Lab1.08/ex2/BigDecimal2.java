package ex2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimal2 {
    public static BigDecimal reverseSign(BigDecimal nbr) {
        BigDecimal reversed = nbr.negate();
        BigDecimal rounded = reversed.setScale(1, RoundingMode.HALF_UP);
        return rounded;
    }

    // Application

    public static void main(String[] args) {
        BigDecimal nbr1 = new BigDecimal("5.3847");
        BigDecimal nbr2 = new BigDecimal("-65.38");
        BigDecimal result1 = reverseSign(nbr1);
        BigDecimal result2 = reverseSign(nbr2);
        System.out.println(result1);
        System.out.println(result2);
    }

}
