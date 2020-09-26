package Entity.Enemies;

import TileMap.TileMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class WolfTest {
    TileMap tm = new TileMap();
    Wolf wolf = new Wolf(tm);

    @Test
    public void update() {
        wolf.setLeft();
        wolf.setdx(0);
        assertTrue(wolf.getRight());
    }
}