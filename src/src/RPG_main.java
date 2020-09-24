package src;

import game.Game;
import room.RoomManager;
import rooms.Hometown;
import window.Window;

// driver class
public class RPG_main {
	public static void main(String[] args) {
		// makes game
		// game constructor takes in window object
		// window constructor takes in game name, width, and height
		Game rpgGame = new Game(new Window("RPG", 640, 640));
		
		// set active room to default room
		// can be changed later
		RoomManager.setRoom(new Hometown());
		
		// starts game
		rpgGame.start();
	}
}
