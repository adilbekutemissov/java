/**
 * this class inherits {@link Entity.BigEnemy} class and loads sprites, sets parameters for
 * hulk, who waits player at the end of every level
 * @author ismukmak
 */

package Entity.Enemies;

import Entity.Animation;
import Entity.BigEnemy;
import Main.SetLogger;
import TileMap.TileMap;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Hulk extends BigEnemy {

    private BufferedImage[] sprites;
    private SetLogger logger = new SetLogger();

    /**
     * hulk settings
     * @param tm Responsible for the work of a hulk with tiles
     */
    public Hulk(TileMap tm) {
        super(tm);

        width = 100;
        height = 92;
        cwidth = 16;
        cheight = 16;

        damage = 0;

        //load sprites
        try{
            BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Enemies/hulk.png"));

            sprites = new BufferedImage[1];

            for(int i = 0; i < sprites.length; i++) {
                sprites[i] = spritesheet.getSubimage(i * width, 0, width, height);
            }
        }
        catch (Exception e){
            logger.writeLogger(Hulk.class.getName() + "load sprites" , e );
        }

        animation = new Animation();
        animation.setFrames(sprites);

        right = true;
        facingRight = true;
    }

    public void update() {
        animation.update();
    }

    public void draw(Graphics2D g) {
        setMapPosition();
        super.draw(g);
    }

}
