package rooms;

import java.awt.Graphics2D;

import door.Door;
import game.assetLoaders.ImageLoader;
import game.room.Room;
import game.spritesheet.SpriteSheet;
import map.Map;
import player.Player;

public class HouseIndoors extends Room {
	private Door houseDoor;
	
	// constucts a house.
	public HouseIndoors() {
		// sets the house map.
		setMap(new Map("assets/test.map", new SpriteSheet(ImageLoader.loadImage("assets/tileset.png"), 64, 64)));
		
		houseDoor = new Door(5, 3);
	}
	
	@Override
	public void update(double elapsedTime) {
		Player.player.update(elapsedTime);
		
		houseDoor.checkCollisionWithDoor(Rooms.town, 13, 10);
	}
	
	@Override
	public void render(Graphics2D graphics) {
		// render the background.
		getMap().renderBackground(graphics);
		
		// render the player.
		Player.player.render(graphics);
		
		// render the foreground.
		getMap().renderForeground(graphics);
	}
}
