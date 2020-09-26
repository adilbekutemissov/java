/**
 * this class inherits superclass MapObject and is responsible for object Fireball, that burns after
 * player's fireball attack and dies after collision with blocked tile, enemy or things that player
 * collect during the game
 * @author ismukmak & utemiadi
 */

package Entity;

import Main.SetLogger;
import TileMap.TileMap;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FireBall extends MapObject {

    private boolean hit;
    private boolean remove;
    private BufferedImage[] sprites;
    private SetLogger logger = new SetLogger();

    /**
     * setting fireballs during an attack
     * @param tm responsible for the work of the fireballs with tiles
     * @param right direction of travel fireballs
     */
    FireBall(TileMap tm, boolean right) {
        super(tm);

        facingRight = right;

        moveSpeed = 3.6;
        if (right)
            dx = moveSpeed;
        else
            dx = -moveSpeed;

        width = 30;
        height = 30;
        cwidth = 14;
        cheight = 14;

        //load sprites
        try {
            BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player/fireball.gif"));

            sprites = new BufferedImage[1];
            for(int i = 0; i < sprites.length; i++) {
                sprites[i] = spritesheet.getSubimage(i * width, 0, width, height);
            }

            animation = new Animation();
            animation.setFrames(sprites);
        }
        catch (Exception e){
            logger.writeLogger(FireBall.class.getName() + "load sprites" , e);
        }
    }

    /**
     * settings atack with fireballs
     */
    public void setHit() {
        hit = true;
    }

     /**
     * fade settings
     * @return fade
     */
    public boolean shouldRemove() {
        return remove;
    }

    public void update() {
        checkTileMapCollision();
        setPosition(xtemp, ytemp);

        if(dx == 0 && !hit) {
            setHit();
        }

        animation.update();
        if(hit) {
            remove = true;
        }
    }

    public void draw(Graphics2D g) {
        setMapPosition();

        super.draw(g);
    }

}
