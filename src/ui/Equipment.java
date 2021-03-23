package ui;

import game.spritesheet.SpriteSheet;
import player.Player;

public class Equipment extends Item {
	
	private int maxHP;
	private int patk;
	private int matk;
	private int pdef;
	private int mdef;
	private int spd;
	private int maxMP;
	private String itemType;
	
	//Creates an armor piece - There will be 4 pieces of armor: Helmet, Chestpiece, Legwear, Boots
	public Equipment(String itemName, String description, int itemQuantity, int itemWorth, SpriteSheet icon, int spriteI, int maxhealth, int physatk, int magatk, int physdef, int magdef, int maxmp, int speed, String itemtype) {
		super(itemName, description, itemQuantity, itemWorth, icon, spriteI);
		maxHP = maxhealth;
		patk = physatk;
		matk = magatk;
		pdef = physdef;
		mdef = magdef;
		maxMP = maxmp;
		spd = speed;
		itemType = itemtype;
	}
	
	//the itemType will be used to identify which type of equipment the item is so as to prevent equipping multiple of one type of item.  For example, the player
	//shouldn't be able to equip 5 helmets or 3 weapons.  The item types as of now will be: Helmet, Chestpiece, Legwear, Boots, and Weapon
	
	public String getItemType() {
		return itemType;
	}
	public boolean isEquipment() {
		return true;
	}
	
	public void wearEquipment() {
		System.out.println("Success");
		Player.stats.changeMaxHP(maxHP);
		Player.stats.changeMAtk(matk);
		Player.stats.changeMDef(mdef);
		Player.stats.changeMaxMP(maxMP);
		Player.stats.changePAtk(patk);
		Player.stats.changePDef(pdef);
		Player.stats.changeSpd(spd);
	}
	public void removeEquipment() {
		Player.stats.changeMaxHP(-maxHP);
		Player.stats.changeMAtk(-matk);
		Player.stats.changeMDef(-mdef);
		Player.stats.changeMaxMP(-maxMP);
		Player.stats.changePAtk(-patk);
		Player.stats.changePDef(-pdef);
		Player.stats.changeSpd(-spd);
		if(Player.stats.getHp() > Player.stats.getMaxHP()) {
			Player.stats.changeHp(-(Player.stats.getHp() - Player.stats.getMaxHP()));
		}
	}
}
