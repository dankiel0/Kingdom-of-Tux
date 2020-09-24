package characters;

import java.awt.Graphics2D;

import assets.Assets;
import eventListeners.Keyboard;
import menu.Menu;
import util.Util;
import util.Util.STATE;


public class TempCharacter {
	private double x, y, velocityX, velocityY;
	private Menu menu;

	
	public TempCharacter() {
		menu = new Menu();
		init();
	}
	
	private void init() {
		// player start position
		x = 0 * Util.tileSize;
		y = 0 * Util.tileSize;
	}
	
	public void update() {
		velocityX = 0;
		velocityY = 0;
		
		if(Util.state == STATE.GAME) {
		
		// left movement - set velocityX to left
		if(Keyboard.keys[37])
			velocityX = -10.0;
		
		// up movement - set velocityX to up
		if(Keyboard.keys[38])
			velocityY = -10.0;
		
		// right movement - set velocityX to right
		if(Keyboard.keys[39])
			velocityX = 10.0;
		
		// down movement - set velocityX to down
		if(Keyboard.keys[40])
			velocityY = 10.0;
		}
		// menu
		if(Keyboard.keys[88]) {
			if(Util.state == STATE.GAME || Util.state == STATE.INVENTORY) {
				Util.state = STATE.MENU;
			}
			else {
				if(Util.state == STATE.MENU) {
					Util.state = STATE.GAME;
				}
			}
		}
		
		// updating positions
		x += velocityX;
		y += velocityY;
	}
	
	public void render(Graphics2D graphics) {
		// render player sprite
		Assets.playerSprite.render(graphics, x, y, Util.tileSize, Util.tileSize);
		if(Util.state == STATE.MENU) {
			menu.render(graphics);
		}
	}
}
