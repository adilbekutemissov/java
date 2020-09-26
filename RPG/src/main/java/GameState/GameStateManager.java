/**
 * this class creates, manages and sets game states
 * @author ismukmak & utemiadi
 */

package GameState;

import java.io.IOException;
import java.util.ArrayList;

public class GameStateManager {

    private ArrayList<GameState> gameStates;
    private int currentState;

    /**
     * all application states
     */
    public static final int MENUSTATE = 0;
    public static final int HELPSTATE = 1;
    public static final int LEVELSTATE = 2;
    public static final int GAMEOVERSTATE = 3;
    public static final int PAUSESTATE = 4;
    public static final int FINISHSTATE = 5;


    /**
     * append all application states
     * @throws IOException If the application state can not be added
     */
    public GameStateManager() throws IOException {

        gameStates = new ArrayList<GameState>();

        currentState = MENUSTATE;
        gameStates.add(new MenuState(this));
        gameStates.add(new HelpState(this));
        gameStates.add(new LevelState(this));
        gameStates.add(new GameOverState(this));
        gameStates.add(new PauseState(this));
        gameStates.add(new FinishState(this));
    }

    /**
     * setting the current state of the application
     * @param state contains the application state 
     * @throws IOException  if the current state of the application can not be installed
     */
    public void setState(int state) throws IOException {
        currentState = state;
        gameStates.get(currentState).init();
    }

    public void update() {
        gameStates.get(currentState).update();
    }

    public void draw(java.awt.Graphics2D g) throws IOException {
        gameStates.get(currentState).draw(g);
    }

    /**
     * Called by the system in case of pressing any key on the keyboard
     * @param k generated when typing from the keyboard
     */
    public void keyPressed(int k) {
        try {
            gameStates.get(currentState).keyPressed(k);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Called when you release any key on the keyboard
     * @param k generated when typing from the keyboard
     */
    public void keyReleased(int k) {
        try {
            gameStates.get(currentState).keyReleased(k);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}









