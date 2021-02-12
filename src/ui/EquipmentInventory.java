package ui;

import java.util.ArrayList;

public class EquipmentInventory {
	
	private ArrayList<Equipment> equipment;
	
	public EquipmentInventory() {
		equipment = new ArrayList<Equipment>();
	}
	
	public int returnSize() {
		return equipment.size();
	}
	
	public Equipment getEquipment(int index) {
		return equipment.get(index);
	}
	
	public void wear(Equipment equip) {
		equipment.add(equip);
		equip.wearEquipment();
	}
	
	public void remove(Equipment equip) {
		equipment.remove(equip);
		equip.removeEquipment();
	}

}
