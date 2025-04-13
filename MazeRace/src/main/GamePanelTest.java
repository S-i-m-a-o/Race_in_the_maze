package main;

import main.GamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamePanelTest {

    private GamePanel gamePanel;

    @BeforeEach
    public void setUp() {
        gamePanel = new GamePanel();
    }

    @Test
    public void testTileSizeCalculation() {
        int expectedTileSize = 16 * 2;
        assertEquals(expectedTileSize, gamePanel.tileSize, "Tile size should be originalTileSize * scale");
    }

    @Test
    public void testScreenWidthCalculation() {
        int expectedWidth = gamePanel.tileSize * 36;
        assertEquals(expectedWidth, gamePanel.screenWidth, "Screen width should be tileSize * maxScreenColumn");
    }

    @Test
    public void testScreenHeightCalculation() {
        int expectedHeight = gamePanel.tileSize * 23;
        assertEquals(expectedHeight, gamePanel.screenHeight, "Screen height should be tileSize * maxScreenRow");
    }

    @Test
    public void testPreferredSizeIsCorrect() {
        Dimension expected = new Dimension(gamePanel.screenWidth, gamePanel.screenHeight);
        assertEquals(expected, gamePanel.getPreferredSize(), "Preferred size should match calculated screen dimensions");
    }

    @Test
    public void testBackgroundColorIsBlack() {
        Color expectedColor = Color.black;
        assertEquals(expectedColor, gamePanel.getBackground(), "Background color should be black");
    }
}
