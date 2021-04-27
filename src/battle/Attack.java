package battle;



public class Attack {
	
	private int damage;
	private int mana;
	private boolean aoe;
	
	//Basic attack constructor
	public Attack(int strength) {
		 damage = (int) (strength * 1.5);
		 mana = 0;
		 aoe = false;
	}
	
	//Physical skill constructor   (int, double, int, boolean)
	public Attack(int strength, double multiplier, int mpCost, boolean aoe) {
		damage = (int) (strength * multiplier);
		mana = mpCost;
		this.aoe = aoe;
	}
	
	//Magic skill constructor	   (int, int, double, boolean)
	public Attack(int magic, int mpCost, double multiplier,  boolean aoe) {
		damage = (int) (magic * multiplier);
		mana = mpCost;
		this.aoe = aoe;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getMpCost() {
		return mana;
	}
	
	public boolean getAoe() {
		return aoe;
	}

}

//class AttackList {
//	//Player Attacks
//	private Attack basic = new Attack(Player.stats.getPAtk());
//	private Attack dab = new Attack(Player.stats.getMAtk(), 5, 2.0, true);
//	private Attack slap = new Attack(Player.stats.getPAtk(), 0.1, 100, false);
//	
//	//Enemy Attacks
//	
//}
