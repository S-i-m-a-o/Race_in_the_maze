package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class MenuPanel extends JPanel implements Runnable{

	
	final int originalTileSize = 16; //16*16 tile for character / map tile etc..
	final int scale = 2; //Scales the tiles / sprites *3 so it's not tiny on the screen..
	public final int tileSize = originalTileSize * scale; //48*48 pixel tiles
	public final int maxScreenColumn = 36; //16 Tiles wide
	public final int maxScreenRow = 23; //12 Tiles down
	public final int screenWidth = tileSize * maxScreenColumn; //768 pixels
	public final int screenHeight = tileSize * maxScreenRow; //576 pixels	
	
	public MenuPanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); //Drawing is done in an offscreen painting buffer
		this.setFocusable(true); //GamePanel can be focused to receive key inputs
		Button startButton = new Button("Start Game");
	

		//startButton.setVisible(false);
		this.add(startButton);

		startButton.addActionListener(new ActionListener() {    
		    public void actionPerformed (ActionEvent e) {    
		    
		           Main.startGame();
		           startButton.setVisible(false);
		           
		           
		    	
		        }    
		    });  
	Button closeButton = new Button("close");

		
		this.add(closeButton);
		closeButton.addActionListener(new ActionListener() {    
		    public void actionPerformed (ActionEvent e) {    
		    
		           Main.closeMenu();
		    	
		        }    
		    }); 
/*Button fullScreenButton = new Button("Full Screen");

		
		this.add(fullScreenButton);
		fullScreenButton.addActionListener(new ActionListener() {    
		    public void actionPerformed (ActionEvent e) {    
		    
		    	
		    	 setSize(1650,1080);
		    	 Main.closeMenu();
		    	
		    	
		        }    
		    });
	
	*/
	}
	/*public static void setStartGameInviseble() {
		Button startButton= new Button("Start Game");
		startButton.setVisible(false);
	}
	*/


		
	@Override
	public void run() {
		
	

		
		
	} 
	


}
