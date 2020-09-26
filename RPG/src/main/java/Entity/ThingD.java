package Entity;

import TileMap.TileMap;

public class ThingD extends MapObject{

    int health;
    int maxHealth;
    private boolean dead;
    int damage;

    /**
     * parameters of the diamonds with tiles
     * @param tm responsible for the work of the hulk with tiles
     */
    ThingD(TileMap tm) {
        super(tm);
    }

    public boolean isDead() { return dead; }

    /**
     * infliction of damage
     * @return damage
     */
    public int getDamage() { return damage; }

    /**
     * Setting the number of lives
     */
    public void setHealth() { health = 6; }

    public int getHealth() { return health; }

    public void hit (int damage) {
        if (dead)
            return;
        health -= damage;
        if(health <= 0)
            dead = true;
    }
}

