package Entity;

import TileMap.TileMap;

public abstract class ThingG extends MapObject{

    int health;
    int maxHealth;
    private boolean dead;
    int damage;

    /**
     * parameters of the golds with tiles
     * @param tm responsible for the work of the hulk with tiles
     */
    ThingG(TileMap tm) {
        super(tm);
    }

    public boolean isDead() { return dead; }

    /**
     * infliction of damage
     * @return damage
     */
    public int getDamage() { return damage; }

    /**
     * is responsible for the attack
     * @param damage infliction of damage
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

