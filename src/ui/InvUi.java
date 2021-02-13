package ui;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import player.Player;
import rooms.Town;
import userInterface.BBlabel;
import userInterface.BBpanel;


public class InvUi {
	private BBpanel panel;
	private BBpanel descPanel;
	private InventoryCell invCell;
	private Button invButton;
	private ArrayList<InventoryCell> cells = new ArrayList<InventoryCell>();
	private ButtonList buttons = new ButtonList();
	private Font font;
	
	public InvUi() {
		
		font = new Font("Times New Roman", Font.BOLD, 40);
		panel = new BBpanel(60, 30, 360, 360, new BBlabel(0, 0, 360, 50, "Inventory"));
		descPanel = new BBpanel(60, 400, 360, 70);
		this.updateInventory();
	}
	
	public void updateInventory() {
		cells.clear();
		//The loop goes through the inventory of the player and creates a corresponding amount of cells for each unique item the player has
		int row = 0;
		int column =  0;
		for(int i = 0; i < Player.inv.inventorySize(); i++) {
			//rows and columns control the placement of cells within the inventory -> max out 25 unique items in the inventory.
			if(column < 5) {
				invButton = new Button(99+(column*62), 99+(row*62), 33, 33);
				invCell = new InventoryCell(99+(column*62), 99+(row*62), 33, 33, Player.inv.getItem(i));
				column++;
				cells.add(invCell);
				buttons.addButton(invButton);
			}
			else {
				column = 0;
				row++;
				invButton = new Button(99+(column*62), 99+(row*62), 33, 33);
				invCell = new InventoryCell(99+(column*62), 99+(row*62), 33, 33, Player.inv.getItem(i));
				cells.add(invCell);
				buttons.addButton(invButton);
				column++;
			}
			
		}
		System.out.println(cells.size());
		System.out.println("one iteration");
		System.out.println(buttons.buttonIndex());
	}
	
	public void update() {
		if(Player.inv.inventorySize() > 0) {
			descPanel = new BBpanel(60, 400, 360, 70, new BBlabel(0, 0, 360, 30, (Player.inv.getItem(buttons.buttonIndex())).getName()), new BBlabel(0, 13, 360, 30, (Player.inv.getItem(buttons.buttonIndex())).getDesc()), new BBlabel(0, 26, 360, 30, ("Quantity: x" + (Player.inv.getItem(buttons.buttonIndex())).getQuant())), new BBlabel(0, 39, 360, 30, ("Worth: " + (Player.inv.getItem(buttons.buttonIndex())).getWorth())));
		}
		descPanel.update();
		panel.update();
		buttons.update();
		//Controls
//		buttons.getButton(buttons.buttonIndex()).onClick(KeyEvent.VK_Z, () -> {interactionMenu();});
	}
	
	public void render(Graphics2D graphics) {
		graphics.setFont(font);
		
		panel.render(graphics);
		
		graphics.setFont(new Font("Times New Roman", 0, 15));
		descPanel.render(graphics);
		
		for(int i = 0; i < cells.size(); i++) {
			cells.get(i).render(graphics);
			cells.get(i).getItem().getIconPath().render(graphics, cells.get(i).getX()+1, cells.get(i).getY()+1, cells.get(i).getItem().getSpriteIndex());
			buttons.render(graphics);
		}
		
	}

}
