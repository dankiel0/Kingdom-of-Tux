package battle;

import java.awt.Graphics2D;

import game.room.Room;

public class BattleSystem extends Room {
	public BattleSystem() {
		super.setMap(null);
	}
	
	@Override
	public void render(Graphics2D graphics) {
		System.out.println("render");
	}
	
	@Override
	public void update(double elapsedTime) {
		
	}
}
