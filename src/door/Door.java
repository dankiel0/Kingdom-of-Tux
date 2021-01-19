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

	public void checkCollisionWithDoor(Player player, Room newRoom, int newPlayerX, int newPlayerY) {
		int playerX = (int) (player.getX() / 64) * 64;
		int playerY = (int) (player.getY() / 64) * 64;

		if (playerX == doorX && playerY == doorY) {
			Game.setRoom(newRoom);
			
			System.out.println("true");
			
			player.setX(newPlayerX);
			player.setY(newPlayerY);
		}
	}
}
