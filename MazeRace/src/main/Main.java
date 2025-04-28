package main;

import javax.swing.JFrame;

public class Main {
    
    static JFrame window = new JFrame();
    static MenuPanel menuPanel = new MenuPanel();
    static GamePanel gamePanel;

    public static void main(String[] args) {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Proper window close
        window.setResizable(false); // Window cannot be resized
        window.setTitle("Maze Race");

        // Initialize and display menu
        window.add(menuPanel);
        window.pack();
        window.setLocationRelativeTo(null); // Center the window
        window.setVisible(true); // Make window visible
    }

    public static void startGame() {
        menuPanel.setVisible(false);  // Hide menu
        gamePanel = new GamePanel();  // Create game panel
        window.add(gamePanel);  // Add game panel to the window
        gamePanel.startGameThread();  // Start game thread
        gamePanel.requestFocus();  // Give game panel focus
        window.pack();
    }

    public static void startMenu() {
        menuPanel.setVisible(true);  // Show the main menu
        if (gamePanel != null) {
            gamePanel.setVisible(false);  // Hide game panel
        }
        window.add(menuPanel);  // Add menu panel to window
        window.pack();
    }
}
