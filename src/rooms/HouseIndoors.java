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
		setMap(new Map("assets/indoors.map", new SpriteSheet(ImageLoader.loadImage("assets/indoors.png"), 32, 32)));
		
		houseDoor = new Door(8, 10);
	}
	
	@Override
	public void update(double elapsedTime) {
		Player.player.update(elapsedTime);
		
		houseDoor.checkCollisionWithDoor(Rooms.town, 19, 8);
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
