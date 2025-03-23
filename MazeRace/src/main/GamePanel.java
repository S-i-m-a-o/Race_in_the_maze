package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable{ //This class inherits the JPanel class

	//SCREEN SETTINGS
	final int originalTileSize = 16; //16*16 tile for character / map tile etc..
	final int scale = 2; //Scales the tiles / sprites *3 so it's not tiny on the screen..
	public final int tileSize = originalTileSize * scale; //48*48 pixel tiles
	final int maxScreenColumn = 25; //16 Tiles wide
	final int maxScreenRow = 25; //12 Tiles down
	final int screenWidth = tileSize * maxScreenColumn; //768 pixels
	final int screenHeight = tileSize * maxScreenRow; //576 pixels
	
	int framesPerSecond = 60; //Maximum FPS I want to use
	
	KeyHandler keyH = new KeyHandler(); //Instantiating KeyHandler class
	Thread gameThread; //Thread for concurrency
	Player player = new Player(this,keyH); //Instantiating GamePanel and KeyHandler
	Player player2 = new Player(this,keyH);
	
	//Set players default position..
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); //Drawing is done in an offscreen painting buffer
		this.addKeyListener(keyH); //Adds KeyHandler to GamePanel
		this.setFocusable(true); //GamePanel can be focused to receive key inputs
	}

	public void startGameThread() {
		gameThread = new Thread(this); //Passing GamePanel to this constructor
		gameThread.start(); //Starts the thread.. Starts the run method
	}

	@Override
	public void run() { //Implemented from thread for concurrency
		
		double drawInterval = 1000000000/framesPerSecond;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) { //While the game thread exists
			
			currentTime = System.nanoTime(); //Gets the current system time
			delta += (currentTime - lastTime) / drawInterval; //Delta increased by the current time - the last time it was checked
			timer += (currentTime - lastTime); //Timer increased by the current time - the last time it was checked
			lastTime = currentTime; //Sets last time to current time
			
			if(delta >= 1) { //If the delta is greater than 1, we update and repaint
			update();
			repaint(); //Calling this calls paintComponent method
			delta--; //Delta is set back to 0
			drawCount++; //Drawcount is increased
			}
			
			if(timer >= 1000000000) {
				System.out.println("Frames Per Second: " + drawCount); //Displays FPS
				drawCount = 0; //Resets drawCount
				timer = 0; //Resets Timer
			}
			
			}
		
	}
	
	public void update() { //Update method
		player.update();
	}
	
	public void paintComponent(Graphics g) { //JPanel standard method, graphics is built in too
		super.paintComponent(g); //Calls from JPanel..Subclass
		Graphics2D g2 = (Graphics2D)g;
		player.draw(g2);
		g2.dispose();
		
	}
	
}
