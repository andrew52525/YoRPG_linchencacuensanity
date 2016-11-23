/* Jeffrey Lin
 * Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca
 * APCS1 period 01
 * HW32 -- Ye Olde Role Playing Game, Expanded
 * 2016-11-18
 */

public class Barbarian extends Character {
	public Barbarian(String n) {
		super(n);
		health *= 1.5;
		strength *= 1.3;
		defense *= 0.7;
		attack *= 1.1;
		stealth *= 0.5;
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

