package src;

import assets.Assets;
import game.Game;
import room.DefaultRoom;
import room.RoomManager;
import window.Window;

// driver class
public class RPG_main {
	public static void main(String[] args) {
		// initialize assets
		Assets.init();
		
		// makes game
		// game constructor takes in window object
		// window constructor takes in game name, width, and height
		Game rpgGame = new Game(new Window("RPG", 500, 500));
		
		// set active room to default room
		// can be changed later
		RoomManager.setActiveRoom(new DefaultRoom());
		
		// starts game
		rpgGame.start();
	}
}
