package core.UI;

import java.awt.Color;
import java.awt.Graphics;

import layers.UILayer;

public class UITextField extends UIComponent{
	
	private String text;
	private int x, y;

	public UITextField(String name, UILayer layer, Color color, String text, int x, int y) {
		super(name, layer, color);
		this.text = text;
		this.x = x;
		this.y = y;
	}
	
	public void onRender(Graphics g) {
		g.setColor(color);
		g.drawString(text, x, y);
	}
	
	public void setText(String text) {
		this.text = text;
	}

}
