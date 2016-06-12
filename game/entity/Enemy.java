package game.entity;

import java.awt.Color;
import java.awt.Rectangle;

import game.level.Level;
import layers.LayerManager;

public class Enemy extends Entity{
	
	private Entity target;
	private double x, y;
	public int score;
	protected double targetAngle;

	public Enemy(Color color, Rectangle box, Level level, Entity target) {
		super(color, box, level);
		this.target = target;
		stats.speed = 2;
		x = box.x;
		y = box.y;
	}
	
	public void kill(){
		level.entities.remove(this);
		level.score += 10;
		level.killed++;
	}
	
	public void onUpdate() {
		int dx = target.box.x - box.x;
		int dy = target.box.y - box.y;
		
		targetAngle = Math.toRadians(90) - Math.atan2(dx, dy);
		
		double ax = Math.cos(targetAngle);
		double ay = Math.sin(targetAngle);
		
		if(!stopped){
			x += ax * stats.speed;
			y += ay * stats.speed;			
		}
		
		box.x = (int) x;
		box.y = (int) y;
	}
	
	public void isTouching(Entity e){
		if(Projectile.class.isAssignableFrom(e.getClass())){
			Projectile p = (Projectile) e;
			if(p.owner.getClass().equals(Player.class)){
				if(p.damage > stats.health){
					p.damage -= stats.health;
					kill();
				} else {					
					damage(p.damage);
					p.kill();					
				}
			}
		}
	}

}
