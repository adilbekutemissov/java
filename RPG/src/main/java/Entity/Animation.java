/**
 * this class organizes animation of player, explosion and wolf
 * @author ismukmak & utemiadi
 */

package Entity;

import Main.SetLogger;

import java.awt.image.BufferedImage;

public class Animation {

    private SetLogger logger = new SetLogger();
    private BufferedImage[] frames;

    private int currentFrame;
    private long startTime;
    private long delay;

    private boolean playedOnce;

    /**
     * Frames settings
     * @param frames array with frames
     */
    public void setFrames(BufferedImage[] frames) {
        this.frames = frames;
        currentFrame = 0;
        startTime = System.nanoTime();
        playedOnce = false;
    }

    /**
     * setback settings
     * @param d How long will the delay last
     */
    public void setDelay(long d) { delay = d; }

    public void update() {
        if(delay == -1) return;

        long elapsed = (System.nanoTime() - startTime) / 1000000;

        if(elapsed > delay) {
            currentFrame++;
            startTime = System.nanoTime();
        }
        if(currentFrame == frames.length) {
            currentFrame = 0;
            playedOnce = true;
        }
    }

    /**
     * selection of a specific frame
     * @return current frame
     */
    public BufferedImage getImage() { return frames[currentFrame]; }

    /**
     * Responsible for the passability of all frames
     * @return true if all frames have passed
     */
    public boolean hasPlayedOnce() { return playedOnce; }

}
