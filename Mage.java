/* Team Lin(ChenCuen)-Sanity -- Andrew Chen, Grace Cuenca, Jeffrey Lin
 * APCS1 period 01
 * HW34 -- Ye Olde Role Playing Game, Unchained
 * 2016-11-22
 */

public class Mage extends Player {
	private int mana = 10;
	
    public Mage(String n) {
        super(n);
        health *= 1.2;
        strength *= 1.3;
        defense *= 0.4;
        attack *= 0.9;
        o_defense = defense;
        o_attack = attack;
    }

    public String about() {
        return "Mage:\t\tWielding powerful spells, mages can level entire cities, but are\n\t\tphysically weak and practically useless without their spellbook.\n";
    }

	@Override
	public void specialize() {
		if (mana < 5){
			System.out.println ("\nYou need to rest more to recover mana before using your next spell. You attack normally.");
			normalize();
		}
		else{
			attack = 3.0; //don't change this number lol
			mana -= 5;
		}
    }
}

