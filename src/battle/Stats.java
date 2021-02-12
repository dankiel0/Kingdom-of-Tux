package battle;

public class Stats {

	/*
	 * HP determines health
	 * PAtk and MAtk determine physical and magic damage respectively
	 * PDef and MDef determine physical and magic resistance respectively
	 * MP used for casting magic and skills
	 * Speed determines who attacks first
	 */
	
	private int hp;
	private int patk;
	private int matk;
	private int pdef;
	private int mdef;
	private int mp;
	private int spd;
	//XP and level stuff for player and party members, useless for enemies and stuff
	private int xp = 0;
	private int level = 1;
	private int lvlupXP = 500;
	
	
	public Stats(int health, int physatk, int magatk, int physdef, int magdef, int magpoints, int speed) {
		hp = health;
		patk = physatk;
		matk = magatk;
		pdef = physdef;
		mdef = magdef;
		mp = magpoints;
		spd = speed;
	}
	
	// These methods are to get the individual stats
	public int getHp() {
		return hp;
	}
	public int getPAtk() {
		return patk;
	}
	public int getMAtk() {
		return matk;
	}
	public int getPDef() {
		return pdef;
	}
	public int getMDef() {
		return mdef;
	}
	public int getMP() {
		return mp;
	}
	public int getSpd() {
		return spd;
	}
	//These methods are to change individual stats -> mainly for equipment purposes
	//Positive value to add stat points, negative value to remove stat points
	public void changeHp(int amount) {
		hp += amount;
	}
	public void changePAtk(int amount) {
		patk += amount;
	}
	public void changeMAtk(int amount) {
		matk += amount;
	}
	public void changePDef(int amount) {
		pdef += amount;
	}
	public void changeMDef(int amount) {
		mdef += amount;
	}
	public void changeMP(int amount) {
		mp += amount;
	}
	public void changeSpd(int amount) {
		spd += amount;
	}
	
	public void addXP(int amount) {
		xp += amount;
		//XP is added.  If it passes a certain threshold, the player levels up and the threshold for the next level increases
		if(xp >= lvlupXP) {
			lvlUp();
			lvlupXP *= 1.5;
		}
	}
	
	public void lvlUp() {
		level += 1;
		// This increases all of the player's stats by some number between 1-3 inclusive; This could probably be optimized
		hp += (int)(Math.random() * (3) + 1);
		patk += (int)(Math.random() * (3) + 1);
		matk += (int)(Math.random() * (3) + 1);
		pdef += (int)(Math.random() * (3) + 1);
		mdef += (int)(Math.random() * (3) + 1);
		mp += (int)(Math.random() * (3) + 1);
		spd += (int)(Math.random() * (3) + 1);
	}
	
}
