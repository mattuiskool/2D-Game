package core.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.Game;

public class UIPanel extends UIComponent{
	
	public Rectangle box;

	public UIPanel(Game game, Color color, Rectangle box) {
		super(game, color);
		this.box = box;
	}
	
	public void onRender(Graphics g) {
		g.setColor(color);
		g.fillRect(box.x, box.y, box.width, box.height);
	}

}
