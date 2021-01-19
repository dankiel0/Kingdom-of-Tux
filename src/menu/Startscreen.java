package menu;

import java.awt.Graphics2D;


import game.room.Room;



public class Startscreen extends Room {
	
	private Title title;
	
	// constucts a house.
	public Startscreen() {
		title = new Title();
	}
	
	@Override
	public void update(double elapsedTime) {
		title.update();
	}
	
	@Override
	public void render(Graphics2D graphics) {
		title.render(graphics);
	}

}
