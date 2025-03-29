package tile;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.GamePanel;

class TileManagerTest {

    private GamePanel gamePanel;
    private TileManager tileManager;

    @BeforeEach
    void setUp() {
        gamePanel = new GamePanel();
        tileManager = new TileManager(gamePanel);
    }

    @Test
    void testTileImagesLoaded() {
        assertNotNull(tileManager.tile[0]);
        assertNotNull(tileManager.tile[1]);
        assertNotNull(tileManager.tile[2]);
    }

    @Test
    void testMapLoading() {
        int[][] map = tileManager.mapTileNumber;
        assertNotNull(map);
        assertTrue(map.length > 0);
        assertTrue(map[0].length > 0);
    }
}
