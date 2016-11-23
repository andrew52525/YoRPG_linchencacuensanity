/* Jeffrey Lin
 * Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca
 * APCS1 period 01
 * HW32 -- Ye Olde Role Playing Game, Expanded
 * 2016-11-18
 */

public class Monster extends Character {
    public Monster() {
        super("Monster");
        health *= 0.5;
        strength *= (Math.random() + 0.3);
        defense *= 0.4;
        attack *= (1.5 + Math.random());
    }

    public void normalize(){
	defense = o_defense;
	attack = o_attack;
    }
}

