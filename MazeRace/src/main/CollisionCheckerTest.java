package main;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Rectangle;

import org.junit.jupiter.api.Test;

import entity.Entity;
import entity.Player;

class CollisionCheckerTest {

    @Test
    void testCollision() {
        GamePanel gp = new GamePanel();
        Entity entity = new Entity();
        
        entity.worldX = 31;
        entity.worldY = 31;
        entity.solidArea = new Rectangle(0, 0, 32, 32);
        entity.direction = "up";
        CollisionChecker checker = new CollisionChecker(gp);
        checker.checkTile(entity);
        assertTrue(entity.collisionOn);
        
        GamePanel gpTwo = new GamePanel();
        Entity entityTwo = new Entity();
        entityTwo.worldX = 32;
        entityTwo.worldY = 32;
        entityTwo.solidArea = new Rectangle(0, 0, 32, 32);
        entityTwo.direction = "up";
        CollisionChecker checkerTwo = new CollisionChecker(gpTwo);
        checkerTwo.checkTile(entityTwo);
        assertFalse(entityTwo.collisionOn);
        
        GamePanel gpThree = new GamePanel();
        Entity entityThree = new Entity();
        entityThree.worldX = 100;
        entityThree.worldY = 100;
        entityThree.solidArea = new Rectangle(10, 10, 32, 32);
        entityThree.direction = "down";
        CollisionChecker checkerThree = new CollisionChecker(gpThree);
        checkerThree.checkTile(entityThree);
        assertTrue(entityThree.collisionOn);
        
        //===============================================================
        //Tests for Milestone Three.. Invisible walls.
        
        
        //This test passes because the tile directly south of it has its collision on.
        GamePanel leftSideDown = new GamePanel();
        Entity leftSideEntityDown = new Entity();
        leftSideEntityDown.worldX = 6*gp.tileSize;
        leftSideEntityDown.worldY = 11*gp.tileSize;
        leftSideEntityDown.solidArea = new Rectangle(0,0,32,32);
        leftSideEntityDown.direction = "down";
        CollisionChecker leftSideChecker = new CollisionChecker(leftSideDown);;
        leftSideChecker.checkTile(leftSideEntityDown);
        assertTrue(leftSideEntityDown.collisionOn);
        
        
        //This test passes because the tile directly south has its collision off. (invisible wall)
        GamePanel middleDown = new GamePanel();
        Entity middleEntityDown = new Entity();
        middleEntityDown.worldX = 7*gp.tileSize;
        middleEntityDown.worldY = 11*gp.tileSize;
        middleEntityDown.solidArea = new Rectangle(1,1,30,30);
        middleEntityDown.direction = "down";
        CollisionChecker middleCheckerDown = new CollisionChecker(middleDown);
        middleCheckerDown.checkTile(middleEntityDown);
        assertFalse(middleEntityDown.collisionOn);
        
        
        //This test passes because the tile directly south has its collision on.
        GamePanel rightSideDown = new GamePanel();
        Entity rightSideEntityDown = new Entity();
        rightSideEntityDown.worldX = 8*gp.tileSize;
        rightSideEntityDown.worldY = 11*gp.tileSize;
        rightSideEntityDown.solidArea = new Rectangle(0,0,32,32);
        rightSideEntityDown.direction = "down";
        CollisionChecker rightSideChecker = new CollisionChecker(rightSideDown);
        rightSideChecker.checkTile(rightSideEntityDown);
        assertTrue(rightSideEntityDown.collisionOn);
        
        
        //This test passes because the tile directly it resides on has its collision on.
        GamePanel leftSideUp = new GamePanel();
        Entity leftSideEntityUp = new Entity();
        leftSideEntityUp.worldX = 6*gp.tileSize;
        leftSideEntityUp.worldY = 12*gp.tileSize;
        leftSideEntityUp.solidArea = new Rectangle(0,0,32,32);
        leftSideEntityUp.direction = "up";
        CollisionChecker leftSideCheckerUp = new CollisionChecker(leftSideUp);;
        leftSideCheckerUp.checkTile(leftSideEntityUp);
        assertTrue(leftSideEntityUp.collisionOn);
       
        //This test passes because the tile directly north has its collision off. (invisible wall)
        GamePanel middleUp = new GamePanel();
        Entity middleEntityUp = new Entity();
        middleEntityUp.worldX = 7*gp.tileSize;
        middleEntityUp.worldY = 13*gp.tileSize;
        middleEntityUp.solidArea = new Rectangle(0,0,32,32);
        middleEntityUp.direction = "up";
        CollisionChecker middleCheckerUp = new CollisionChecker(middleUp);
        middleCheckerUp.checkTile(middleEntityUp);
        assertFalse(middleEntityUp.collisionOn);
        
        //This test passes because the tile directly north has its collision on.
        GamePanel rightSideUp = new GamePanel();
        Entity rightSideEntityUp = new Entity();
        rightSideEntityUp.worldX = 8*gp.tileSize;
        rightSideEntityUp.worldY = 13*gp.tileSize;
        rightSideEntityUp.solidArea = new Rectangle(0,0,32,32);
        rightSideEntityUp.direction = "down";
        CollisionChecker rightSideCheckerUp = new CollisionChecker(rightSideUp);
        rightSideCheckerUp.checkTile(rightSideEntityUp);
        assertTrue(rightSideEntityUp.collisionOn);
        
       
    }
}