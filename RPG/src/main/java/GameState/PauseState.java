/**
 * this class is responsible for pause in game and called, when user
 * taps escape during the game
 * in pause menu user can continue game, start new game or quit game
 * @author ismukmak
 */

package GameState;

import Main.GamePanel;
import TileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PauseState extends GameState {

    private int currentChoice = 0;

    private String[] options = {
            "         Resume",
            "       New Game",
            "Save Game & Menu",
            " Save Game & Quit",
    };

    private Color titleColor;
    private Background bg;

    private Font titleFont;

    private Font font;

    /**
     * setting the title and options of the pause menu
     * @param gsm contains application states
     */
    public PauseState(GameStateManager gsm) {
        this.gsm = gsm;

        try {
            bg = new Background("/Backgrounds/menubg.png");
            titleColor = new Color(0, 255, 0);

            titleFont = new Font("Eras Bold ITC", Font.PLAIN, 30);

            font = new Font("Arial black", Font.PLAIN, 12);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {
    }

    public void update() {
    }

    public void draw(Graphics2D g) {
        // draw bg
        bg.draw(g);

        // draw title
        g.setColor(titleColor);
        g.setFont(titleFont);

        // draw title
        g.drawString("PAUSE", 115, 60);

        // draw menu options
        g.setFont(font);
        for(int i = 0; i < options.length; i++) {
            if(i == currentChoice) {
                g.setColor(Color.green);
            }
            else {
                g.setColor(Color.WHITE);
            }
            g.drawString(options[i], 107, 120 + i * 15);
        }
    }
    
    /*
    selects the pause menu option
    throws IOException if the pause menu option can not be selected
    */
    private void select() throws IOException {
        if(currentChoice == 0) {
            gsm.setState(GameStateManager.LEVELSTATE);
            currentChoice =0;
        }

        if(currentChoice == 1) {
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter("src/main/Save/save.txt"));
            writer.write(100 + "\n" + 100 + "\n" + 0 + "\n" + 0 + "\n" + 0 + "\n" + 3 + "\n" + 0 + "\n" + 2500);
            writer.close();

            gsm.setState(GameStateManager.LEVELSTATE);
            currentChoice =0;
        }
        if(currentChoice == 2) {
            gsm.setState(GameStateManager.MENUSTATE);
            currentChoice = 0;
        }
        if(currentChoice == 3) {
            System.exit(0);
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










