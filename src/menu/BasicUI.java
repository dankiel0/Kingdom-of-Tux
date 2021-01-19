package menu;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import game.input.Keyboard;
import player.Player;
import userInterface.BBbutton;
import userInterface.BBlabel;
import userInterface.BBpanel;

public class BasicUI {
	
	private BBpanel panel;
	private boolean panelVisible;
	
	public BasicUI() {
		// inits ui.
		BBbutton button1 = new BBbutton(0, 100, 150, 50, "Inventory");
		
		button1.onClick(KeyEvent.VK_Z, () -> {
			System.out.println("Button 1 has been clicked!");
		});
		 
		BBbutton button2 = new BBbutton(0, 200, 150, 50, "Save");
		
		button2.onClick(KeyEvent.VK_Z, () -> {
			System.out.println("Button 2 has been clicked!");
		});
		
		panel = new BBpanel(0, 320, 640, 320, new BBlabel(0, 0, 150, 50, "Menu"), button1, button2);
	}
	
	public void update(double elapsedTime) {
			
		// if the panel is invisible, update the player.
		if(!panelVisible)
			Player.player.update(elapsedTime);
			
		
		// if the space key is clicked, hide or show the panel.
		if(Keyboard.keyClicked(KeyEvent.VK_SPACE))
			panelVisible = !panelVisible;
		
		// if the panel is visible, update it.
		if(panelVisible)
			panel.update();
			
		}
	
	public void render(Graphics2D graphics) {
		if(panelVisible) {
			panel.render(graphics);
		}
	}

}
