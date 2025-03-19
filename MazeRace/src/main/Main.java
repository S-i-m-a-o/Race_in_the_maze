package main;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[]args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Lets the window properly close when the 'x' is clicked
		window.setResizable(false); //The window cannot be resized
		window.setTitle("Maze Race");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack(); //Causes window to be sized to fit preffered size and layout of its subcomponents
		
		window.setLocationRelativeTo(null); //Window is placed at the centre of the screen
		window.setVisible(true); //Sets visibility to true, so we can actually see the window
		
		
	}

}
