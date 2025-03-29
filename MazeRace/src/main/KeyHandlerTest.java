package main;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.KeyEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KeyHandlerTest {

    private KeyHandler keyHandler;

    @BeforeEach
    void setUp() {
        keyHandler = new KeyHandler();
    }

    @Test
    void testKeyPressed() {
        keyHandler.keyPressed(new KeyEvent(new GamePanel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W'));
        assertTrue(keyHandler.wPressed);
    }

    @Test
    void testKeyReleased() {
        keyHandler.keyPressed(new KeyEvent(new GamePanel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'A'));
        keyHandler.keyReleased(new KeyEvent(new GamePanel(), KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'A'));
        assertFalse(keyHandler.aPressed);
    }
}
