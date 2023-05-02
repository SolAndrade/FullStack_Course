package Test.ex345;

import main.ex345.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    void testDecrementLives() {
        Player player = new Player("John", 100, 10, 3);
        player.decrementLives();
        assertEquals(2, player.getLives());
        assertEquals(100, player.getHealth());
    }

    @Test
    void testAttack() {
        Player player1 = new Player("John", 100, 15, 3);
        Player player2 = new Player("Mary", 100, 10, 3);

        player1.attack(player2);

        assertEquals(85, player2.getHealth());
    }
}
