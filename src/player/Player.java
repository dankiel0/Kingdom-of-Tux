package player;

import java.awt.Graphics2D;

import camera.Camera;
import eventListeners.Keyboard;
import menu.Menu;
import resource_loaders.ImageLoader;
import room.RoomManager;
import rooms.Hometown;
import spriteSheet.Spritesheet;
import util.Util;
import util.Util.STATE;

public class Player {
	private Spritesheet playerSprite;
	
	private double velocityX, velocityY, x, y;
	private Menu menu;
	
	public Player() {
		menu = new Menu();
		init();
	}
	
	public void init() {
		playerSprite = new Spritesheet(ImageLoader.loadImage("assets/sprite.png"), 64, 64);
		
		x = 2 * 64;
		y = 2 * 64;
	}
	
	public void update(Camera camera) {
		velocityX = velocityY = 0;
		
		if(Util.state == STATE.GAME) {
			// left movement - set velocityX to left
			if(Keyboard.keys[37])
				velocityX = -4.0;
			
			// left movement - set velocityX to left
			if(Keyboard.keys[38])
				velocityY = -4.0;
			
			// left movement - set velocityX to left
			if(Keyboard.keys[39])
				velocityX = 4.0;
			
			// left movement - set velocityX to left
			if(Keyboard.keys[40])
				velocityY = 4.0;
		}
		
		if(Keyboard.keys[88]) {
			if(Util.state == STATE.GAME || Util.state == STATE.INVENTORY) {
				Util.state = STATE.MENU;
			}
			else {
				if(Util.state == STATE.MENU) {
					Util.state = STATE.GAME;
				}
			}
		}
		
		double newX = x + velocityX;
		double newY = y + velocityY;
		
		newX /= 64;
		newY /= 64;
		
		if(velocityX <= 0) {
			if(((Hometown) RoomManager.getRoom()).getMap().getSolid((int) newX, (int) y / 64) || ((Hometown) RoomManager.getRoom()).getMap().getSolid((int) newX, (int) (y / 64 + 0.999))) {
				newX = (int) newX + 1;
				velocityX = 0;
			}
		} else {
			if(((Hometown) RoomManager.getRoom()).getMap().getSolid((int) (newX + 1), (int) y / 64) || ((Hometown) RoomManager.getRoom()).getMap().getSolid((int) (newX + 1), (int) (y / 64+ 0.999))) {
				newX = (int) newX;
				velocityX = 0;
			}
		}
		
		if(velocityY <= 0) {
			if(((Hometown) RoomManager.getRoom()).getMap().getSolid((int) newX, (int) newY) || ((Hometown) RoomManager.getRoom()).getMap().getSolid((int) (newX + 0.999), (int) newY)) {
				newY = (int) newY + 1;
				velocityY = 0;
			}
		} else {
			if(((Hometown) RoomManager.getRoom()).getMap().getSolid((int) newX, (int) (newY + 1)) || ((Hometown) RoomManager.getRoom()).getMap().getSolid((int) (newX + 0.999), (int) (newY + 1))) {
				newY = (int) newY;
				velocityY = 0;
			}
		}
		
		x = newX * 64;
		y = newY * 64;
		
		camera.update(x, y);
	}
	
	public void render(Graphics2D graphics, Camera camera) {
		playerSprite.render(graphics, x - (camera.getOffsetX() * 64.0), y - (camera.getOffsetY() * 64.0), 64, 64);
		if(Util.state == STATE.MENU) {
			menu.render(graphics);
		}
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
