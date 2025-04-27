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
        GamePanel leftSide = new GamePanel();
        Entity leftSideEntity = new Entity();
        leftSideEntity.worldX = 6*gp.tileSize;
        leftSideEntity.worldY = 11*gp.tileSize;
        leftSideEntity.solidArea = new Rectangle(0,0,32,32);
        leftSideEntity.direction = "down";
        CollisionChecker leftSideChecker = new CollisionChecker(leftSide);;
        leftSideChecker.checkTile(leftSideEntity);
        assertTrue(leftSideEntity.collisionOn);
        
        
        //This test passes because the tile directly south has its collision off. (invisible wall)
        GamePanel middle = new GamePanel();
        Entity middleEntity = new Entity();
        middleEntity.worldX = 6*gp.tileSize;
        middleEntity.worldY = 12*gp.tileSize;
        middleEntity.solidArea = new Rectangle(0,0,32,32);
        middleEntity.direction = "down";
        CollisionChecker middleChecker = new CollisionChecker(middle);
        middleChecker.checkTile(middleEntity);
        assertFalse(middleEntity.collisionOn);
        
        
        //This test passes because the tile directly south has its collision on.
        GamePanel rightSide = new GamePanel();
        Entity rightSideEntity = new Entity();
        rightSideEntity.worldX = 6*gp.tileSize;
        rightSideEntity.worldY = 13*gp.tileSize;
        rightSideEntity.solidArea = new Rectangle(0,0,32,32);
        rightSideEntity.direction = "down";
        CollisionChecker rightSideChecker = new CollisionChecker(rightSide);
        rightSideChecker.checkTile(rightSideEntity);
        assertTrue(rightSideEntity.collisionOn);

       
    }
}