package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

    final int originalTileSize = 16; // 16*16 tile for character / map tile etc..
    final int scale = 2; // Scales the tiles / sprites *3 so it's not tiny on the screen..
    public final int tileSize = originalTileSize * scale; // 48*48 pixel tiles
    public final int maxScreenColumn = 36; // 16 Tiles wide
    public final int maxScreenRow = 23; // 12 Tiles down
    public final int screenWidth = tileSize * maxScreenColumn; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    public MenuPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(null); // Absolute positioning

        // ==== RESUME BUTTON ====
        Button resumeButton = new Button("Resume Game");
        resumeButton.setBounds(screenWidth / 2 - 50, screenHeight / 2 - 120, 100, 40); // Above Start Button
        setupButtonHoverEffect(resumeButton);
        this.add(resumeButton);

        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.resumeGame();
            }
        });

        // ==== START BUTTON ====
        Button startButton = new Button("Start Game");
        startButton.setBounds(screenWidth / 2 - 50, screenHeight / 2 - 60, 100, 40); // Centered
        setupButtonHoverEffect(startButton);
        this.add(startButton);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.startGame();
                startButton.setVisible(false); // Optional: Hide start button after first click
            }
        });

        // ==== CLOSE BUTTON ====
        Button closeButton = new Button("Close");
        closeButton.setBounds(screenWidth / 2 - 50, screenHeight / 2, 100, 40); // Below Start Button
        setupButtonHoverEffect(closeButton);
        this.add(closeButton);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.closeMenu();
            }
        });
    }

    private void setupButtonHoverEffect(Button button) {
        button.addMouseListener(new MouseAdapter() {
            Color originalColor = button.getBackground();

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.darkGray); // Hover effect
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(originalColor); // Restore original color
            }
        });
    }
}
