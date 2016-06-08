package core.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import events.types.KeyPressedEvent;
import events.types.KeyReleasedEvent;
import events.types.MouseMovedEvent;
import events.types.MousePressedEvent;
import events.types.MouseReleasedEvent;
import game.Game;
import layers.Layer;
import layers.LayerManager;
import layers.UILayer;

public class UIComponent {
	
	public Color color;
	public UILayer layer;
	
	public UIComponent(UILayer layer, Color color){
		this.color = color;
		this.layer = layer;
	}
	
	public boolean onMousePressed(MousePressedEvent e) {
		
		return false;
	}
	public boolean onMouseReleased(MouseReleasedEvent e) {
		return false;
	}
	public boolean onMouseMoved(MouseMovedEvent e) {
		return false;
	}
	
	public boolean onKeyPressed(KeyPressedEvent e) {
		return false;
	}
	
	public boolean onKeyReleased(KeyReleasedEvent e) {
		return false;
	}
	
	public void onRender(Graphics g) {
		
	}
	
	public void onUpdate() {
		
	}

}
