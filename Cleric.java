/* Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca, Jeffrey Lin
 * APCS1 period 01
 * HW34 -- Ye Olde Role Playing Game, Unchained
 * 2016-11-22
 */

public class Cleric extends Player {
    public Cleric(String n) {
        super(n);
        health *= 0.9;
        strength *= 0.8;
        defense *= 1.0;
        attack *= 1.1;
        stealth *= 1.1;
        o_defense = defense;
        o_attack = attack;
    }

    @Override
    public int attack(Character c) {
        int damage = (int) ((strength * attack) - c.getDefense());
        if ( damage < 0 ) {
            damage = 0;
        }

        if ( damage > c.getHealth() ) {
            damage = c.getHealth();
        }

        // clerics heal a little
        health += (damage * Math.random() * Math.random());

        moves++;
        damage_dealt += damage;
        c.lowerHP(damage);
        return damage;
    }

    public String about() {
        return "Cleric:\t\tMagical healing abilities add a sliver of health for every bit of\n\t\tdamage they deal.\n";
    }
}

