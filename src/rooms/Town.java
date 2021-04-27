package rooms;

import java.awt.Graphics2D;

import door.Door;
import game.assetLoaders.ImageLoader;
import game.room.Room;
import game.spritesheet.SpriteSheet;
import map.Map;
import player.Player;
import ui.Menu;

public class Town extends Room {
	public static Menu ui;
	
	private Door houseDoor;
	
	// constucts a town.
	public Town() {
		// sets the town map.
		setMap(new Map("assets/town.map", new SpriteSheet(ImageLoader.loadImage("assets/tileset.png"), 32, 32)));
		
		ui = new Menu();
		
		houseDoor = new Door(19, 7);//19, 7.75
	}
	
	@Override
	public void update(double elapsedTime) {
		ui.update();
		
		if(!ui.isMenuVisible() && !ui.isInvVisible() && !ui.isCharVisible() && !ui.isIntVisible() && !ui.isUeVisible())
			Player.player.update(elapsedTime);
		
		houseDoor.checkCollisionWithDoor(Rooms.houseIndoors, 8, 9);//8, 10
	}
	
	@Override
	public void render(Graphics2D graphics) {
		// render the background.
		getMap().renderBackground(graphics);
		
		Player.player.render(graphics);
		
		// render the foreground.
		getMap().renderForeground(graphics);
		
		ui.render(graphics);
	}
}
