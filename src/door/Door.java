package door;

import game.Game;
import game.room.Room;
import player.Player;

public class Door {
	private double doorX;
	private double doorY;
	
	public Door(double doorX, double doorY) {
		this.doorX = doorX;
		this.doorY = doorY;
	}
	
	public void checkCollisionWithDoor(Room newRoom, double newPlayerX, double newPlayerY) {
		int playerX = (int) Player.player.getX();
		int playerY = (int) Player.player.getY();
		
		if (playerX == doorX && playerY == doorY) {
			Game.setRoom(newRoom);
			
			System.out.println("true");
			
			Player.player.setX(newPlayerX);
			Player.player.setY(newPlayerY);
		}
	}
}
