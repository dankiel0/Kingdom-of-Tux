package characters;

import java.awt.Graphics2D;

import assets.Assets;
import eventListeners.Keyboard;
import util.Util;

public class TempCharacter {
	private double x, y, velocityX, velocityY;
	
	public TempCharacter() {
		init();
	}
	
	private void init() {
		// player start position
		x = 0 * Util.tileSize;
		y = 0 * Util.tileSize;
	}
	
	public void update(double elapsedTime) {
		velocityX = 0;
		velocityY = 0;
		
		// left movement - set velocityX to left
		if(Keyboard.keys[37])
			velocityX = -145.0;
		
		// left movement - set velocityX to left
		if(Keyboard.keys[38])
			velocityY = -145.0;
		
		// left movement - set velocityX to left
		if(Keyboard.keys[39])
			velocityX = 145.0;
		
		// left movement - set velocityX to left
		if(Keyboard.keys[40])
			velocityY = 145.0;
		
		// updating positions
		x += velocityX * elapsedTime;
		y += velocityY * elapsedTime;
	}
	
	public void render(Graphics2D graphics) {
		// render player sprite
		Assets.playerSprite.render(graphics, x, y, Util.tileSize, Util.tileSize);
	}
}
