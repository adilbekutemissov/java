package Entity;

import TileMap.TileMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThingDTest {
    TileMap tm = new TileMap();
    ThingD td = new ThingD(tm);

    @Test
    public void hit() {
        td.setHealth();
        td.hit(2);
        int actual = td.getHealth();
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void isDead() {
        td.setHealth();
        td.hit(6);
        assertTrue(td.isDead());
    }

}