package ui;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import player.Player;
import userInterface.BBlabel;
import userInterface.BBpanel;


public class InvUi {
	private BBpanel panel;
	private InventoryCell invCell;
	private ArrayList<InventoryCell> cells = new ArrayList<InventoryCell>();
	private Font font;
	
	public InvUi() {
		
		font = new Font("Times New Roman", Font.BOLD, 40);
		panel = new BBpanel(60, 30, 360, 360, new BBlabel(0, 0, 360, 50, "Inventory"));
		
		this.updateInventory();
	}
	
	public void updateInventory() {
		cells.clear();
		System.out.println(cells.size());
		//The loop goes through the inventory of the player and creates a corresponding amount of cells for each unique item the player has
		int row = 0;
		int column =  0;
		for(int i = 0; i < Player.inv.inventorySize(); i++) {
			//rows and columns control the placement of cells within the inventory -> max out 25 unique items in the inventory.
			if(column < 5) {
				invCell = new InventoryCell(99+(column*62), 99+(row*62), 33, 33, Player.inv.getItem(i));
				column++;
				cells.add(invCell);
			}
			else {
				column = 0;
				row++;
				invCell = new InventoryCell(99+(column*62), 99+(row*62), 33, 33, Player.inv.getItem(i));
				cells.add(invCell);
				column++;
			}
			
		}
		System.out.println(cells.size());
		System.out.println("one iteration");
	}
	
	public void update() {
		panel.update();
	}
	
	public void render(Graphics2D graphics) {
		graphics.setFont(font);
		
		panel.render(graphics);
		
		for(int i = 0; i < cells.size(); i++) {
			cells.get(i).render(graphics);
			cells.get(i).getItem().getIconPath().render(graphics, cells.get(i).getX()+1, cells.get(i).getY()+1, cells.get(i).getItem().getSpriteIndex());
		}
		
	}

}
