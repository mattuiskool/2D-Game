package core.UI;

import java.awt.Color;
import java.awt.Graphics;

import events.Event;
import layers.ui.Menu;

public class UIComponent {
	
	public Color color;
	public Menu menu;
	protected String name;
	
	public UIComponent(String name, Menu menu, Color color){
		this.color = color;
		this.menu = menu;
		this.name = name;
		menu.components.add(this);
	}
	
	public void onEvent(Event event) {
		
	}
	
	public void onRender(Graphics g) {
		
	}
	
	public void onUpdate() {
		
	}
	
	public String getName() {
		return name;
	}

}
