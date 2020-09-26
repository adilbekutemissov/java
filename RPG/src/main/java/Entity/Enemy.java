/**
 * this class is abstract class for {@link Entity.Enemies.Wolf}
 */

package Entity;

import TileMap.TileMap;

public abstract class Enemy extends MapObject {

    protected int health;
    protected int maxHealth;
    private boolean dead;
    protected int damage;

    /**
     * parameters of the enemies with tiles
     * @param tm responsible for the work of the enemies with tiles
     */
    public Enemy(TileMap tm) {
        super(tm);
    }

    public boolean isDead() { return dead; }

      /**
     * Setting atack
     * @return 
     */
    public int getDamage() { return damage; }

   /**
     * player attack actions on enemies
     * @param damage responsible for the damage
     */
    public void hit (int damage) {
        if (dead)
            return;
        health -= damage;

        if(health <= 0)
            dead = true;
    }

    public void update () {}

}
