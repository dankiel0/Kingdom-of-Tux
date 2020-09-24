package camera;

import room.RoomManager;
import rooms.Hometown;

public class Camera {
	// camera position offsets, tile position offsets
	private double offsetX, offsetY, tileOffsetX, tileOffsetY;
	
	// updates
	public void update(double x, double y) {
		// calculates offsets
		offsetX = x / 64.0 - ((double) 10.0 / 2.0);
		offsetY = y / 64.0 - ((double) 10.0 / 2.0);
		
		// prevents offsets from going out of bounds
		if(offsetX < 0)
			offsetX = 0;
		if(offsetY < 0)
			offsetY = 0;
		if(offsetX > ((Hometown) RoomManager.getRoom()).getMap().getW() - 10)
			offsetX = ((Hometown) RoomManager.getRoom()).getMap().getW() - 10;
		if(offsetY > ((Hometown) RoomManager.getRoom()).getMap().getH() - 10)
			offsetY = ((Hometown) RoomManager.getRoom()).getMap().getH() - 10;
		
		
		// calculates tile offsets
		tileOffsetX = (offsetX - (int) offsetX) * 64;
		tileOffsetY = (offsetY - (int) offsetY) * 64;
	}
	
	// getters
	public double getOffsetX() {
		return offsetX;
	}
	
	public double getOffsetY() {
		return offsetY;
	}
	
	public double getTileOffsetX() {
		return tileOffsetX;
	}
	
	public double getTileOffsetY() {
		return tileOffsetY;
	}
}
