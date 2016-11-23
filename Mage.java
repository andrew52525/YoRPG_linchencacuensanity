/* Jeffrey Lin
 * Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca
 * APCS1 period 01
 * HW32 -- Ye Olde Role Playing Game, Expanded
 * 2016-11-18
 */

public class Mage extends Character {
    public Mage(String n) {
        super(n);
        health *= 1.2;
        strength *= 1.3;
        defense *= 0.6;
        attack *= 1.1;
        o_defense = defense;
        o_attack = attack;
    }

    public void normalize(){
	defense = o_defense;
	attack = o_attack;
    }
}

