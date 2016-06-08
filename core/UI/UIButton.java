package core.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import events.EventHandler;
import events.types.KeyPressedEvent;
import events.types.KeyReleasedEvent;
import events.types.MouseMovedEvent;
import events.types.MousePressedEvent;
import events.types.MouseReleasedEvent;
import layers.UILayer;

public class UIButton extends UIComponent{
	
	public String text;
	public Rectangle box;
	private int padding = 10;

	public UIButton(UILayer layer, Color color, String text, Rectangle box, EventHandler event) {
		super(layer, color);
		this.text = text;
		this.box = box;
	}
	
	public boolean onMousePressed(MousePressedEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			if(box.contains(new Point(e.getX(), e.getY()))){
				onPress();
				return true;
			}
		}
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
		g.setColor(color);
		g.fillRect(box.x, box.y, box.width, box.height);
		g.setColor(Color.white);
		g.drawString(text, box.x + padding, box.y + padding);;
	}
	
	public void setPadding(int padding) {
		this.padding = padding;
	}
	
	public void onPress() {
		
	}

}
