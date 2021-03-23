package ui;

import game.spritesheet.SpriteSheet;
import player.Player;

public class Consumables extends Item {
	
	private int hpRecover;
	private int mpRecover;
	
	public Consumables(String itemName, String description, int itemQuantity, int itemWorth, SpriteSheet icon, int spriteI, int healthRecovery, int mpRecovery) {
		super(itemName, description, itemQuantity, itemWorth, icon, spriteI);
		hpRecover = healthRecovery;
		mpRecover = mpRecovery;
	}
	
	public void drink() {
		if(Player.stats.getHp() + hpRecover >= Player.stats.getMaxHP()) {
			Player.stats.changeHp(Player.stats.getMaxHP()-Player.stats.getHp());
		}
		else {
			Player.stats.changeHp(hpRecover);
		}
		if(Player.stats.getMP() + mpRecover >= Player.stats.getMaxMP()) {
			Player.stats.changeMP(Player.stats.getMaxMP()-Player.stats.getMP());
		}
		else {
			Player.stats.changeMP(mpRecover);
		}
	}
	
	public boolean isConsumable() {
		return true;
	}

}
