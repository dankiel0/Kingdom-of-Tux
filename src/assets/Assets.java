package assets;

import resource_loaders.ImageLoader;
import spriteSheet.Spritesheet;

public class Assets {
	public static Spritesheet playerSprite;
	
	public static void init() {
		playerSprite = new Spritesheet(ImageLoader.loadImage("assets/tempPlayerSprite.png"), 64, 64);
	}
}
