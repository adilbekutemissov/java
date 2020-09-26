/**
 * this class inherits abstract class {@link Entity.Enemy} and is responsible for wolfs who are
 * player's enemies in the game
 * @author ismukmak & utemiadi
 */

package Entity.Enemies;

import Entity.Animation;
import Entity.Enemy;
import Main.SetLogger;
import TileMap.TileMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Wolf extends Enemy {

    private BufferedImage[] sprites;

    private SetLogger logger = new SetLogger();

    /**
     * enemies settings
     * @param tm Responsible for the work of a enemies with tiles
     */
    public Wolf(TileMap tm) {
        super(tm);

        moveSpeed = 1.7;
        maxSpeed = 1.7;

        width = 30;
        height = 30;
        cwidth = 21;
        cheight = 21;

        health = maxHealth = 4;
        damage = 1;

        //load sprites
        try{
            BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Enemies/wolf2.png"));

            sprites = new BufferedImage[6];
            for(int i = 0; i < sprites.length; i++) {
                sprites[i] = spritesheet.getSubimage(i * width, 0, width, height);
            }
        }
        catch (Exception e){
            logger.writeLogger(Wolf.class.getName() + "load sprites" , e);
        }

        animation = new Animation();
        animation.setFrames(sprites);
        animation.setDelay(150);

        right = true;
        facingRight = true;
    }

    /**
     * setting the enemy's current position while driving
     * @param dx1 the current position of the enemy during the movement
     */
    public void setdx(int dx1) { dx = dx1;}

    /**
     * move left
     */
    public void setLeft() { left = true;}

    /**
     * move right
     * @return direction of the enemy to the right
     */
    public boolean getRight() { return right; }

    private void getNextPosition() {
        // movement
        if(left) {
            dx -= moveSpeed;
            if(dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        }
        else if(right) {
            dx += moveSpeed;
            if(dx > maxSpeed) {
                dx = maxSpeed;
            }
        }
    }

    public void update() {
        //update position
        getNextPosition();
        checkTileMapCollision();
        setPosition(xtemp, ytemp);

        //if it hits a wall, go other direction
        if(right && dx == 0) {
            right = false;
            left = true;
            facingRight = false;
        }
        else if(left && dx == 0) {
            right = true;
            left = false;
            facingRight = true;
        }
        animation.update();
    }

    public void draw(Graphics2D g) {
        setMapPosition();
        super.draw(g);
    }

}
