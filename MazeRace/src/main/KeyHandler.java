package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{ //Listener interface for receiving keyboard events

	public boolean wPressed, aPressed, sPressed, dPressed, upPressed, downPressed, leftPressed, rightPressed; //Boolean to verify if a key is pressed
	
	@Override
	public void keyTyped(KeyEvent e) {
		//Not used
	}

	@Override
	public void keyPressed(KeyEvent e) { //Method to determine is a key is pressed
		
		int code = e.getKeyCode(); //Returns an integer associated to a keyboard key
		
		if(code == KeyEvent.VK_W) { //If W is pressed, wPressed = true.. This whole block below does the same for different key..
			wPressed = true;
		}
		if(code == KeyEvent.VK_A) {
			aPressed = true;
		}
		if(code == KeyEvent.VK_S) {
			sPressed = true;
		}
		if(code == KeyEvent.VK_D) {
			dPressed = true;
		}
		if(code == KeyEvent.VK_UP) {
			upPressed = true;
		}
		if(code == KeyEvent.VK_DOWN) {
			downPressed = true;
		}
		if(code == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		if(code == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) { //Method to determine if a pressed key is released
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) { //If the W key is already pressed, then released, wPressed is false.. This applies for the entire block below depending on the key pressed
			wPressed = false;
		}
		if(code == KeyEvent.VK_A) {
			aPressed = false;
		}
		if(code == KeyEvent.VK_S) {
			sPressed = false;
		}
		if(code == KeyEvent.VK_D) {
			dPressed = false;
		}
		if(code == KeyEvent.VK_UP) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_DOWN) {
			downPressed = false;
		}
		if(code == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if(code == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
	}

}
