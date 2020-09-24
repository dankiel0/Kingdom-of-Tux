package assets;

import resource_loaders.ImageLoader;
import spriteSheet.Spritesheet;

public class Assets {
	public static Spritesheet playerSprite;
	public static Spritesheet menuSelect;
	public static Spritesheet startSelect;
	public static Spritesheet dlc;
	
	public static void init() {
		playerSprite = new Spritesheet(ImageLoader.loadImage("assets/sprite.png"), 64, 64);
		menuSelect = new Spritesheet(ImageLoader.loadImage("assets/outline.png"), 190, 70);
		startSelect = new Spritesheet(ImageLoader.loadImage("assets/startselect.png"), 32, 32);
		dlc = new Spritesheet(ImageLoader.loadImage("assets/thanos.jpg"), 567, 377);
	}
}
