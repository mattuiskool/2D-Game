package game.entity.item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.entity.Entity;
import game.level.Level;

public class Item extends Entity{
	
	private int timer;
	protected int lifeTime = 60*60;

	public Item(Color color, Level level, int x, int y) {
		super(color, new Rectangle(x, y, 10, 10), level);
	}
	
	public void onUpdate() {
		timer++;
		if(timer >= lifeTime - 60*10){
			stats.vulnerable = false;
		}
		if(timer >= lifeTime){
			kill();
		}
		if(!stats.vulnerable){
			vulnerableCount++;
			if(vulnerableCount %10 == 0){
				stats.visible = !stats.visible;
			}
		}
		if(vulnerableCount >= 60*10){
			stats.vulnerable = true;
			vulnerableCount = 0;
			stats.visible = true;
		}
	}
	
	public void onPickup(Entity e){
		e.stats.health += 5;
	}
	
	public void damage(int amount){
		
	}
	
	public void onRender(Graphics g){
		g.setColor(color);
		g.fillRect(box.x, box.y, box.width, box.height);
	}

}
