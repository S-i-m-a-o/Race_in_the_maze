package entity;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyH;

	public Player(GamePanel gp, KeyHandler keyH, int xpos, int ypos, int speedPlayer) {
		this.gp = gp;
		this.keyH = keyH;
		this.worldX = xpos;
		this.worldY = ypos;
		this.speed = speedPlayer;
		// setDefaultValues();
		this.direction = "down";
		solidArea =new Rectangle();
		solidArea.x = 8;
		solidArea.y = 12;
		solidArea.height = 18;
		solidArea.width = 17;
		getPlayerImage();
	}

	/*
	 * public void setDefaultValues() { x = 100; y = 100; speed = 2; direction =
	 * "down"; }
	 */
	public void getPlayerImage() {

		try {

			up1 = ImageIO.read(getClass().getResource("/player/WalkUp1.png"));
			up2 = ImageIO.read(getClass().getResource("/player/WalkUp2.png"));
			down1 = ImageIO.read(getClass().getResource("/player/WalkDown1.png"));
			down2 = ImageIO.read(getClass().getResource("/player/WalkDown2.png"));
			left1 = ImageIO.read(getClass().getResource("/player/WalkLeft1.png"));
			left2 = ImageIO.read(getClass().getResource("/player/WalkLeft2.png"));
			right1 = ImageIO.read(getClass().getResource("/player/WalkRight1.png"));
			right2 = ImageIO.read(getClass().getResource("/player/WalkRight2.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updatePlayerOne() {

		if (keyH.wPressed == true || keyH.aPressed == true || keyH.sPressed == true || keyH.dPressed == true) {

			if (keyH.wPressed == true) { // This if block controls the player character..
				direction = "up";
			} else if (keyH.sPressed == true) {
				direction = "down";
			} else if (keyH.aPressed == true) {
				direction = "left";
			} else if (keyH.dPressed == true) {
				direction = "right";
			}
			
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			if(collisionOn == false) {
				switch(direction) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
				}
			}
			
			spriteCounter++;
			if (spriteCounter > 12) {
				if (spriteNumber == 1) {
					spriteNumber = 2;
				} else if (spriteNumber == 2) {
					spriteNumber = 1;
				}
				spriteCounter = 0;
			}
		}
	}

	public void updatePlayerTwo() {
		if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
				|| keyH.rightPressed == true) {
			if (keyH.upPressed == true) { // This if block controls the player character too.. Need to figure out how to
											// make two players..
				direction = "up";
			} else if (keyH.downPressed == true) {
				direction = "down";
			} else if (keyH.leftPressed == true) {
				direction = "left";
			} else if (keyH.rightPressed == true) {
				direction = "right";
			}
			
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			if(collisionOn == false) {
				switch(direction) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
				}
			}
			
			spriteCounter++;
			if (spriteCounter > 12) {
				if (spriteNumber == 1) {
					spriteNumber = 2;
				} else if (spriteNumber == 2) {
					spriteNumber = 1;
				}
				spriteCounter = 0;
			}
		}
	}

	public void draw(Graphics2D g2) {
		// g2.setColor(Color.white);
		// g2.fillRect(x, y, gp.tileSize, gp.tileSize);

		BufferedImage image = null;

		switch (direction) {
		case "up":
			if (spriteNumber == 1) {
				image = up1;
			}
			if (spriteNumber == 2) {
				image = up2;
			}
			break;
		case "down":
			if (spriteNumber == 1) {
				image = down1;
			}
			if (spriteNumber == 2) {
				image = down2;
			}
			break;
		case "left":
			if (spriteNumber == 1) {
				image = left1;
			}
			if (spriteNumber == 2) {
				image = left2;
			}
			break;
		case "right":
			if (spriteNumber == 1) {
				image = right1;
			}
			if (spriteNumber == 2) {
				image = right2;
			}
			break;
		}
		g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
	}

}
