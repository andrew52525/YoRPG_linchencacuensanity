/* Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca, Jeffrey Lin
 * APCS1 period 01
 * HW34 -- Ye Olde Role Playing Game, Unchained
 * 2016-11-22
 */

public class Cleric extends Character {
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

        c.lowerHP(damage);
        health += (damage * Math.random() * Math.random());
        return damage;
    }

    public void normalize(){
        defense = o_defense;
        attack = o_attack;
    }

    public void specialize() {
        double rand = (0.5 + (Math.random() * 0.4));
        defense *= rand;
        attack /= rand;
    }

    public String about() {
        return "Cleric:\t\tMagical healing abilities add a sliver of health for every bit of\n\t\tdamage they deal.\n";
    }
}

