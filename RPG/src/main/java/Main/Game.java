/**
 * this class is main class of game, which we run and is created frame
 * @author ismukmak & utemiadi
 */

package Main;

import javax.swing.*;

public class Game {

    public static void main(String[] args) {

        JFrame window = new JFrame("ROB");
        window.setContentPane(new GamePanel());
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }

}
