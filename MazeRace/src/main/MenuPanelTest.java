package main;

import main.MenuPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Button;
import java.awt.Component;

import static org.junit.jupiter.api.Assertions.*;

public class MenuPanelTest {

    private MenuPanel menuPanel;

    @BeforeEach
    public void setUp() {
        menuPanel = new MenuPanel();
    }

    @Test
    public void testStartButtonExists() {
        Button startButton = findButton("Start Game");
        assertNotNull(startButton);
        assertEquals("Start Game", startButton.getLabel());
    }

    @Test
    public void testStartButtonVisibilityChange() {
        Button startButton = findButton("Start Game");
        assertTrue(startButton.isVisible());

        // Simulate button click
        startButton.getActionListeners()[0].actionPerformed(null);

        // Check if the button is now invisible
        assertFalse(startButton.isVisible());
    }

    @Test
    public void testCloseButtonExists() {
        Button closeButton = findButton("close");
        assertNotNull(closeButton);
        assertEquals("close", closeButton.getLabel());
    }

    private Button findButton(String label) {
        for (Component comp : menuPanel.getComponents()) {
            if (comp instanceof Button && ((Button) comp).getLabel().equals(label)) {
                return (Button) comp;
            }
        }
        return null;
    }
}
