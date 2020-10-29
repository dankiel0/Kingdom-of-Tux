package src;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import game.BBwindow;
import game.Game;
import game.assetLoaders.ImageLoader;
import game.input.Keyboard;
import game.room.Room;
import game.spritesheet.SpriteSheet;
import map.Map;
import userInterface.BBbutton;
import userInterface.BBlabel;
import userInterface.BBpanel;

// driver class
public class RPG_main {
	public static void main(String[] args) {
		Game.setWindow(new BBwindow("Game", 640, 640));
		Game.setRoom(Town::new);
		
		Game.start();
	}
}

class Town extends Room {
	private BBpanel panel;
	
	private boolean panelVisible;
	
	public Town() {
		setMap(new Map("src/hometown.map", new SpriteSheet(ImageLoader.loadImage("src/tiles.png"), 64, 64)));
		
		BBbutton button1 = new BBbutton(0, 100, 150, 50, "Inventory");
		
		button1.onClick(KeyEvent.VK_Z, () -> {
			System.out.println("Button 1 has been clicked!");
		});
		
		BBbutton button2 = new BBbutton(0, 200, 150, 50, "Save");
		
		button2.onClick(KeyEvent.VK_Z, () -> {
			System.out.println("Button 2 has been clicked!");
		});
		
		panel = new BBpanel(0, 320, 640, 320, new BBlabel(0, 0, 150, 50, "Menu"), button1, button2);
	}
	
	@Override
	public void update(double elapsedTime) {
		if(!panelVisible)
			Player.player.update(elapsedTime);
		
		if(Keyboard.keyClicked(KeyEvent.VK_SPACE))
			panelVisible = !panelVisible;
		
		if(panelVisible)
			panel.update();
	}
	
	@Override
	public void render(Graphics2D graphics) {
		getMap().renderBackground(graphics);
		Player.player.render(graphics);
		getMap().renderForeground(graphics);
		
		if(panelVisible)
			panel.render(graphics);
	}
}

class Player {
	public static Player player = new Player();
	
	private double x;
	private double y;
	
	private double velocityX;
	private double velocityY;
	
	public Player() {
		x = 3;
		y = 3;
	}
	
	public void update(double elapsedTime) {
		velocityX = 0;
		velocityY = 0;
		
		if(Keyboard.keyHeld(KeyEvent.VK_LEFT))
			velocityX = -elapsedTime * 5;
		if(Keyboard.keyHeld(KeyEvent.VK_RIGHT))
			velocityX = elapsedTime * 5;
		
		if(Keyboard.keyHeld(KeyEvent.VK_UP))
			velocityY = -elapsedTime * 5;
		if(Keyboard.keyHeld(KeyEvent.VK_DOWN))
			velocityY = elapsedTime * 5;
		
		double newX = x + velocityX;
		double newY = y + velocityY;
		
		if(velocityX <= 0) {
			if(Game.getRoom().getMap().getSolid((int) newX, (int) y) || Game.getRoom().getMap().getSolid((int) newX, (int) (y + 0.999))) {
				newX = (int) newX + 1;
				velocityX = 0;
			}
		} else {
			if(Game.getRoom().getMap().getSolid((int) (newX + 1), (int) y) || Game.getRoom().getMap().getSolid((int) (newX + 1), (int) (y + 0.999))) {
				newX = (int) newX;
				velocityX = 0;
			}
		}
		
		if(velocityY <= 0) {
			if(Game.getRoom().getMap().getSolid((int) newX, (int) newY) || Game.getRoom().getMap().getSolid((int) (newX + 0.999), (int) newY)) {
				newY = (int) newY + 1;
				velocityY = 0;
			}
		} else {
			if(Game.getRoom().getMap().getSolid((int) newX, (int) (newY + 1)) || Game.getRoom().getMap().getSolid((int) (newX + 0.999), (int) (newY + 1))) {
				newY = (int) newY;
				velocityY = 0;
			}
		}
		
		x = newX;
		y = newY;
		
		Game.getCamera().setPosition(x, y);
	}
	
	public void render(Graphics2D graphics) {
		graphics.fillRect((int) (((x - Game.getCamera().getX()) * 64)), (int) (((y - Game.getCamera().getY()) * 64)), 64, 64);
	}
}
