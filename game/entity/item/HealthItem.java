package game.entity.item;

import java.awt.Color;
import java.awt.Graphics;

import game.level.Level;

public class HealthItem extends Item{

	public HealthItem(Level level, int x, int y) {
		super(Color.red, level, x, y);
	}
	
	public void onRender(Graphics g) {
		g.setColor(color);
		g.fillRect(box.x, box.y + 5, 16, 6);
		g.fillRect(box.x + 5, box.y, 6, 16);			
	}

}
