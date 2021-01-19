package rooms;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import door.Door;
import game.assetLoaders.ImageLoader;
import game.input.Keyboard;
import game.room.Room;
import game.spritesheet.SpriteSheet;
import map.Map;
import menu.BasicUI;
import player.Player;
import userInterface.BBbutton;
import userInterface.BBlabel;
import userInterface.BBpanel;

public class house1 extends Room {
	
	private boolean panelVisible;
	private BBpanel panel;
	private Door door1;
	private BasicUI edwin = new BasicUI();
		
		// constucts a house.
		public house1() {
			// sets the house map.
			setMap(new Map("src/test.map", new SpriteSheet(ImageLoader.loadImage("src/tiles.png"), 64, 64)));
			
			// inits ui.		
			door1 = new Door(Player.player, 320, 256);
		}
		
		@Override
		public void update(double elapsedTime) {
			edwin.update(elapsedTime);
			door1.update(elapsedTime);		
			if(door1.onRoomTile()) {
				door1.changeRoom(new Town(), 13, 10);
			}
		}
		
		@Override
		public void render(Graphics2D graphics) {
			// render the background.
			getMap().renderBackground(graphics);
			
			// render the player.
			Player.player.render(graphics);
			
			// render the foreground.
			getMap().renderForeground(graphics);
			
			// render the menu
			edwin.render(graphics);
		}

}
