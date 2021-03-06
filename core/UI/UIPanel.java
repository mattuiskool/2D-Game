package core.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import layers.ui.Menu;

public class UIPanel extends UIComponent{
	
	public Rectangle box;

	public UIPanel(String name, Menu menu, Color color, Rectangle box) {
		super(name, menu, color);
		this.box = box;
	}
	
	public void onRender(Graphics g) {
		g.setColor(color);
		g.fillRect(box.x, box.y, box.width, box.height);
	}

}
