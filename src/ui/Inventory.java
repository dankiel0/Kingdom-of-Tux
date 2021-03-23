package ui;

import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Item> inv;
	
	public Inventory() {
		inv = new ArrayList<Item>();
	}
	
	public void addItems(Item items, int quant) {
		if(inv.size() < 25) {
			boolean inInventory = false;
			for(int i = 0; i < inv.size(); i++) {
				if(inv.get(i).getName().equals(items.getName())) {
					items.itemChange(quant);
					inInventory = true;
				}
			}
			if(!inInventory) {
				inv.add(items);
				items.itemChange(quant);
			}
		}
		else {
			System.out.println("Inventory is Full");
		}
	}
	
	public void removeItem(int index) {
		inv.remove(index);
	}
	
	public int inventorySize() {
		return inv.size();
	}
	
	public Item getItem(int index) {
		return inv.get(index);
	}
	
	public Equipment getEquipment(int index) {
		return (Equipment) inv.get(index);
	}
	
	public Consumables getConsumable(int index) {
		return (Consumables) inv.get(index);
	}
}
