package menu;

import java.awt.Graphics2D;

import assets.Assets;
import eventListeners.Keyboard;
import util.Util;
import util.Util.STATE;

public class MenuSelect {
	
	private double x, y;
	private Inventory inv;
	
	public MenuSelect() {
		inv = new Inventory();
		init();
	}
	
	private void init() {
		x = 425;
		y = 50;
	}
	
	public void update() {
		
		if(Util.state == STATE.MENU) {
			// up movement 
			if(Keyboard.keys[38] && y > 50) {
				y -= 120;
			}
				
			// down movement 
			if(Keyboard.keys[40] && y < 530) {
				y += 120;
			}
			
			// quit selection
			if(Keyboard.keys[90] && y == 530) {
				Util.state = STATE.START;
			}
			
			// inventory selection
			if(Keyboard.keys[90] && y == 170) {
				Util.state = STATE.INVENTORY;
			}
		}
		
	}
	
	public void render(Graphics2D graphics) {
		if(Util.state == STATE.INVENTORY) {
			inv.render(graphics);
		}
		else {
			Assets.menuSelect.render(graphics, x, y, 190, 70);
		}
		
	}

}
