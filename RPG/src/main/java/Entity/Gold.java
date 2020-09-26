/**
 * in this class we create crystals and set their parameters
 * @author ismukmak
 */

package Entity;

import Main.SetLogger;
import TileMap.TileMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Gold  extends ThingG {

    private BufferedImage[] sprites;
    private SetLogger logger = new SetLogger();

    /**
     * golds settings
     * @param tm Responsible for the work of a golds with tiles
     */
    public Gold(TileMap tm) {
        super(tm);

        width = 25;
        height = 25;
        cwidth = 15;
        cheight = 15;

        health = maxHealth = 2;
        damage = 1;

        //load sprites
        try{
            BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Enemies/gold.png"));

            sprites = new BufferedImage[1];
                sprites[0] = spritesheet.getSubimage(0,0, width, height);
        }
        catch (Exception e){
            logger.writeLogger(Gold.class.getName() + "load sprites" , e);
        }

        animation = new Animation();
        animation.setFrames(sprites);
    }

    public void draw(Graphics2D g) {
        setMapPosition();
        super.draw(g);
    }

}
