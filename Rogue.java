/* Jeffrey Lin
 * Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca
 * APCS1 period 01
 * HW32 -- Ye Olde Role Playing Game, Expanded
 * 2016-11-18
 */

public class Rogue extends Character {
    public Rogue(String n) {
        super(n);
        health *= 0.5;
        strength *= 0.9;
        defense *= 0.7;
        attack *= 0.8;
        o_defense = defense;
        o_attack = attack;
    }

    @Override
    public int attack(Character c) {
        int total = 0;

        for ( int i = 0; i < ((Math.random() * 6) + 1); i++ ) {
            int damage = (int) ((strength * attack) - c.getDefense());
            if ( damage < 0 ) {
                damage = 0;
            }

            c.lowerHP(damage);
            total += damage;
        }

        return total;
    }

    public void normalize(){
	defense = o_defense;
	attack = o_attack;
    }
}

