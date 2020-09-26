/**
 * this class set background, whose image are loaded
 * in some classes that are responsible for game states
 * @author ismukmak & utemiadi
 */

package TileMap;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class Background {

    private BufferedImage image;

    /**
     * reads background image
     * @param s indicates the path to the image
     */
    public Background(String s) {
        try {
            image = ImageIO.read(getClass().getResourceAsStream(s));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {
        g.drawImage(image, 0, 0, null);
    }

}







