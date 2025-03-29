package entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.GamePanel;
import main.KeyHandler;

class PlayerTest {

    private GamePanel gamePanel;
    private KeyHandler keyHandler;
    private Player player;

    @BeforeEach
    void setUp() {
        gamePanel = new GamePanel();
        keyHandler = new KeyHandler();
        player = new Player(gamePanel, keyHandler, 50, 50, 3);
    }

    @Test
    void testMoveUp() {
        keyHandler.wPressed = true;
        player.updatePlayerOne();
        assertEquals(47, player.y); // Moves up (-3)
    }

    @Test
    void testMoveDown() {
        keyHandler.sPressed = true;
        player.updatePlayerOne();
        assertEquals(53, player.y); // Moves down (+3)
    }

    @Test
    void testMoveLeft() {
        keyHandler.aPressed = true;
        player.updatePlayerOne();
        assertEquals(47, player.x); // Moves left (-3)
    }

    @Test
    void testMoveRight() {
        keyHandler.dPressed = true;
        player.updatePlayerOne();
        assertEquals(53, player.x); // Moves right (+3)
    }
}
