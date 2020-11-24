package rooms;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import door.Door;
import game.assetLoaders.ImageLoader;
import game.input.Keyboard;
import game.room.Room;
import game.spritesheet.SpriteSheet;
import map.Map;
import player.Player;
import userInterface.BBbutton;
import userInterface.BBlabel;
import userInterface.BBpanel;

public class Town extends Room {
	private Door door1;
	
	private BBpanel panel;
	private boolean panelVisible;
	
	// constucts a town.
	public Town() {
		// sets the town map.
		setMap(new Map("src/hometown.map", new SpriteSheet(ImageLoader.loadImage("src/tiles.png"), 64, 64)));
		
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
		
		
		door1 = new Door(Player.player, 832, 576);
	}
	
	@Override
	public void update(double elapsedTime) {
		
		// if the panel is invisible, update the player.
		if(!panelVisible)
			Player.player.update(elapsedTime);
			door1.update(elapsedTime);
		
		// if the space key is clicked, hide or show the panel.
		if(Keyboard.keyClicked(KeyEvent.VK_SPACE))
			panelVisible = !panelVisible;
		
		// if the panel is visible, update it.
		if(panelVisible)
			panel.update();
		if(door1.onRoomTile()) {
			door1.changeRoom(new house1(), 5, 5);
		}
		
	}
	
	@Override
	public void render(Graphics2D graphics) {
		// render the background.
		getMap().renderBackground(graphics);
		
		// render the foreground.
		getMap().renderForeground(graphics);
		
		// render the player.
		Player.player.render(graphics);
		
		// if the panel is visible, render it.
		if(panelVisible)
			panel.render(graphics);
	}
}



