package room;

import java.awt.Graphics2D;

import characters.TempCharacter;
import menu.Help;
import menu.MenuSelect;
import menu.StartScreen;
import menu.StartSelect;
import util.Util.STATE;
import util.Util;

// the default room for now
public class DefaultRoom extends Room {
	// temporary character
	private TempCharacter tempCharacter;
	private MenuSelect menuSelector;
	private StartSelect startSelect;
	
	// initializes room objects, such as characters
	@Override
	public void init() {
		
		startSelect = new StartSelect();
		tempCharacter = new TempCharacter();
		menuSelector = new MenuSelect();

	}
	
	// updates character positions, and things like that
	@Override
	public void update() {
		tempCharacter.update();
		if(Util.state == STATE.START) {
			startSelect.update();
		}
		else if(Util.state == STATE.MENU || Util.state == STATE.INVENTORY) {
			menuSelector.update();
		}
	}
	
	// draws character to the screen
	@Override
	public void render(Graphics2D graphics) {
		tempCharacter.render(graphics);
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
}
