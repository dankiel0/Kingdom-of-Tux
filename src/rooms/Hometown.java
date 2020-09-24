package rooms;

import java.awt.Graphics2D;

import camera.Camera;
import map.Map;
import menu.Help;
import menu.MenuSelect;
import menu.StartScreen;
import menu.StartSelect;
import player.Player;
import resource_loaders.ImageLoader;
import room.Room;
import spriteSheet.Spritesheet;
import util.Util;
import util.Util.STATE;

public class Hometown extends Room {
	private Map map;
	private Spritesheet tileset;
	
	private Camera camera;
	
	private Player player;
	
	private MenuSelect menuSelector;
	private StartSelect startSelect;
	
	public Hometown() {
		init();
	}
	
	@Override
	public void init() {
		startSelect = new StartSelect();
		menuSelector = new MenuSelect();
		tileset = new Spritesheet(ImageLoader.loadImage("assets/exterior1.png"), 64, 64);
		map = new Map("src/assets/hometown.txt");
		camera = new Camera();
		player = new Player();
		
	}
	
	@Override
	public void update() {
		player.update(camera);
		if(Util.state == STATE.START) {
			startSelect.update();
		}
		else if(Util.state == STATE.MENU || Util.state == STATE.INVENTORY) {
			menuSelector.update();
		}
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
		
		if(Util.state == STATE.START) {
			StartScreen.render(graphics);
			startSelect.render(graphics);
		}
		else if(Util.state == STATE.MENU || Util.state == STATE.INVENTORY) {
			menuSelector.render(graphics);
		}
		else if(Util.state == STATE.HELP) {
			Help.render(graphics);
		}
	}
	
	public Map getMap() {
		return map;
	}
}
