/* Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca, Jeffrey Lin
 * APCS1 period 01
 * HW34 -- Ye Olde Role Playing Game, Unchained
 * 2016-11-22
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

    public void specialize() {
        double rand = (0.5 + (Math.random() * 0.4));
        defense *= rand;
        attack /= rand;
    }

    public String about() {
        return "Mage:\t\tWielding powerful spells, mages can level entire cities, but are\n\t\tphysically weak and practically useless without their spellbook.\n";
    }
}

