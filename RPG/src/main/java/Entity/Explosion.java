/**
 * this class is responsible for explosion, that happen after wolf's death
 * @author ismukmak & utemiadi
 */

package Entity;

import Main.SetLogger;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Explosion {

    private int x;
    private int y;
    private int xmap;
    private int ymap;

    private int width;
    private int height;

    private Animation animation;
    private SetLogger logger = new SetLogger();
    private BufferedImage[] sprites;

    private boolean remove;

    /**
     * settings during the explosion
     * @param x coordinates of the explosion along the x axis
     * @param y coordinates of the explosion along the y axis
     */
    public Explosion(int x, int y) {
        this.x = x;
        this.y = y;

        width = 30;
        height = 30;

        //load sprites
        try{
            BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Enemies/explosion.gif"));

            sprites = new BufferedImage[6];
            for(int i = 0; i < sprites.length; i++) {
                sprites[i] = spritesheet.getSubimage(i * width, 0, width, height);
            }
        }
        catch (Exception e) {
            logger.writeLogger(Explosion.class.getName() + "load sprites" , e);
        }

        animation = new Animation();
        animation.setFrames(sprites);
        animation.setDelay(70);
    }

    public void update() {
        animation.update();
        if(animation.hasPlayedOnce()) {
            remove = true;
        }
    }

    /**
     * fade settings
     * @return fade
     */
    public boolean shouldRemove() {
        return remove;
    }

    /**
     * settings the coordinates on the map
     * @param x coordinates of the explosion along the x axis
     * @param y coordinates of the explosion along the y axis 
     */
    public void setMapPosition(int x, int y) {
        xmap = x;
        ymap = y;
    }

    public void draw(Graphics2D g) {
        g.drawImage(animation.getImage(), x + xmap - width / 2, y + ymap - height / 2, null);
    }

}
