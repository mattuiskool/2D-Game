package core.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import layers.LayerManager;

public class UIComponent {
	
	public Rectangle box;
	public Color color;
	
	public UIComponent(Rectangle box, Color color){
		this.box = box;
		this.color = color;
	}
	
	public void onRender(Graphics g) {
		g.setColor(color);
		g.fillRect(box.x, box.y, box.width, box.height);
		
		g.setColor(Color.BLACK);
		g.drawString("Score: " + LayerManager.score, 5, 15 );
	}

}
