package GameState;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class Level1StateTest {

    @Test
    public void init() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/main/Save/save.txt"));
            int actualx = sc.nextInt();
            int actualy = sc.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}