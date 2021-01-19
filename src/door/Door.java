package door;


import game.Game;
import game.room.Room;
import player.Player;

public class Door {
	
	private double x;
	private double y;
	private Player player;
	private double px;
	private double py;
	
	public Door(Player p, double doorx, double doory) {
		player = p;
		x = doorx;
		y = doory;
	}
	 
	public boolean onRoomTile() {
		if(px >= x && px <= x + 64 && py >= y && py <= y + 16) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void update(double elapsedTime) {
		px = player.getX()*64;
//		System.out.println("x: " + px);
		py = player.getY()*64;
//		System.out.println("y: " + py);
	}
	
	public void changeRoom(Room newRoom, double x, double y) {
		Game.setRoom(newRoom);
		player.changePos(x, y);
	}

}
