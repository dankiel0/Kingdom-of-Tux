package menu;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import game.Game;
import game.assetLoaders.ImageLoader;
import game.spritesheet.SpriteSheet;
import rooms.Town;
import userInterface.BBbutton;
import userInterface.BBlabel;
import userInterface.BBpanel;

public class Title {
		
	private BBpanel tPanel;
	private SpriteSheet titlePage; 
	public Title() {
		// inits ui.
		BBbutton button1 = new BBbutton(160, 100, 320, 50, "Start Game");
		
		button1.onClick(KeyEvent.VK_Z, () -> {
			Game.setRoom(new Town());
		});
		
		BBbutton button2 = new BBbutton(160, 200, 320, 50, "Quit");
		
		button2.onClick(KeyEvent.VK_Z, () -> {
			System.exit(0);
		});
		
		titlePage = new SpriteSheet(ImageLoader.loadImage("src/sufiyanos.jpg"), 640, 640);
		
		tPanel = new BBpanel(0, 320, 640, 320, new BBlabel(0, 0, 640, -520, "Dark Gray Square Game"), button1, button2);
	}
	
	public void update() {
		tPanel.update();
	}
	
	public void render(Graphics2D graphics) {
		Font font = new Font("Times New Roman", Font.BOLD, 50);
		graphics.setFont(font);
		titlePage.render(graphics, 0, 0, 0, 0); 
		tPanel.render(graphics);
	}

}
