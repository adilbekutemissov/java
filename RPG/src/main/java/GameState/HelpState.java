/**
 * This class opens the image with the tutorial in the same window
 */

package GameState;

import TileMap.Background;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import Main.SetLogger;

public class HelpState extends GameState {

    private Background bg;

    private SetLogger logger = new SetLogger();

    /**
     * setting the image with tutorial
     * @param gsm contains application states
     */
    public HelpState(GameStateManager gsm) {
        //game state manager
        this.gsm = gsm;

        try {
            bg = new Background("/Help/tutorial.png");
        }
        catch(Exception e) {
            logger.writeLogger(HelpState.class.getName() + "init.fileread", e);
            e.printStackTrace();
        }
    }

    public void init() {}

    public void update() {
    }

    public void draw(Graphics2D g) {
        bg.draw(g);
    }
/**
     * Called by the system in case of pressing any key on the keyboard
     * @param k generated when typing from the keyboard
     * throws IOException if the key can not be pressed
     */
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_ESCAPE){
            try {
                gsm.setState(GameStateManager.MENUSTATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void keyReleased(int k) {}

}










