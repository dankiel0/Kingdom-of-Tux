package ui;

import game.spritesheet.SpriteSheet;

public class Item {
	
	private String name;
	private String desc;
	private int quantity;
	private int worth;
	private SpriteSheet iconPath;
	private int spriteIndex;

	public Item(String itemName, String description, int itemQuantity, int itemWorth, SpriteSheet icon, int spriteI) {
		name = itemName;
		desc = description;
		quantity = itemQuantity;
		worth = itemWorth;
		iconPath = icon;
		spriteIndex = spriteI;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public int getQuant() {
		return quantity;
	}
	
	public int getWorth() {
		return worth;
	}
	
	public SpriteSheet getIconPath() {
		return iconPath;
	}
	
	public int getSpriteIndex() {
		return spriteIndex;
	}
	
	// Adds or remove items
	public void itemChange(int quant) {
		if(quant > 0) {
			quantity += quant;
		}
		else {
			if(quantity > 0) {
				quantity -= quant;
			}
		}
	}
	
}
