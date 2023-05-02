package Test.ex2;

import main.ex2.JavaKeywordChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JavaKeywordCheckerTest {

    @Test
    void testCotainsJavakeyword() {
        assertTrue(JavaKeywordChecker.containsJavaKeyword("Don't break my heart"));
        assertFalse(JavaKeywordChecker.containsJavaKeyword("I love to breakdance"));
        assertTrue(JavaKeywordChecker.containsJavaKeyword("public static void main(String[] args)"));
        assertFalse(JavaKeywordChecker.containsJavaKeyword("int x = 42;"));
        assertTrue(JavaKeywordChecker.containsJavaKeyword("if (x < 0) { return; }"));
    }
}
