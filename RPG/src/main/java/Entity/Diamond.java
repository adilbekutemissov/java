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

public class Diamond extends ThingD {

    private BufferedImage[] sprites;

    private SetLogger logger = new SetLogger();

    /**
     * diamonds settings
     * @param tm Responsible for the work of a diamonds with tiles
     */
    public Diamond(TileMap tm) {
        super(tm);

        width = 30;/**
     * player settings
     * @param tm Responsible for the work of a player with tiles
     */
        height = 30;
        cwidth = 20;
        cheight = 20;

        health = maxHealth = 6;
        damage = 1;

        //load sprites
        try{
            BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Enemies/diamond2.png"));

            sprites = new BufferedImage[1];
            sprites[0] = spritesheet.getSubimage(0, 0, width, height);
        }
        catch (Exception e){
            logger.writeLogger(Diamond.class.getName() + "load sprites" , e);
        }
        animation = new Animation();
        animation.setFrames(sprites);
    }

    public void update() {}

    public void draw(Graphics2D g) {
        setMapPosition();
        super.draw(g);
    }

}
