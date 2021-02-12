package ui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import game.input.Keyboard;
import game.spritesheet.SpriteSheet;

public class Button
{
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private String text;
	
	private SpriteSheet icon;
	
	// when this key is clicked,
	// the event is triggered.
	private int keyCode;
	
	// the event listener.
	private ClickListener listener;
	
	public Button(int buttonX, int buttonY, int buttonWidth, int buttonHeight)
	{
		x = buttonX;
		y = buttonY;
		
		width = buttonWidth;
		height = buttonHeight;
	}
	
	public void setText(String buttonText)
	{
		text = buttonText;
	}
	
	public void setIcon(SpriteSheet buttonIcon)
	{
		icon = buttonIcon;
	}
	
	public String getText()
	{
		return text;
	}
	
	public void update(boolean isSelected)
	{
		if(isSelected && listener != null && Keyboard.keyClicked(keyCode))
		{
			listener.doAction();
		}
	}
	
	public void render(Graphics2D graphics, boolean isSelected)
	{
		if(isSelected)
		{
			graphics.setColor(Color.red);
		}
		else
		{
			graphics.setColor(Color.BLACK);
		}
		
		graphics.drawRect(x, y, width, height);
		
		if(text != null)
		{
			FontMetrics metrics = graphics.getFontMetrics();
			
			int centeredX = x + (width - metrics.stringWidth(text)) / 2;
			int centeredY = y + ((height - metrics.getHeight()) / 2) + metrics.getAscent();
			
			graphics.drawString(text, centeredX, centeredY);
		}
		
		if(icon != null)
		{
			icon.render(graphics, x + (width - icon.getSpriteWidth()) / 2, y + (height - icon.getSpriteHeight()) / 2);
		}
	}
	
	// sets the event listener action.
	public void onClick(int buttonKeyCode, ClickListener clickListener)
	{
		keyCode = buttonKeyCode;
		listener = clickListener;
	}
	
	@FunctionalInterface
	public interface ClickListener
	{
		public void doAction();
	}
}
