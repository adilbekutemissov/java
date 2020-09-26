/**
 * this class sets tiles, which are loaded in {@link TileMap}
 * @author ismukmak & utemiadi
 */

package TileMap;

import java.awt.image.BufferedImage;

public class Tile {

    private TileMap tm;
    private BufferedImage image;
    private int type;

    // tile types
    public static final int NORMAL = 0;
    public static final int BLOCKED = 1;

    /**
     * Assigning a local variable image, type to the instance variable image,type
     * @param image contains an image
     * @param type contains its type
     */
    Tile(BufferedImage image, int type) {
        this.image = image;
        this.type = type;
    }

    public BufferedImage getImage() { return image; }

    public int getType() { return type; }

}
