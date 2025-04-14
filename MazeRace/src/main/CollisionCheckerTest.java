package main;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Rectangle;

import org.junit.jupiter.api.Test;

import entity.Entity;

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
        
    }
}
