package main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

public class MenuPanel extends JPanel implements Runnable {

    final int originalTileSize = 16;
    final int scale = 2;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenColumn = 36;
    public final int maxScreenRow = 23;
    public final int screenWidth = tileSize * maxScreenColumn;
    public final int screenHeight = tileSize * maxScreenRow;

    public MenuPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(null); // Absolute positioning

        Button startButton = new Button("Start Game");
        startButton.setBounds(screenWidth / 2 - 50, screenHeight / 2 - 60, 100, 40); // Centered

        Button closeButton = new Button("Close");
        closeButton.setBounds(screenWidth / 2 - 50, screenHeight / 2, 100, 40); // Under the start button

        // Hover effects
        setupButtonHoverEffect(startButton);
        setupButtonHoverEffect(closeButton);

        this.add(startButton);
        this.add(closeButton);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.startGame();
                startButton.setVisible(false);
            }
        });

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
                button.setBackground(Color.darkGray);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(originalColor);
            }
        });
    }

    @Override
    public void run() {
        // Currently empty, not needed yet
    }
}
