package main;

import java.awt.Button;
import java.awt.CardLayout;

import javax.swing.JFrame;

public class Main {
	//.
	
	static JFrame window = new JFrame();
	static MenuPanel menuPanel = new MenuPanel(); 
	static 	GamePanel gamePanel ;
	public static void main(String[]args) {
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Lets the window properly close when the 'x' is clicked
		window.setResizable(false); //The window cannot be resized
		window.setTitle("Maze Race");
		
			//GamePanel constructor
		
		window.add(menuPanel);
	//	window.add(menuPanel); //gamePanel constructor is added to window
		window.pack(); //Causes window to be sized to fit preffered size and layout of its subcomponents
		
		
		window.setLocationRelativeTo(null); //Window is placed at the centre of the screen
		window.setVisible(true); //Sets visibility to true, so we can actually see the window
	
		
	}
	
	public static void startGame() {

		menuPanel.setVisible(false);

	    
	     gamePanel = new GamePanel(); 
	    window.add(gamePanel);
		gamePanel.startGameThread();
		gamePanel.requestFocus();
		window.pack();
		
	}
	
	public static void startMenu(){
		menuPanel.setVisible(true);
		//gamePanel.setVisible(false);
		
		
		menuPanel.requestFocus();
		window.pack();
		
		
	}
	
	public static void closeMenu(){
		menuPanel.setVisible(false);

	    
	     gamePanel = new GamePanel(); 

		gamePanel.requestFocus();
		window.pack();
		
		
	}
	
	
	
}
