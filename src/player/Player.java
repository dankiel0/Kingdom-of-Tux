package player;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import game.Game;
import game.input.Keyboard;
import ui.Inventory;

public class Player {
	public static Player player = new Player();
	
	private double x;
	private double y;
	
	private double velocityX;
	private double velocityY;
	
	public static Inventory inv = new Inventory();
	
	public Player() {
		// initial position of the player.
		x = 3;
		y = 3;
	}
	
	public void changePos(double newX, double newY) {
		x = newX;
		y = newY;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void update(double elapsedTime) {
		velocityX = 0;
		velocityY = 0;
		
		if (Keyboard.keyHeld(KeyEvent.VK_LEFT))
			velocityX = -elapsedTime * 6;
		if (Keyboard.keyHeld(KeyEvent.VK_RIGHT))
			velocityX = elapsedTime * 6;
		
		if (Keyboard.keyHeld(KeyEvent.VK_UP))
			velocityY = -elapsedTime * 6;
		if (Keyboard.keyHeld(KeyEvent.VK_DOWN))
			velocityY = elapsedTime * 6;
		
		double newX = x + velocityX;
		double newY = y + velocityY;
		
		if (velocityX <= 0) {
			if (Game.getRoom().getMap().getSolid((int) newX, (int) (y + 0.25))
					|| Game.getRoom().getMap().getSolid((int) newX,
							(int) (y + 0.999))) {
				newX = (int) newX + 1;
				velocityX = 0;
			}
		} else {
			if (Game.getRoom().getMap().getSolid((int) (newX + 1),
					(int) (y + 0.25))
					|| Game.getRoom().getMap().getSolid((int) (newX + 1),
							(int) (y + 0.999))) {
				newX = (int) newX;
				velocityX = 0;
			}
		}
		
		if (velocityY <= 0) {
			if (Game.getRoom().getMap().getSolid((int) newX,
					(int) (newY + 0.25))
					|| Game.getRoom().getMap().getSolid((int) (newX + 0.999),
							(int) (newY + 0.25))) {
				newY = ((int) newY) + 0.75;
				velocityY = 0;
			}
		} else {
			if (Game.getRoom().getMap().getSolid((int) newX, (int) (newY + 1))
					|| Game.getRoom().getMap().getSolid((int) (newX + 0.999),
							(int) (newY + 1))) {
				newY = (int) newY;
				velocityY = 0;
			}
		}
		
		x = newX;
		y = newY;
		
		Game.getCamera().setPosition(x, y);
	}
	
	public void render(Graphics2D graphics) {
		graphics.fillRect((int) (((x - Game.getCamera().getX()) * 32)), (int) (((y - Game.getCamera().getY()) * 32)), 32, 32);
	}
}
