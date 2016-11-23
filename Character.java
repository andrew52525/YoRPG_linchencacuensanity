/* Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca, Jeffrey Lin
 * APCS1 period 01
 * HW34 -- Ye Olde Role Playing Game, Unchained
 * 2016-11-22
 */

public abstract class Character {
    protected String name;
    protected int health;
    protected int strength;
    protected int defense;
    protected double attack;
    protected double stealth;
    protected int o_defense = defense;
    protected double o_attack = attack;

    public Character(String n) {
        name = n;
        health = 200;
        strength = 100;
        defense = 100;
        attack = 0.6;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public void lowerHP(int h) {
        health -= h;
    }

    public int attack(Character c) {
        int damage = (int) ((strength * attack) - c.getDefense());
        if ( damage < 0 ) {
            damage = 0;
        }

        c.lowerHP(damage);
        return damage;
    }

    public abstract void specialize();

    public abstract void normalize();

    public abstract String about();
}

