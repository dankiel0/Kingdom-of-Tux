package ui;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import game.input.Keyboard;

public class ButtonList
{
	private ArrayList<Button> buttons;
	
	private int selectedButtonIndex;
	
	public ButtonList()
	{
		buttons = new ArrayList<Button>();
	}
	
	public void addButton(Button button)
	{
		buttons.add(button);
	}
	public void clearButtons() {
		buttons.clear();
	}
	
	public void changeButtonIndex(int num) {
		selectedButtonIndex += num;
	}
	
	public int buttonIndex() {
		return selectedButtonIndex;
	}
	
	public Button getButton(int i) {
		return buttons.get(i);
	}
	
	public void update()
	{
		if(Keyboard.keyClicked(KeyEvent.VK_RIGHT))
		{
			selectedButtonIndex++;
		}
		
		if(Keyboard.keyClicked(KeyEvent.VK_LEFT))
		{
			selectedButtonIndex--;
		}
		
		if(Keyboard.keyClicked(KeyEvent.VK_UP))
		{
			selectedButtonIndex--;
		}
		
		if(Keyboard.keyClicked(KeyEvent.VK_DOWN))
		{
			selectedButtonIndex++;
		}
		
		if(selectedButtonIndex < 0)
		{
			selectedButtonIndex = 0;
		}
		
		if(selectedButtonIndex > buttons.size() - 1)
		{
			selectedButtonIndex = buttons.size() - 1;
		}
		
		for(int i = 0; i < buttons.size(); i++)
		{
			if(i == selectedButtonIndex)
			{
				buttons.get(i).update(true);
			}
			else
			{
				buttons.get(i).update(false);
			}
		}
	}
	
	public void render(Graphics2D graphics)
	{
		for(int i = 0; i < buttons.size(); i++)
		{
			if(i == selectedButtonIndex)
			{
				buttons.get(i).render(graphics, true);
			}
			else
			{
				buttons.get(i).render(graphics, false);
			}
		}
	}
}
