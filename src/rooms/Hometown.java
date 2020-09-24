package rooms;

import java.awt.Graphics2D;

import camera.Camera;
import map.Map;
import player.Player;
import resource_loaders.ImageLoader;
import room.Room;
import spriteSheet.Spritesheet;

public class Hometown extends Room {
	private Map map;
	private Spritesheet tileset;
	
	private Camera camera;
	
	private Player player;
	
	@Override
	public void init() {
		tileset = new Spritesheet(ImageLoader.loadImage("assets/exterior1.png"), 64, 64);
		map = new Map("src/assets/tempMap.txt");
		camera = new Camera();
		player = new Player();
	}
	
	@Override
	public void update() {
		player.update(camera);
	}
	
	@Override
	public void render(Graphics2D graphics) {
		// draws map to the screen
		for(int x = -1; x < 10 + 1; x++)
			for(int y = -1; y < 10 + 1; y++) {
				int index = map.getIndex((int) (x + camera.getOffsetX()), (int) (y + camera.getOffsetY()));
				
				tileset.setSprite(index);
				
				tileset.render(graphics, x * 64.0 - camera.getTileOffsetX(), y * 64.0 - camera.getTileOffsetY(), 64, 64);
			}
		
		player.render(graphics, camera);
	}
	
	public Map getMap() {
		return map;
	}
}
