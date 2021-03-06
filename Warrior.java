/* Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca, Jeffrey Lin
 * APCS1 period 01
 * HW34 -- Ye Olde Role Playing Game, Expanded
 * 2016-11-22
 */

public class Warrior extends Player {
    public Warrior(String n) {
        super(n);
        health *= 1.00;
        strength *= 0.8;
        defense *= 0.9;
        attack *= 1.2;
        o_defense = defense;
        o_attack = attack;
    }

    public String about() {
        return "Warrior:\tSkilled in combat, warriors use expensive weaponry in conjunction\n\t\twith heavy armor, making them well-rounded physical combatants.\n";
    }
}

