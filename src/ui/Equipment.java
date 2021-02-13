package ui;

import game.spritesheet.SpriteSheet;
import player.Player;

public class Equipment extends Item {
	
	private int hp;
	private int patk;
	private int matk;
	private int pdef;
	private int mdef;
	private int mp;
	private int spd;
	private String itemType;
	
	//Creates an armor piece - There will be 4 pieces of armor: Helmet, Chestpiece, Legwear, Boots
	public Equipment(String itemName, String description, int itemQuantity, int itemWorth, SpriteSheet icon, int spriteI, int health, int physatk, int magatk, int physdef, int magdef, int mpts, int speed, String itemtype) {
		super(itemName, description, itemQuantity, itemWorth, icon, spriteI);
		hp = health;
		patk = physatk;
		matk = magatk;
		pdef = physdef;
		mdef = magdef;
		mp = mpts;
		spd = speed;
		itemType = itemtype;
	}
	
	//the itemType will be used to identify which type of equipment the item is so as to prevent equipping multiple of one type of item.  For example, the player
	//shouldn't be able to equip 5 helmets or 3 weapons.  The item types as of now will be: Helmet, Chestpiece, Legwear, Boots, and Weapon
	
	public String getItemType() {
		return itemType;
	}
	
	public void wearEquipment() {
		Player.stats.changeHp(hp);
		Player.stats.changeMAtk(matk);
		Player.stats.changeMDef(mdef);
		Player.stats.changeMP(mp);
		Player.stats.changePAtk(patk);
		Player.stats.changePDef(pdef);
		Player.stats.changeSpd(spd);
	}
	public void removeEquipment() {
		Player.stats.changeHp(-hp);
		Player.stats.changeMAtk(-matk);
		Player.stats.changeMDef(-mdef);
		Player.stats.changeMP(-mp);
		Player.stats.changePAtk(-patk);
		Player.stats.changePDef(-pdef);
		Player.stats.changeSpd(-spd);
	}
}
