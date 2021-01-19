package src;

import rooms.Town;
import game.BBwindow;
import game.Game;

// driver class.
public class KingdomOfTux_main {
	public static void main(String[] args) {
		// sets window.
		Game.setWindow(new BBwindow("Game", 640, 640));

		// sets room.
		Game.setRoom(new Town());

		// starts game.
		Game.start();
	}
}
