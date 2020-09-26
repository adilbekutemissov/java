/**
 * this class is abstract for other classes, which are responsible for another game states like a
 * level state, menu state, level complete or game over state and etc.
 * @author ismukmak & utemiadi
 */

package GameState;

import java.io.IOException;

public abstract class GameState {

    protected GameStateManager gsm;

    public abstract void init() throws IOException;

    public abstract void update();

    public abstract void draw(java.awt.Graphics2D g) throws IOException;

    public abstract void keyPressed(int k) throws IOException;

    public abstract void keyReleased(int k) throws IOException;
}
