/* Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca, Jeffrey Lin
 * APCS1 period 01
 * HW34 -- Ye Olde Role Playing Game, Unchained
 * 2016-11-22
 */

public class Monster extends Character {
    public Monster() {
        super();
        health *= 0.5;
        strength *= (Math.random() + 0.3);
        defense *= 0.4;
        attack *= (1.5 + Math.random());
    }

    public void normalize() { }
    public void specialize() { }

    public String about() {
        return "Monster:\tA hideous creature, monsters are deformed humans who seek justice\n\t\tafter being wronged.\n";
    }
}

