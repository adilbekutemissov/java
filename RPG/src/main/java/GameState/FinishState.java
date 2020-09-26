/**
 * this class organizes game's level complete state. class is calls, when player
 * collects required things and gets to finish.
 * in this state user can start level again, start next level or close the game
 */

package GameState;

import Main.GamePanel;
import Main.SetLogger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FinishState extends GameState {

    private int currentChoice = 0;
    private String[] options = {
            "          Next level",
            " Start this level again",
            "Save game and Menu",
            " Save game and Quit"
    };

    private Color titleColor;
    private Font titleFont;

    private SetLogger logger = new SetLogger();

    private Font font;

    /**
     * setting the title and options of the Finish game menu
     * @param gsm contains application states
     */
    FinishState(GameStateManager gsm) {
        this.gsm = gsm;

        try {
            //titleColor = new Color(255, 0, 0);
            titleFont = new Font("Eras Bold ITC", Font.PLAIN, 30);

            font = new Font("Arial black", Font.PLAIN, 12);

        }
        catch(Exception e) {
            logger.writeLogger(FinishState.class.getName() + "init.fileread", e);
            e.printStackTrace();
        }

    }

    public void init() {}

    public void update() {}

    public void draw(Graphics2D g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

        // draw title
        g.setColor(Color.green);
        g.setFont(titleFont);
        g.drawString("LEVEL COMPLETE", 25, 110);

        // draw menu options
        g.setFont(font);
        for(int i = 0; i < options.length; i++) {
            if(i == currentChoice) {
                g.setColor(Color.green);
            }
            else {
                g.setColor(Color.WHITE);
            }
            g.drawString(options[i], 90, 140 + i * 15);
        }
    }

    /*
    selects the pause menu option
    throws IOException if the pause menu option can not be selected
    */
    private void select() throws IOException {
        if(currentChoice == 0) {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Sorry, but now next level isn't available.");
        }

        if(currentChoice == 1) {
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter("src/main/Save/save.txt"));
            writer.write(100 + "\n" + 100 + "\n" + 0 + "\n" + 0 + "\n" + 0 + "\n" + 3 + "\n" + 0 + "\n" + 2500);
            writer.close();
            gsm.setState(GameStateManager.LEVELSTATE);
        }

        if(currentChoice == 2) {
            gsm.setState(GameStateManager.MENUSTATE);
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










