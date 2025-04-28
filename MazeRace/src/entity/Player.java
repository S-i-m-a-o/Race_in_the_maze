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
        this.direction = "down";
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 12;
        solidArea.height = 18;
        solidArea.width = 17;
        getPlayerImage();
    }

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
        if (keyH.wPressed || keyH.aPressed || keyH.sPressed || keyH.dPressed) {
            if (keyH.wPressed) direction = "up";
            else if (keyH.sPressed) direction = "down";
            else if (keyH.aPressed) direction = "left";
            else if (keyH.dPressed) direction = "right";

            collisionOn = false;
            gp.cChecker.checkTile(this);

            if (!collisionOn) {
                switch (direction) {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
                }
            }

            // Check if the player reached the goal tile (tile number 2)
            int tileX = worldX / gp.tileSize;  // Get the tile X coordinate
            int tileY = worldY / gp.tileSize;  // Get the tile Y coordinate

            // Make sure player is within the tile's bounds
            if (gp.tileM.mapTileNumber[tileX][tileY] == 2) {
                if (!gp.gameOver) {
                    gp.gameOver = true;
                    gp.showWinMessage = true;  // Set flag to show win message
                    System.out.println("You Win!");
                }
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                spriteNumber = spriteNumber == 1 ? 2 : 1;
                spriteCounter = 0;
            }
        }
    }

    public void updatePlayerTwo() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed) direction = "up";
            else if (keyH.downPressed) direction = "down";
            else if (keyH.leftPressed) direction = "left";
            else if (keyH.rightPressed) direction = "right";

            collisionOn = false;
            gp.cChecker.checkTile(this);

            if (!collisionOn) {
                switch (direction) {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
                }
            }

            // Check if player 2 reached the goal tile
            int tileX = worldX / gp.tileSize;  // Get the tile X coordinate
            int tileY = worldY / gp.tileSize;  // Get the tile Y coordinate

            // Make sure player is within the tile's bounds
            if (gp.tileM.mapTileNumber[tileX][tileY] == 2) {
                if (!gp.gameOver) {
                    gp.gameOver = true;
                    gp.showWinMessage = true;
                    System.out.println("Player 2 Wins!");
                }
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                spriteNumber = spriteNumber == 1 ? 2 : 1;
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up": image = spriteNumber == 1 ? up1 : up2; break;
            case "down": image = spriteNumber == 1 ? down1 : down2; break;
            case "left": image = spriteNumber == 1 ? left1 : left2; break;
            case "right": image = spriteNumber == 1 ? right1 : right2; break;
        }
        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
    }
}

