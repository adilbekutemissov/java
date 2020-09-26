/**
 * this class inherits abstract class GameState, provides implementations to the
 * abstract methods and also organizes classic menu's work,
 * where we can start new game or continue last game, find game's tutorial or close game
 * @author ismukmak & utemiadi
 */

package GameState;

import TileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MenuState extends GameState {

    private Background bg;
    private int currentChoice = 0;
    private String[] options = {
            "    New game",
            "Continue game",
            "        Help",
            "        Quit"
    };

    private Color titleColor;
    private Font titleFont;

    private Font font;

    /**
     * setting the title and options of the main menu
     * @param gsm contains application states
     */
    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;

        try {
            bg = new Background("/Backgrounds/menubg.png");

            titleColor = new Color(0, 255, 0);
            titleFont = new Font("Eras Bold ITC", Font.PLAIN, 28);

            font = new Font("Arial black", Font.PLAIN, 14);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {}

    public void update() {
    }

    public void draw(Graphics2D g) {
        // draw bg
        bg.draw(g);

        // draw title
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("ROB", 137, 70);

        // draw menu options
        g.setFont(font);
        for(int i = 0; i < options.length; i++) {
            if(i == currentChoice) {
                g.setColor(Color.GREEN);
            }
            else {
                g.setColor(Color.WHITE);
            }
            g.drawString(options[i], 113, 130 + i * 15);
        }
    }

    /*
    selects the pause menu option
    throws IOException if the pause menu option can not be selected
    */
    private void select() throws IOException {
        // start new game
        if(currentChoice == 0) {
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter("src/main/Save/save.txt"));
            writer.write(100 + "\n" + 100 + "\n" + 0 + "\n" + 0 + "\n" + 0 + "\n" + 3 + "\n" + 0 + "\n" + 2500);
            writer.close();
            gsm.setState(GameStateManager.LEVELSTATE);

        }
        //continue last game
        if(currentChoice == 1) {
            gsm.setState(GameStateManager.LEVELSTATE);
            currentChoice = 0;
        }
        //tutorial
        if(currentChoice == 2) {
            // help
            gsm.setState(GameStateManager.HELPSTATE);
        }

        if(currentChoice == 3) {
            System.exit(0);
        }
    }

    /**
     * Called by the system in case of pressing any key on the keyboard
     * @param key generated when typing from the keyboard
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










