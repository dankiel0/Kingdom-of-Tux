package rooms;

import java.awt.Graphics2D;

import java.awt.event.KeyEvent;

//import menu.BasicUI;
import door.Door;
import game.assetLoaders.ImageLoader;
import game.input.Keyboard;
import game.room.Room;
import game.spritesheet.SpriteSheet;
import map.Map;
import menu.BasicUI;
import menu.Inventory;
import menu.Item;
import player.Player;



public class Town extends Room {
	private Door door1;
	
	private Inventory inv;
//	private Item dan = new Item("Damiel", "Basically God incarnate", 1, 1000);
//	private Item alex = new Item("Alex", "A truly powerful ancient weapon", 1, 1000);
	private BasicUI edwin = new BasicUI();
	
	// constucts a town.
	public Town() {
		
//		inv = new Inventory();
//		inv.addItem(dan);
//		inv.addItem(alex);
		
		// sets the town map.
		setMap(new Map("src/hometown.map", new SpriteSheet(ImageLoader.loadImage("src/tiles.png"), 64, 64)));
		
//		// inits ui.

//		button1.onClick(KeyEvent.VK_Z, () -> {
//			for(int i = 0; i < inv.inventorySize(); i++) {
//				System.out.println((inv.getItem(i)).getName());
//				System.out.println((inv.getItem(i)).getDesc());
//				System.out.println((inv.getItem(i)).getQuant());
//				System.out.println((inv.getItem(i)).getWorth());
//			}
//		});
//
		
		door1 = new Door(Player.player, 832, 576);
		
	}
	
	@Override
	public void update(double elapsedTime) {
		
		door1.update(elapsedTime);
		edwin.update(elapsedTime);
		
		if(door1.onRoomTile()) {
			door1.changeRoom(new house1(), 5, 5);
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



