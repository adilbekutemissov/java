package Entity;

import TileMap.TileMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    TileMap tm = new TileMap();
    Player player = new Player(tm);

    @Test
    public void setHealth() {
        int actual = 3;
        player.setHealth(actual);
        int expected = player.getHealth();
        assertEquals(expected,  actual);
    }

    @Test
    public void isDead() {
        player.setHealth(3);
        player.hit(3);
        assertTrue(player.isDead());
    }

    @Test
    public void hit() {
        player.setHealth(3);
        player.hit(1);
        int actual = player.getHealth();
        int expected = 2;
        assertEquals(expected, actual);
    }

}