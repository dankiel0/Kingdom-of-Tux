package ui;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import player.Player;
import rooms.Town;
import userInterface.BBbutton;
import userInterface.BBpanel;

public class UnequipUI {
	
	private BBpanel ueUI;

	private BBbutton unequipButton;
	
	public UnequipUI() {
		unequipButton = new BBbutton(0, 0, 60, 15, "Unequip");	
		unequipButton.onClick(KeyEvent.VK_Z, () -> {
			unequip();
		});
	}
		
	
	public void unequip() {
		int buttonIndex = Town.ui.getCharButtonIndex();
		int scooby = 0;
		switch(buttonIndex) {
			case 0: scooby = Town.ui.getCUI().hIndex();
				break;
			case 1: scooby = Town.ui.getCUI().cIndex();
				break;
			case 2: scooby = Town.ui.getCUI().lIndex();
				break;
			case 3: scooby = Town.ui.getCUI().bIndex();
				break;
			case 4: scooby = Town.ui.getCUI().wIndex();
			break;
		}
		Player.inv.addItems(Player.equipment.getEquipment(scooby), 1);
		Player.equipment.remove(Player.equipment.getEquipment(scooby));
		Town.ui.getCUI().updateCInv();
		Town.ui.getInvUI().updateInventory();
		Town.ui.ueButtonClick();
		
	}
	
	public void changePos(int x, int y) {
		ueUI = new BBpanel(x, y, 60, 15, unequipButton);
	}
	
	public void update() {
		ueUI.update();
	}
	
	public void render(Graphics2D graphics) {
		ueUI.render(graphics);
	}

}
