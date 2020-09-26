/**
 * this class organizes game over state
 * this state run
 */

package GameState;

import Main.GamePanel;
import Main.SetLogger;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GameOverState extends GameState {

    private int currentChoice = 0;
    private String[] options = {
            "New Game",
            "      Quit"
    };

    private Color titleColor;
    private Font titleFont;

    private Font font;

    private SetLogger logger = new SetLogger();

   /**
     * setting the title and options of the Game Over menu
     * @param gsm contains application states
     */
    GameOverState(GameStateManager gsm) {
        this.gsm = gsm;

        try {
            titleColor = new Color(255, 0, 0);
            titleFont = new Font("Eras Bold ITC", Font.PLAIN, 33);

            font = new Font("Arial black", Font.PLAIN, 12);
        }
        catch(Exception e) {
            logger.writeLogger(GameOverState.class.getName() + "init.fileread", e);
            e.printStackTrace();
        }
    }

    public void init() {}

    public void update() {
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

        // draw title
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("GAME OVER", 60, 100);

        // draw menu options
        g.setFont(font);
        for(int i = 0; i < options.length; i++) {
            if(i == currentChoice) {
                g.setColor(Color.RED);
            }
            else {
                g.setColor(Color.WHITE);
            }
            g.drawString(options[i], 130, 150 + i * 15);
        }
    }

    /*
    selects the pause menu option
    throws IOException if the pause menu option can not be selected
    */
    private void select() throws IOException {
        if(currentChoice == 0) {
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter("src/main/Save/save.txt"));
            writer.write(100 + "\n" + 100 + "\n" + 0 + "\n" + 0 + "\n" + 0 + "\n" + 3 + "\n" + 0 + "\n" + 2500);
            writer.close();
            gsm.setState(GameStateManager.LEVELSTATE);
        }
        if(currentChoice == 1) {
             gsm.setState(GameStateManager.MENUSTATE);
        }
    }

    /**
     * Called by the system in case of pressing any key on the keyboard
     * @param k generated when typing from the keyboard
     * throws IOException if the key can not be pressed
     */
    public void keyPressed(int k) throws IOException {
        if(k == KeyEvent.VK_ENTER){
            select();
        }
        if(k == KeyEvent.VK_UP) {
            currentChoice--;
            if(currentChoice == -1)
                currentChoice = options.length - 1;
        }
        if(k == KeyEvent.VK_DOWN) {
            currentChoice++;
            if(currentChoice == options.length)
                currentChoice = 0;
        }
    }

    public void keyReleased(int k) {}

}










