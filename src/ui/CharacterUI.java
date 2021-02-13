package ui;

import java.awt.Graphics2D;
import java.util.ArrayList;

import player.Player;
import userInterface.BBlabel;
import userInterface.BBpanel;

public class CharacterUI {
	//Contains equipment as well as stats

	private BBpanel panel;
	private InventoryCell equipCell;
	private Button equipButton;
	private ArrayList<InventoryCell> cells = new ArrayList<InventoryCell>();
	private ButtonList buttons = new ButtonList();
	
	public CharacterUI() {
		panel = new BBpanel(60, 30, 360, 360, new BBlabel(0, 0, 360, 50, "Character"));
		this.updateCInv();
	}
	
	public void updateCInv() {
		cells.clear();
		for(int i = 0; i < 5; i++) {
			equipButton = new Button(99, 66+(i*62), 33, 33);
			equipCell = new InventoryCell(99, 66+(i*62), 33, 33);
			cells.add(equipCell);
			buttons.addButton(equipButton);
			}
		
		if(Player.equipment.returnSize() > 0) {
			for(int i = 0; i < Player.equipment.returnSize(); i++) {
				switch(Player.equipment.getEquipment(i).getItemType()) {
					case "Helmet": 
						cells.remove(0);
						cells.add(0, new InventoryCell(99, 66, 33, 33, Player.equipment.getEquipment(i)));
						break;
					case "Chestpiece":
						cells.remove(1);
						cells.add(1, new InventoryCell(99, 128, 33, 33, Player.equipment.getEquipment(i)));
						break;
					case "Legwear":
						cells.remove(2);
						cells.add(2, new InventoryCell(99, 190, 33, 33, Player.equipment.getEquipment(i)));
						break;
					case "Boots":
						cells.remove(3);
						cells.add(3, new InventoryCell(99, 152, 33, 33, Player.equipment.getEquipment(i)));
						break;
					case "Weapon":
						cells.remove(4);
						cells.add(4, new InventoryCell(99, 214, 33, 33, Player.equipment.getEquipment(i)));
						break;
				
				}
			}
		}
			
	}
	
	public void update() {
		panel.update();
		buttons.update();
	}
	
	public void render(Graphics2D graphics) {
		panel.render(graphics);
		for(int i = 0; i < cells.size(); i++) {
			cells.get(i).render(graphics);
			buttons.render(graphics);
		}
		if(Player.equipment.returnSize() > 0) {
			for(int i = 0; i < Player.equipment.returnSize(); i++) {
				cells.get(i).getEquipment().getIconPath().render(graphics, cells.get(i).getX()+1, cells.get(i).getY()+1, cells.get(i).getEquipment().getSpriteIndex());
			}
		}
	}
	
}
