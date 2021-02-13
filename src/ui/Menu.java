package ui;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import game.input.Keyboard;
import player.Player;
import userInterface.BBbutton;
import userInterface.BBlabel;
import userInterface.BBpanel;

public class Menu {
	private BBpanel panel;
	private boolean panelVisible;
	private boolean invVisible = false;
	private boolean charVisible = false;
	private InvUi invUI = new InvUi(); 
	private CharacterUI charUI = new CharacterUI();
	private boolean intKey = false;
	
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
		Player.inv.addItems(ItemList.A, 1);
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
	}
	
	public void update() {
		if(Keyboard.keyClicked(KeyEvent.VK_SPACE) && charVisible) {
			charVisible = !charVisible;
			panelVisible = !panelVisible;
			
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
		if(invVisible && intKey == false) {
			invUI.update();
		}
		
		if(charVisible) {
			charUI.update();
		}
		
		
	}
	
	public void key() {
		intKey = !intKey;
	}
	
	public void render(Graphics2D graphics) {
		if(panelVisible)
			panel.render(graphics);
		
		// closes the menu and renders the inventory.
		if(invVisible) {
			panelVisible = false;
			invUI.render(graphics);
		}
		if(charVisible) {
			panelVisible = false;
			invVisible = false;
			charUI.render(graphics);
		}
		if(intKey) {
			
		}
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
}
