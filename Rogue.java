/* Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca, Jeffrey Lin
 * APCS1 period 01
 * HW34 -- Ye Olde Role Playing Game, Unchained
 * 2016-11-22
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

        // maximum of 7 attacks in one turn
        for ( int i = 0; i < ((Math.random() * 6) + 1); i++ ) {
            int damage = (int) ((strength * attack) - c.getDefense());
            if ( damage < 0 ) {
                damage = 0;
            }

            total += damage;
        }

        if ( total > c.getHealth() ) {
            total = c.getHealth();
        }

        moves++;
        damage_dealt += total;
        c.lowerHP(total);
        return total;
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
        return "Rogue:\t\tIncredibly stealthy, rogues focus on dodging attacks rather than\n\t\twithstanding damage. Can strike multiple times in one turn.\n";
    }
}

