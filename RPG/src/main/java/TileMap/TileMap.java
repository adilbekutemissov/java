/**
 * this class loads map's sprites and the very map from .map file and after creates
 * and draws map for game
 * @author ismukmak & utemiadi
 */

package TileMap;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import Main.GamePanel;
import Main.SetLogger;

public class TileMap {

    //logger
    private SetLogger logger = new SetLogger();

    // position
    private double x;
    private double y;

    // bounds
    private int xmin;
    private int ymin;
    private int xmax;
    private int ymax;

    // map
    private int[][] map;
    private int tileSize = 30;
    private int numRows;
    private int numCols;
    private int width;
    private int height;

    // tileset
    private BufferedImage tileset;
    private int numTilesAcross = 5;
    private Tile[][] tiles;

    // drawing
    private int colOffset;
    private int numRowsToDraw;
    private int numColsToDraw;

    /**
     * counts the number of rows and columns to draw
     */
    public TileMap() {
        numRowsToDraw = GamePanel.HEIGHT / tileSize;
        numColsToDraw = GamePanel.WIDTH / tileSize + 2;
    }
    
    /**
     * load tiles from the image to create map
     * @param s indicates the path to the image with tiles
    */
     public void loadTiles(String s) {
        try {
            tileset = ImageIO.read(getClass().getResourceAsStream(s));
            numTilesAcross = tileset.getWidth() / tileSize;
            tiles = new Tile[2][numTilesAcross];

            BufferedImage subimage;
                subimage = tileset.getSubimage(0, 0, tileSize, tileSize);
                tiles[0][0] = new Tile(subimage, Tile.NORMAL);
                for(int col = 0; col < numTilesAcross; col++) {
                subimage = tileset.getSubimage(col * tileSize, tileSize, tileSize, tileSize);
                tiles[1][col] = new Tile(subimage, Tile.BLOCKED);
            }
        }
        catch(Exception e) {
            logger.writeLogger(TileMap.class.getName() + "load tiles" , e);
        }
    }

    /**
     * load map from .map file
     * @param s indicates the path to the file with map
    */
    public void loadMap(String s) {
        try {
            InputStream in = getClass().getResourceAsStream(s);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            numCols = Integer.parseInt(br.readLine());
            numRows = Integer.parseInt(br.readLine());
            map = new int[numRows][numCols];
            width = numCols * tileSize;
            height = numRows * tileSize;

            xmin = GamePanel.WIDTH - width;
            xmax = 0;
            ymin = GamePanel.HEIGHT - height;
            ymax = 0;

            for(int row = 0; row < numRows; row++) {
                String line = br.readLine();
                String[] tokens = line.split("\\s+");
                for(int col = 0; col < numCols; col++) {
                    map[row][col] = Integer.parseInt(tokens[col]);
                }
            }
        }
        catch(Exception e) {
            logger.writeLogger(TileMap.class.getName() + "load map" , e);
        }
    }

    public double getx() { return (int)x; }

    public double gety() { return (int)y; }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    /**
     * getting a certain tile from the image
     * @param row contains a specific row from the map
     * @param col contains a specific coloumn from the map
     * @return returnы certain tile
     */
    public int getType(int row, int col) {
        int rc = map[row][col];
        int r = rc / numTilesAcross;
        int c = rc % numTilesAcross;
        return tiles[r][c].getType();
    }

    /**
     * setting the camera's coordinates relative to the player
     * @param x-coordinate of the player
     * @param y-coordinate of the player
    */
    public void setPosition(double x, double y) {
        this.x += (x - this.x);
        this.y += (y - this.y);

        fixBounds();

        colOffset = (int)-this.x / tileSize;
    }

    //setting boundaries
    private void fixBounds() {
        if(x < xmin) x = xmin;
        if(y < ymin) y = ymin;
        if(x > xmax) x = xmax;
        if(y > ymax) y = ymax;
    }

    //drawing
    public void draw(Graphics2D g) {
        for(int row = 0; row < numRowsToDraw; row++) {
            for(int col = colOffset; col < colOffset + numColsToDraw; col++) {
                if(col >= numCols) break;

                if(map[row][col] == 0) continue;

                int rc = map[row][col];
                int r = rc / numTilesAcross;
                int c = rc % numTilesAcross;

                g.drawImage(tiles[r][c].getImage(), (int)x + col * tileSize, row * tileSize, null);
            }
        }
    }

}
