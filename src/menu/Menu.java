package menu;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import map.Map;

public class Menu {
	
	public Rectangle sideMenu = new Rectangle(400, 0, 240, 640);
	public Rectangle party = new Rectangle(425, 50, 190, 70);
	public Rectangle inventory = new Rectangle(425, 170, 190, 70);
	public Rectangle options = new Rectangle(425, 290, 190, 70);
	public Rectangle save = new Rectangle(425, 410, 190, 70);
	public Rectangle quit = new Rectangle(425, 530, 190, 70);
	
	public void render(Graphics2D graphics) {
		graphics.setColor(new Color(40, 40, 40));
		graphics.fill(sideMenu);
		graphics.setColor(new Color(0, 0, 0));
		graphics.fill(party);
		graphics.fill(inventory);
		graphics.fill(options);
		graphics.fill(save);
		graphics.fill(quit);
		graphics.setColor(new Color(255, 255, 255));
		Font font = new Font("Times New Roman", Font.PLAIN, 30);
		graphics.setFont(font);
		graphics.drawString("Party", 480, 95);
		graphics.drawString("Inventory", 460, 215);
		graphics.drawString("Options", 467, 335);
		graphics.drawString("Save", 483, 455);
		graphics.drawString("Quit", 486, 575);
	}	

}
