package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Inventory {
	
	public Rectangle background = new Rectangle(0, 0, 640, 640);
	
	public void render(Graphics2D graphics) {
		graphics.setColor(new Color(0, 0, 0));
		graphics.fill(background);
		graphics.setColor(new Color(255, 255, 255));
		Font font = new Font("Times New Roman", Font.BOLD, 50);
		graphics.setFont(font);
		graphics.drawString("Inventory", 200, 50);
	}
	
}
