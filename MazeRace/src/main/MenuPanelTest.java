package main;

import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.Color;

public class MenuPanelTest {

    @Test
    public void testDefaultBackgroundColor() {
        MenuPanel menu1 = new MenuPanel();
        MenuPanel menu2 = new MenuPanel();

        // Check if default background color is the same (black)
        assertEquals(menu1.getBackground(), menu2.getBackground());
        assertEquals(Color.black, menu1.getBackground());
    }

    @Test
    public void testScreenSize() {
        MenuPanel menu = new MenuPanel();

        int expectedWidth = 16 * 2 * 36; // originalTileSize * scale * maxScreenColumn
        int expectedHeight = 16 * 2 * 23; // originalTileSize * scale * maxScreenRow

        // Use getPreferredSize() instead of getWidth() and getHeight()
        assertEquals(expectedWidth, menu.getPreferredSize().width);
        assertEquals(expectedHeight, menu.getPreferredSize().height);
    }


    @Test
    public void testBackgroundColorChange() {
        MenuPanel menu = new MenuPanel();

        // Simulate changing the background
        Color newColor = Color.red;
        menu.setBackground(newColor);

        assertEquals(newColor, menu.getBackground());
    }
}

