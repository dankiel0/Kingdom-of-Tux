package rooms;

import java.awt.Graphics2D;

import door.Door;
import game.assetLoaders.ImageLoader;
import game.room.Room;
import game.spritesheet.SpriteSheet;
import map.Map;
import player.Player;

public class house1 extends Room {
	private Door door1;

	// constucts a house.
	public house1() {
		// sets the house map.
		setMap(new Map("assets/test.map", new SpriteSheet(
				ImageLoader.loadImage("assets/tiles.png"), 64, 64)));

		door1 = new Door(5, 4);
	}

	@Override
	public void update(double elapsedTime) {
		Player.player.update(elapsedTime);

		door1.checkCollisionWithDoor(Player.player, new Town(), 13, 10);
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
