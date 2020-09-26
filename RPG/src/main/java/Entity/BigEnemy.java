/**
 * this class inherits {@link Entity.MapObject} and
 * also is abstract class for {@link Entity.Enemies.Hulk}
 * @author ismukmak
 */

package Entity;

import TileMap.TileMap;

public abstract class BigEnemy extends MapObject {

    protected int damage;

    /**
     * parameters of the hulk with tiles
     * @param tm responsible for the work of the hulk with tiles
     */
    public BigEnemy(TileMap tm) {
        super(tm);
    }

    /**
     * Setting atack
     * @return 
     */
    public int getDamage() { return damage; }

    public void hit (int k) {}

    public void update () {}

}
