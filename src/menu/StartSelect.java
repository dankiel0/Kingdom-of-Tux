package menu;

import java.awt.Graphics2D;

import assets.Assets;
import eventListeners.Keyboard;
import util.Util;
import util.Util.STATE;

public class StartSelect {
	
	private double x, y;
	
	public StartSelect() {
		init();
	}
	
	private void init() {
		x = 198;
		y = 315;
	}
	
	public void update() {
		
		if(Util.state == STATE.START) {
			// up movement 
			if(Keyboard.keys[38] && y > 315) {
				y -= 60;
			}
				
			// down movement 
			if(Keyboard.keys[40] && y < 495) {
				y += 60;
			}
			
			// quit selection
			if(Keyboard.keys[90] && y == 495) {
				System.exit(0);
			}
			
			// new game
			if(Keyboard.keys[90] && y == 315) {
				Util.state = STATE.GAME;
			}
			
			// help
			if(Keyboard.keys[90] && y == 435) {
				Util.state = STATE.HELP;
			}
		}
	}
	
	public void render(Graphics2D graphics) {
		Assets.startSelect.render(graphics, x, y, 32, 32);
		
	}

}
