package ui;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import game.Game;
import game.assetLoaders.ImageLoader;
import game.room.Room;
import game.spritesheet.SpriteSheet;
import rooms.Town;
import userInterface.BBbutton;
import userInterface.BBlabel;
import userInterface.BBpanel;

public class StartScreen extends Room {
	private BBpanel tPanel;
	private SpriteSheet titlePage;
	private Font font;
	
	public StartScreen() {
		// inits ui.
		BBbutton button1 = new BBbutton(80, 50, 320, 50, "Start Game");
		
		button1.onClick(KeyEvent.VK_Z, () -> {
			Game.setRoom(new Town());
		});
		
		BBbutton button2 = new BBbutton(80, 150, 320, 50, "Quit");
		
		button2.onClick(KeyEvent.VK_Z, () -> {
			Game.stop();
		});
		
		titlePage = new SpriteSheet(ImageLoader.loadImage("src/hot.png"), 480, 480);
		
		tPanel = new BBpanel(0, 240, 480, 240, new BBlabel(0, 0, 480, -360, "The Kingdom of Tux"), button1, button2);
		
		font = new Font("Times New Roman", Font.BOLD, 50);
	}
	
	public void update(double elapsedTime) {
		tPanel.update();
	}
	
	public void render(Graphics2D graphics) {
		graphics.setFont(font);
		titlePage.render(graphics, 0, 0, 0, 0); 
		tPanel.render(graphics);
	}
}
