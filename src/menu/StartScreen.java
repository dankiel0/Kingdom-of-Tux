package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class StartScreen {
	
public static Rectangle background = new Rectangle(0, 0, 640, 640);
	
	public static void render(Graphics2D graphics) {
		graphics.setColor(new Color(255, 100, 100));
		graphics.fill(background);
		graphics.setColor(new Color(255, 255, 255));
		Font font = new Font("Times New Roman", Font.BOLD, 50);
		graphics.setFont(font);
		graphics.drawString("Red Square Game", 125, 60);
		graphics.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		graphics.drawString("NEW GAME", 240, 340);
		graphics.drawString("CONTINUE", 240, 400);
		graphics.drawString("HELP", 240, 460);
		graphics.drawString("QUIT", 240, 520);
	}

}
