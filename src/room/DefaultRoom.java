package room;

import java.awt.Graphics2D;

import characters.TempCharacter;

// the default room for now
public class DefaultRoom extends Room {
	// temporary character
	private TempCharacter tempCharacter;
	
	// initializes room objects, such as characters
	@Override
	public void init() {
		tempCharacter = new TempCharacter();
	}
	
	// updates character positions, and things like that
	@Override
	public void update() {
		tempCharacter.update();
	}
	
	// draws character to the screen
	@Override
	public void render(Graphics2D graphics) {
		tempCharacter.render(graphics);
	}
}
