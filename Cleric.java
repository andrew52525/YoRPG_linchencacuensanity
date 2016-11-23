/* Jeffrey Lin
 * Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca
 * APCS1 period 01
 * HW32 -- Ye Olde Role Playing Game, Expanded
 * 2016-11-18
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
}

