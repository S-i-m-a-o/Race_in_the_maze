package main;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16;
    final int scale = 2;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenColumn = 36;
    public final int maxScreenRow = 23;
    public final int screenWidth = tileSize * maxScreenColumn;
    public final int screenHeight = tileSize * maxScreenRow;

    int framesPerSecond = 60;
    boolean gameOver = false;  // Game-over flag
    boolean showWinMessage = false;  // Flag to show win message
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    Player player = new Player(this, keyH, 32, 32, 3);
    Player player2 = new Player(this, keyH, 1088, 671, 3);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / framesPerSecond;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("Frames Per Second: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        if (!gameOver) {
            player.updatePlayerOne();
            player2.updatePlayerTwo();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileM.draw(g2);
        player.draw(g2);
        player2.draw(g2);

        // Show win message and buttons if the game is over
        if (showWinMessage) {
            g2.setColor(Color.WHITE);
            g2.drawString("You Win!", screenWidth / 2 - 50, screenHeight / 2 - 30);  // Win message

            // After displaying the win message, go to the main menu immediately
            try {
                Thread.sleep(2000);  // Wait for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            goToMenu();  // Automatically go back to the main menu
        }

        g2.dispose();
    }

    // Go to main menu
    public void goToMenu() {
        Main.startMenu();  // Go back to the main menu
    }
}
