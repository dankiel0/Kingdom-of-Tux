package src;

import rooms.Town;
import game.BBwindow;
import game.Game;
import menu.Startscreen;


// driver class
public class KingdomOfTux_main {
	
	public enum STATE{
		TITLE
	};
	
	public static STATE State = STATE.TITLE;
	
	public static void main(String[] args) {
		// sets window.
		Game.setWindow(new BBwindow("Game", 640, 640));
		
		// sets room.
		Game.setRoom(new Startscreen());
		
		
		// starts game.
		Game.start();
		
		
	}
}

