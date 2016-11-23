/* Jeffrey Lin
 * Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca
 * APCS1 period 01
 * HW34 -- Ye Olde Role Playing Game, Unchained
 * 2016-11-18
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
 
    public void specialize() {
        double rand = (0.5 + (Math.random() * 0.4));
        defense *= rand;
        attack /= rand;
    }

    public abstract void normalize();

    public static final String about() {
        return "Warrior:\tSkilled in combat, warriors use expensive weaponry in conjunction\n\t\twith heavy armor, making them well-rounded physical combatants.\n"
            + "Monster:\tA hideous creature, monsters are deformed humans who seek justice\n\t\tafter being wronged.\n"
            + "Mage:\t\tWielding powerful spells, mages can level entire cities, but are\n\t\tphysically weak and practically useless without their spellbook.\n"
            + "Rogue:\t\tIncredibly stealthy, rogues focus on dodging attacks rather than\n\t\twithstanding damage. Can strike multiple times in one turn.\n"
            + "Barbarian:\tRuthless tyrants that have enormous amounts of raw strength and\n\t\thealth, but lack the ability to dodge attacks.\n"
            + "Cleric:\t\tMagical healing abilities add a sliver of health for every bit of\n\t\tdamage they deal.\n";
    }
}

