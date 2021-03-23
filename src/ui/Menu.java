package ui;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import game.input.Keyboard;
import player.Player;
import rooms.IntUI;
import userInterface.BBbutton;
import userInterface.BBlabel;
import userInterface.BBpanel;

public class Menu {
	private BBpanel panel;
	private boolean panelVisible;
	
	private InvUi invUI = new InvUi(); 
	private boolean invVisible = false;
	
	private CharacterUI charUI = new CharacterUI();
	private boolean charVisible = false;
	
	private IntUI intUI = new IntUI();
	private boolean intVisible = false;
	
	private UnequipUI ueUI = new UnequipUI();
	private boolean ueVisible = false;
	
	
	public Menu() {
		// inits ui.
		BBbutton button1 = new BBbutton(0, 50, 150, 50, "Inventory");
		
		button1.onClick(KeyEvent.VK_Z, () -> {
			invVisible = true;
		});
		
		BBbutton button2 = new BBbutton(0, 110, 150, 50, "Character");
		
		button2.onClick(KeyEvent.VK_Z, () -> {
			charVisible = true;
		});
		
		panel = new BBpanel(0, 240, 480, 240, new BBlabel(0, 0, 150, 50, "Menu"), button1, button2);
		
		
		
		//temporary placement for testing
		if(Player.inv.inventorySize() == 0) {
			Player.inv.addItems(ItemList.A, 2);
			Player.inv.addItems(ItemList.B, 1);
			Player.inv.addItems(ItemList.C, 1);
			Player.inv.addItems(ItemList.D, 1);
			Player.inv.addItems(ItemList.E, 1);
			Player.inv.addItems(ItemList.F, 1);
			Player.inv.addItems(ItemList.G, 1);
			Player.inv.addItems(ItemList.H, 1);
			Player.inv.addItems(ItemList.I, 1);
			Player.inv.addItems(ItemList.J, 1);
			Player.inv.addItems(ItemList.K, 1);
			Player.inv.addItems(ItemList.L, 1);
			Player.inv.addItems(ItemList.J, 1);
		}
		
	}
	
	public void update() {
		
		// if the space key is clicked while the character status is opened, it'll close the character status and reopen the menu
		if(Keyboard.keyClicked(KeyEvent.VK_SPACE) && charVisible) {
			charVisible = !charVisible;
			panelVisible = !panelVisible;
			
		}
		// if the space key is clicked while the unequip menu is opened, it'll close the menu
		else if(Keyboard.keyClicked(KeyEvent.VK_SPACE) && ueVisible) {
			 ueVisible = false;
			 charVisible = true;
		}
		// if the space key is clicked while the interaction menu is opened, it'll close the menu
		else if(Keyboard.keyClicked(KeyEvent.VK_SPACE) && intVisible) {
			intVisible = false;
			invVisible = true;
		}
		// if the space key is clicked while the inventory is opened, it'll close the inventory and reopen the menu
		else if(Keyboard.keyClicked(KeyEvent.VK_SPACE) && invVisible) {
			invVisible = !invVisible;
			panelVisible = !panelVisible;
		}
		// if the space key is clicked while inventory is closed, hide or show the panel.
		else if(Keyboard.keyClicked(KeyEvent.VK_SPACE))
			panelVisible = !panelVisible;
		
		// if the panel is visible, update it.
		if(panelVisible)
			panel.update();
		
		// if the inventory is visible, update it.
		if(invVisible) {
			invUI.update();
			if(Player.inv.inventorySize() > 0) {
				intUI.changePos((int)invUI.getCellList().get(invUI.getButtonList().buttonIndex()).getX() + 35, (int)invUI.getCellList().get(invUI.getButtonList().buttonIndex()).getY());
				invUI.getButtonList().getButton(invUI.getButtonList().buttonIndex()).onClick(KeyEvent.VK_E, () -> {intVisible = true;});	
			}
		}
		// if the character status is visible, update it.
		if(charVisible) {
			charUI.update();
			if(charUI.getCellList().get(charUI.getButtonList().buttonIndex()).getEquipment() != null) {
				ueUI.changePos((int)charUI.getCellList().get(charUI.getButtonList().buttonIndex()).getX() + 35, (int)charUI.getCellList().get(charUI.getButtonList().buttonIndex()).getY());
				charUI.getButtonList().getButton(charUI.getButtonList().buttonIndex()).onClick(KeyEvent.VK_E, () -> {ueVisible = true;});	
			}
		}
		if(intVisible) {
			intUI.update();
		}
		if(ueVisible) {
			ueUI.update();
		}
		
		
	}
	
	public void render(Graphics2D graphics) {
		if(panelVisible)
			panel.render(graphics);
		
		// closes the menu and renders the inventory.
		if(invVisible) {
			panelVisible = false;
			invUI.render(graphics);
		}
		// closes the menu and renders the character stats
		if(charVisible) {
			panelVisible = false;
			charUI.render(graphics);
		}
		if(intVisible) {
			invVisible = false;
			invUI.render(graphics);
			intUI.render(graphics);
		}
		if(ueVisible) {
			charVisible = false;
			charUI.render(graphics);
			ueUI.render(graphics);
		}
	}
	
	public void updateCUI() {
		charUI.updateCInv();
	}
	
	public void intButtonClick() {
		intVisible = false;
		invUI.updateInventory();
		invVisible = true;
	}
	
	public void ueButtonClick() {
		ueVisible = false;
		charVisible = true;
	}
	
	public CharacterUI getCUI() {
		return charUI;
	}
	
	public InvUi getInvUI() {
		return invUI;
	}

	
	public void changeInvButtonIndex() {
		invUI.getButtonList().changeButtonIndex(-1);
	}

	public int getInvButtonIndex() {
		return invUI.getButtonList().buttonIndex();
	}
	
	public int getCharButtonIndex() {
		return charUI.getButtonList().buttonIndex();
	}
	
	public boolean isIntVisible() {
		return intVisible;
	}
	
	public boolean isCharVisible() {
		return charVisible;
	}
	
	public boolean isMenuVisible() {
		return panelVisible;
	}
	public boolean isInvVisible() {
		return invVisible;
	}
	public boolean isUeVisible() {
		return ueVisible;
	}
}
