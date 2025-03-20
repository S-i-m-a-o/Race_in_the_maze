package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{ //This class inherits the JPanel class

	//SCREEN SETTINGS
	final int originalTileSize = 16; //16*16 tile for character / map tile etc..
	final int scale = 1; //Scales the tiles / sprites *3 so it's not tiny on the screen..
	final int tileSize = originalTileSize * scale; //48*48 pixel tiles
	final int maxScreenColumn = 40; //16 Tiles wide
	final int maxScreenRow = 40; //12 Tiles down
	final int screenWidth = tileSize * maxScreenColumn; //768 pixels
	final int screenHeight = tileSize * maxScreenRow; //576 pixels
	
	Thread gameThread; //Thread for concurrency
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); //Drawing is done in an offscreen painting buffer
	}

	public void startGameThread() {
		gameThread = new Thread(this); //Passing GamePanel to this constructor
		gameThread.start(); //Starts the thread.. Starts the run method
	}

	@Override
	public void run() { //Implemented from thread for concurrency
		
		while(gameThread != null) { //While the game thread exists
			
			//System.out.println("The game loop is running..");
			
			//UPDATE INFORMATION LIKE CHARACTER POS
			update();
			//DRAW THE SCREEN WITH THE UPDATED INFORMATION
			repaint(); //Calling this calls paintComponent method
		}
		
	}
	
	public void update() {
		
	}
	
	public void paintComponent(Graphics g) { //JPanel standard method, graphics is built in too
		super.paintComponent(g); //Calls from JPanel..Subclass
		
		Graphics2D g2 = (Graphics2D)g;//Extends Graphics class for control over geometry, coordinates, colour and text layout
		
		g2.setColor(Color.white);
		g2.fillRect(10, 10, tileSize, tileSize);
		g2.dispose();
		
	}
	
}
