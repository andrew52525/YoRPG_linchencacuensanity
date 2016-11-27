public abstract class Player extends Character{
	protected String name;
    protected int o_defense = defense;
    protected double o_attack = attack;

	
	public Player(String n){
		super();
		name = n;
	}
		
    public String getName() {
        return name;
    }
	public double getAttack() { 
		return attack;
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