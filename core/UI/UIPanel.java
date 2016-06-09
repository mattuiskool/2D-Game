package core.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.Game;
import layers.Layer;
import layers.UILayer;

public class UIPanel extends UIComponent{
	
	public Rectangle box;

	public UIPanel(String name, UILayer layer, Color color, Rectangle box) {
		super(name, layer, color);
		this.box = box;
	}
	
	public void onRender(Graphics g) {
		g.setColor(color);
		g.fillRect(box.x, box.y, box.width, box.height);
	}

}
