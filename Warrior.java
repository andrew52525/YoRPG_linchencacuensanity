/* Jeffrey Lin
 * Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca
 * APCS1 period 01
 * HW32 -- Ye Olde Role Playing Game, Expanded
 * 2016-11-18
 */

public class Warrior extends Character {
    public Warrior(String n) {
        super(n);
        health *= 1.00;
        strength *= 0.8;
        defense *= 0.9;
        attack *= 1.2;
        o_defense = defense;
        o_attack = attack;
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

