/**
 * in this class we create panel for heart,gold, fireball and diamond
 * @author ismukmak
 */

package Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import Main.SetLogger;

public class HUD {

    private Player player;

    private BufferedImage image;
    private BufferedImage image2;
    private BufferedImage diamond;
    private BufferedImage gold;
    private Font font;

    private SetLogger logger = new SetLogger();

    /**
     * metric adjustment
     * @param p Responsible for the work of a diamonds,health,fireballs and golds with player
     */
    public HUD (Player p) {
        player = p;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/HUD/hud.gif"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Enemies/hud.gif"));
            diamond = ImageIO.read(getClass().getResourceAsStream("/Sprites/Enemies/diamond2.png"));
            gold = ImageIO.read(getClass().getResourceAsStream("/Sprites/Enemies/gold.png"));

            font = new Font("Arial", Font.PLAIN, 14);
        }
        catch (Exception e) {
            logger.writeLogger("HUD", e);
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {
        g.drawImage(image, 0, 10, null);
        //g.setColor(Color.black);
        g.drawImage(image2, 0, 53, null);
        //g.fillRect(0, 53, 60, 22);
        g.drawImage(diamond, 0, 52, 20, 20, null);
        //g.fillRect(0, 80, 60, 22);
        g.drawImage(gold, 0, 74, 20, 20, null);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(player.getHealth() + "/" + player.getMaxHealth(), 30, 25);
        g.drawString(player.getFire() / 100 + "/" + player.getMaxFire() / 100, 30, 45);
    }

}
