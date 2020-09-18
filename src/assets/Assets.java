package assets;

import resource_loaders.ImageLoader;
import spriteSheet.SpriteSheet;

public class Assets {
	public static SpriteSheet playerSprite;
	
	public static void init() {
		playerSprite = new SpriteSheet(ImageLoader.loadImage("assets/tempPlayerSprite.png"), 1);
	}
}
