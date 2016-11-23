/* Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca, Jeffrey Lin
 * APCS1 period 01
 * HW34 -- Ye Olde Role Playing Game, Expanded
 * 2016-11-22
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

    public String about() {
        return "Warrior:\tSkilled in combat, warriors use expensive weaponry in conjunction\n\t\twith heavy armor, making them well-rounded physical combatants.\n";
    }
}

