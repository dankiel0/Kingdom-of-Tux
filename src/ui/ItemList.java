package ui;

import game.assetLoaders.ImageLoader;
import game.spritesheet.SpriteSheet;

public class ItemList {
	public static Item Tunic = new Item("Tunic", "Basic Clothing", 0, 50, new SpriteSheet(ImageLoader.loadImage("assets/itemsprites.png"), 32, 32), 0);
	public static Item A = new Item("My", "Apple", 0, 50, new SpriteSheet(ImageLoader.loadImage("assets/itemsprites.png"), 32, 32), 1);
	public static Item B = new Item("name", "bottom", 0, 50, new SpriteSheet(ImageLoader.loadImage("assets/itemsprites.png"), 32, 32), 2);
	public static Item C = new Item("is", "jeans", 0, 50, new SpriteSheet(ImageLoader.loadImage("assets/itemsprites.png"), 32, 32), 3);
	public static Item D = new Item("Antonio", "boots", 0, 50, new SpriteSheet(ImageLoader.loadImage("assets/itemsprites.png"), 32, 32), 4);
	public static Item E = new Item("I", "with", 0, 50, new SpriteSheet(ImageLoader.loadImage("assets/itemsprites.png"), 32, 32), 5);
	public static Item F = new Item("don't", "the", 0, 50, new SpriteSheet(ImageLoader.loadImage("assets/itemsprites.png"), 32, 32), 6);
	public static Item G = new Item("have", "fur", 0, 50, new SpriteSheet(ImageLoader.loadImage("assets/itemsprites.png"), 32, 32), 7);
	public static Item H = new Item("bread", "the", 0, 50, new SpriteSheet(ImageLoader.loadImage("assets/itemsprites.png"), 32, 32), 8);
	public static Item I = new Equipment("Edwin", "game", 0, 50, new SpriteSheet(ImageLoader.loadImage("assets/itemsprites.png"), 32, 32), 9, 0, 0, 0, 0, 0, 0, 0, "Chestpiece");
	public static Item J = new Item("J", "A basic wooden sword", 0, 50, new SpriteSheet(ImageLoader.loadImage("assets/itemsprites.png"), 32, 32), 10);
	public static Item K = new Item("K", "A basic wooden sword", 0, 50, new SpriteSheet(ImageLoader.loadImage("assets/itemsprites.png"), 32, 32), 11);
	public static Item L = new Item("L", "A basic wooden sword", 0, 50, new SpriteSheet(ImageLoader.loadImage("assets/itemsprites.png"), 32, 32), 12);
	public static Item M = new Item("M", "A basic wooden sword", 0, 50, new SpriteSheet(ImageLoader.loadImage("assets/itemsprites.png"), 32, 32), 13);
	public static Item N = new Item("N", "A basic wooden sword", 0, 50, new SpriteSheet(ImageLoader.loadImage("assets/itemsprites.png"), 32, 32), 14);
	
	
	
	

}
