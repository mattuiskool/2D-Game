package core.UI;

import java.awt.Color;
import java.awt.Graphics;

import events.Event;
import layers.UILayer;

public class UIComponent {
	
	public Color color;
	public UILayer layer;
	protected String name;
	
	public UIComponent(String name, UILayer layer, Color color){
		this.color = color;
		this.layer = layer;
		this.name = name;
		layer.components.add(this);
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
