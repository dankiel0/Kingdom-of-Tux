package menu;

import java.awt.Graphics2D;

import assets.Assets;
import eventListeners.Keyboard;
import util.Util;
import util.Util.STATE;

public class Help {
	
//private double x, y;
//	
//	public Help() {
//		init();
//	}
//	
//	private void init() {
//		x = 198;
//		y = 315;
//	}
//	
//	public void update() {
//		
//		// up movement 
//		if(Keyboard.keys[38] && y > 315) {
//			y -= 60;
//		}
//			
//		// down movement 
//		if(Keyboard.keys[40] && y < 495) {
//			y += 60;
//		}
//		
//		// quit selection
//		if(Keyboard.keys[90] && y == 495) {
//			System.exit(0);
//		}
//		
//		// new game
//		if(Keyboard.keys[90] && y == 315) {
//			Util.state = STATE.GAME;
//		}
//		
//	}
	
	public static void render(Graphics2D graphics) {
		Assets.dlc.render(graphics, 0, 0, 567, 377);
		
	}

}
