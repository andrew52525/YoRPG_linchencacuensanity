/* Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca, Jeffrey Lin
 * APCS1 period 01
 * HW34 -- Ye Olde Role Playing Game, Unchained
 * 2016-11-22
 */

public class Barbarian extends Player {
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

    public String about() {
        return "Barbarian:\tRuthless tyrants that have enormous amounts of raw strength and\n\t\thealth, but lack the ability to dodge attacks.\n";
    }
}

