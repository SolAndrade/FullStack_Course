package Test.ex1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.ex1.OddNumbers;

public class OddNumbersTest {

    @Test
    void testGetOddNumbers() {
        assertArrayEquals(new int[] {}, OddNumbers.getOddNumbers(0));
        assertArrayEquals(new int[] { 1 }, OddNumbers.getOddNumbers(1));
        assertArrayEquals(new int[] { 1, 3 }, OddNumbers.getOddNumbers(3));
        assertArrayEquals(new int[] { 1, 3, 5, 7 }, OddNumbers.getOddNumbers(7));
        assertArrayEquals(new int[] { 1, 3, 5, 7, 9 }, OddNumbers.getOddNumbers(9));
    }
}
