package ui;

import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Item> inv;
	
	public Inventory() {
		inv = new ArrayList<Item>();
		
	}
	
	public void addItems(Item items, int quant) {
		inv.add(items);
		items.itemChange(quant);
	}
	
	public int inventorySize() {
		return inv.size();
	}
	
	public Item getItem(int index) {
		return inv.get(index);
	}
}
