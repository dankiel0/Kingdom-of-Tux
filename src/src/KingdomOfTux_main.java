package src;

import game.BBwindow;
import game.Game;
import rooms.Rooms;

// driver class.
public class KingdomOfTux_main {
	public static void main(String[] args) {
		// sets window.
		Game.setWindow(new BBwindow("Game", 480, 480));
		
		// sets room.
		Game.setRoom(Rooms.startScreen);
		
		// starts game.
		Game.start();
	}
}
