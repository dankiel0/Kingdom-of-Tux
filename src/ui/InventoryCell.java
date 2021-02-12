package ui;

import java.awt.Color;
import java.awt.Graphics2D;

public class InventoryCell {
	private double x;
	private double y;
	
	private int width;
	private int height;
	
	private Item item;
	private Equipment equipment;
	
	public InventoryCell(double x, double y, int w, int h, Item item) {
		this.x = x;
		this.y = y;
		
		this.width = w;
		this.height = h;
		
		this.item = item;
	}
	public InventoryCell(double x, double y, int w, int h) {
		this.x = x;
		this.y = y;
		
		this.width = w;
		this.height = h;
	}
	public InventoryCell(double x, double y, int w, int h, Equipment equipment) {
		this.x = x;
		this.y = y;
		
		this.width = w;
		this.height = h;
		
		this.equipment  = equipment;
	}
	
	public void render(Graphics2D graphics) {
		graphics.setColor(new Color(255, 0, 0));
		graphics.drawRect((int) x, (int) y, width, height);
		// draw item
		// should be something like:
		// item.drawIcon();
		
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Item getItem() {
		return item;
	}
	
	public Equipment getEquipment() {
		return equipment;
	}
}
