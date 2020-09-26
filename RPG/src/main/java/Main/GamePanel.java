/**
 * this class sets parameters of our frame and also is responsible for correct running
 * @author ismukmak & utemiadi
 */

package Main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.JPanel;

import GameState.GameStateManager;

public class GamePanel extends JPanel implements Runnable, KeyListener{

    // dimensions
    public static final int WIDTH = 320;
    public static final int HEIGHT = 240;
    public static final int SCALE = 2;

    // game thread
    private Thread thread;
    private boolean running;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;

    // image
    private BufferedImage image;
    private Graphics2D g;

    // game state manager
    private GameStateManager gsm;

    /*
     * configures the application window 
     */
    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setFocusable(true);
        requestFocus();
    }

    /**
     * checks and notifies the end of the thread
     */
    public void addNotify() {
        super.addNotify();
        if(thread == null) {
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    private void init() throws IOException {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();

        setRunning();
        gsm = new GameStateManager();
    }

    public void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long start;
        long elapsed;
        long wait;

        // game loop
        while(running) {
            start = System.nanoTime();

            update();
            try {
                draw();
            } catch (IOException e) {
                e.printStackTrace();
            }
            drawToScreen();

            elapsed = System.nanoTime() - start;

            wait = targetTime - elapsed / 1000000;
            if(wait < 0) wait = 5;

            try {
                Thread.sleep(wait);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setRunning() {
        running = true;
    }

    private void update() {
        gsm.update();
    }

    private void draw() throws IOException {
        gsm.draw(g);
    }

    private void drawToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
        g2.dispose();
    }

    /**
     * called by the system every time the user clicks on the keyboard keys Unicode characters
     * @param key generated when typing from the keyboard
     */
    public void keyTyped(KeyEvent key) {}

    /**
     * Called by the system in case of pressing any key on the keyboard
     * @param key generated when typing from the keyboard
     */
    public void keyPressed(KeyEvent key) {
        gsm.keyPressed(key.getKeyCode());
    }

    /**
     * Called when you release any key on the keyboard
     * @param key generated when typing from the keyboard
     */
    public void keyReleased(KeyEvent key) {
        gsm.keyReleased(key.getKeyCode());
    }

}