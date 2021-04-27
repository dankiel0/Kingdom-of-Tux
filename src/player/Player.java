package player;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import battle.Stats;
import game.Game;
import game.assetLoaders.ImageLoader;
import game.input.Keyboard;
import game.spritesheet.SpriteSheet;
import rooms.Rooms;
import ui.EquipmentInventory;
import ui.Inventory;

public class Player {
	public static Player player = new Player();
	
	private enum Movement {
		DOWN(0), LEFT(3), RIGHT(6), UP(9);
		
		int index;
		double temp;
		
		Movement(int index) {
			this.index = index;
		}
	}
	
	private Movement movement = Movement.UP;
	private SpriteSheet sprite;
	
	private double x;
	private double y;
	
	private double velocityX;
	private double velocityY;
	
	public static EquipmentInventory equipment = new EquipmentInventory();
	public static Inventory inv = new Inventory();
	public static Stats stats = new Stats(100, 80, 10, 10, 10, 10, 40, 30, 10);
	
	public Player() {
		sprite = new SpriteSheet(ImageLoader.loadImage("assets/character.png"), 32, 32);
		
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
		
		// temp trigger battle system
		if (Keyboard.keyHeld(KeyEvent.VK_B)) {
			Game.setRoom(Rooms.battleSystem);
		}
		
		if (Keyboard.keyHeld(KeyEvent.VK_LEFT)) {
			velocityX = -elapsedTime * 6;
			movement = Movement.LEFT;
			movement.temp += 0.01;
		}
		if (Keyboard.keyHeld(KeyEvent.VK_RIGHT)) {
			velocityX = elapsedTime * 6;
			movement = Movement.RIGHT;
			movement.temp += 0.01;
		}
		
		if (Keyboard.keyHeld(KeyEvent.VK_UP)) {
			velocityY = -elapsedTime * 6;
			movement = Movement.UP;
			movement.temp += 0.01;
		}
		if (Keyboard.keyHeld(KeyEvent.VK_DOWN)) {
			velocityY = elapsedTime * 6;
			movement = Movement.DOWN;
			movement.temp += 0.01;
		}
		
		if (movement.temp >= 2) {
			movement.temp = 0;
		}
		
		double newX = x + velocityX;
		double newY = y + velocityY;
		
		if (velocityX <= 0) {
			if (Game.getRoom().getMap().getSolid((int) newX, (int) (y + 0.25)) || Game.getRoom().getMap().getSolid((int) newX, (int) (y + 0.999))) {
				newX = (int) newX + 1;
				velocityX = 0;
			}
		} else {
			if (Game.getRoom().getMap().getSolid((int) (newX + 1), (int) (y + 0.25)) || Game.getRoom().getMap().getSolid((int) (newX + 1), (int) (y + 0.999))) {
				newX = (int) newX;
				velocityX = 0;
			}
		}
		
		if (velocityY <= 0) {
			if (Game.getRoom().getMap().getSolid((int) newX, (int) (newY + 0.25)) || Game.getRoom().getMap().getSolid((int) (newX + 0.999), (int) (newY + 0.25))) {
				newY = ((int) newY) + 0.75;
				velocityY = 0;
			}
		} else {
			if (Game.getRoom().getMap().getSolid((int) newX, (int) (newY + 1)) || Game.getRoom().getMap().getSolid((int) (newX + 0.999), (int) (newY + 1))) {
				newY = (int) newY;
				velocityY = 0;
			}
		}
		
		x = newX;
		y = newY;
		
		Game.getCamera().setPosition(x, y);
	}
	
	public void render(Graphics2D graphics) {
		sprite.render(graphics, (int) (((x - Game.getCamera().getX()) * 32)), (int) (((y - Game.getCamera().getY()) * 32)), (int) (movement.index + movement.temp));
	}
}
