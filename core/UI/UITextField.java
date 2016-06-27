package core.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import layers.ui.Menu;

public class UITextField extends UIComponent{
	
	private String text;
	private int x, y;

	public UITextField(String name, String text, Menu menu, Color color, int x, int y) {
		super(name, menu, color);
		this.text = text;
		this.x = x;
		this.y = y;
	}
	
	public void onRender(Graphics g) {
		g.setColor(color);
		g.setFont(new Font("SansSerif", Font.PLAIN, 24));
		g.drawString(text, x, y);
	}
	
	public void setText(String text) {
		this.text = text;
	}

}
