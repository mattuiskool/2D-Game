package game.entity;

import java.awt.Color;
import java.awt.Rectangle;

import game.level.Level;
import layers.LayerManager;

public class Enemy extends Entity{
	
	private Entity target;
	private double x, y;
	public int score;

	public Enemy(Color color, Rectangle box, Level level, Entity target) {
		super(color, box, level);
		this.target = target;
		speed = 2;
		x = box.x;
		y = box.y;
	}
	
	public void kill(){
		level.entities.remove(this);
		level.score += 10;
	}
	
	public void onUpdate() {
		int dx = target.box.x - box.x;
		int dy = target.box.y - box.y;
		
		double angle = Math.toRadians(90) - Math.atan2(dx, dy);
		
		double ax = Math.cos(angle);
		double ay = Math.sin(angle);
		
		if(!stopped){
			x += ax * speed;
			y += ay * speed;			
		}
		
		box.x = (int) x;
		box.y = (int) y;
	}
	
	public void isTouching(Entity e){
		if(Projectile.class.isAssignableFrom(e.getClass())){
			Projectile p = (Projectile) e;
			damage(p.damage);
			p.kill();
		}
	}

}
