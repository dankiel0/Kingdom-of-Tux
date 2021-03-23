package rooms;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import player.Player;
import userInterface.BBbutton;
import userInterface.BBpanel;

public class IntUI {
	
	private BBpanel intUI;
	private BBbutton useButton;
	private BBbutton equipButton;
	private BBbutton dropButton;
	
	
	public IntUI() {
		useButton = new BBbutton(0, 0, 60, 15, "Use");
		equipButton = new BBbutton(0, 15, 60, 15, "Equip");
		dropButton = new BBbutton(0, 30, 60, 15, "Drop");
		
		useButton.onClick(KeyEvent.VK_Z, () -> {
			if(Player.inv.getItem(Town.ui.getInvButtonIndex()).isConsumable()) {
				Player.inv.getConsumable(Town.ui.getInvButtonIndex()).drink();
				removeItem();
				Town.ui.updateCUI();
				System.out.println("Potion Consumed");
			}
			else {
				System.out.println("Cannot Consume");
			}
		});
		equipButton.onClick(KeyEvent.VK_Z, () -> {
			if(Player.inv.getItem(Town.ui.getInvButtonIndex()).isEquipment()) {
				Player.equipment.wear(Player.inv.getEquipment(Town.ui.getInvButtonIndex()));
				Town.ui.updateCUI();
				removeItem();
				System.out.println("Equipped");
			}
			else {
				System.out.println("Cannot Equip");
			}
			
//			Player.equipment.wear(equip);
		});
		dropButton.onClick(KeyEvent.VK_Z, () -> {
			removeItem();
		});
	}
	
	public void removeItem() {
		int buttonIndex = Town.ui.getInvButtonIndex();
		if(buttonIndex == Player.inv.inventorySize()-1 && buttonIndex != 0) {
			Town.ui.changeInvButtonIndex();
		}
		Player.inv.getItem(buttonIndex).itemChange(-1);
		if(Player.inv.getItem(buttonIndex).getQuant() == 0) {
			Player.inv.removeItem(buttonIndex);	
		}
		
		Town.ui.intButtonClick();
		System.out.println(Player.inv.inventorySize());
		for(int i = 0; i < Player.inv.inventorySize(); i++) {
			System.out.println(Player.inv.getItem(i).isEquipment());
			System.out.println(Player.inv.getItem(i).getName());
		}
	};
	
	public void changePos(int x, int y) {
		intUI = new BBpanel(x, y, 60, 45, useButton, equipButton, dropButton);
	}
	
	public void update() {
		intUI.update();
	}
	
	public void render(Graphics2D graphics) {
		intUI.render(graphics);
	}
	
	
}
