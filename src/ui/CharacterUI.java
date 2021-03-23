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
	private int helmetIndex;
	private int chestpieceIndex;
	private int legwearIndex;
	private int bootIndex;
	private int weaponIndex;
	
	public CharacterUI() {
		panel = new BBpanel(60, 30, 360, 360, new BBlabel(0, 0, 360, 50, "Character"));
		this.updateCInv();
	}
	
	public void updateCInv() {
		cells.clear();
		buttons.clearButtons();
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
						helmetIndex = i;
						break;
					case "Chestpiece":
						System.out.println("Chestpiece Equipped");
						cells.remove(1);
						cells.add(1, new InventoryCell(99, 128, 33, 33, Player.equipment.getEquipment(i)));
						System.out.println(cells.get(1).getEquipment().getName());
						chestpieceIndex = i;
						break;
					case "Legwear":
						cells.remove(2);
						cells.add(2, new InventoryCell(99, 190, 33, 33, Player.equipment.getEquipment(i)));
						legwearIndex = i;
						break;
					case "Boots":
						cells.remove(3);
						cells.add(3, new InventoryCell(99, 152, 33, 33, Player.equipment.getEquipment(i)));
						bootIndex = i;
						break;
					case "Weapon":
						cells.remove(4);
						cells.add(4, new InventoryCell(99, 214, 33, 33, Player.equipment.getEquipment(i)));
						weaponIndex = i;
						break;
				
				}
			}
		}
		
		panel = new BBpanel(60, 30, 360, 360, new BBlabel(0, 0, 360, 50, "Character"), new BBlabel(270, 60, 50, 50, "Health: " + Player.stats.getHp() + "/" + Player.stats.getMaxHP()), new BBlabel(270, 90, 50, 50,"Physical Attack: " + Player.stats.getPAtk()), new BBlabel(270, 120, 50, 50,"Magic Attack: " + Player.stats.getMAtk()), new BBlabel(270, 150, 50, 50,"Physical Defense: " + Player.stats.getPDef()), new BBlabel(270, 180, 50, 50,"Magic Defense: " + Player.stats.getMDef()), new BBlabel(270, 210, 50, 50,"MP: " + Player.stats.getMP() + "/" + Player.stats.getMaxMP()), new BBlabel(270, 240, 50, 50,"Speed: " + Player.stats.getSpd()));
		
//			new BBlabel(180, 30, 270, 330, "Health: " + Player.stats.getHp());
//			new BBlabel(180, 60, 270, 330,"Physical Attack: " + Player.stats.getPAtk());
//			new BBlabel(180, 90, 270, 330,"Magic Attack: " + Player.stats.getMAtk());
//			new BBlabel(180, 120, 270, 330,"Physical Defense: " + Player.stats.getPDef());
//			new BBlabel(180, 150, 270, 330,"Magic Defense: " + Player.stats.getMDef());
//			new BBlabel(180, 180, 270, 330,"MP: " + Player.stats.getMP());
//			new BBlabel(180, 210, 270, 330,"Speed: " + Player.stats.getSpd());
			
	}
	
	public int hIndex() {
		return helmetIndex;
	}
	public int cIndex() {
		return chestpieceIndex;
	}
	public int lIndex() {
		return legwearIndex;
	}
	public int bIndex() {
		return bootIndex;
	}
	public int wIndex() {
		return weaponIndex;
	}
	
	public ButtonList getButtonList() {
		return buttons;
	}

	public ArrayList<InventoryCell> getCellList() {
		return cells;
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
			for(int i = 0; i < cells.size(); i++) {
				if(cells.get(i).getEquipment() != null) {
					System.out.println("DFJ:OL (*@#R(PHFC(");
					cells.get(i).getEquipment().getIconPath().render(graphics, cells.get(i).getX()+1, cells.get(i).getY()+1, cells.get(i).getEquipment().getSpriteIndex());
				}
			}
		}
	}
	
}
