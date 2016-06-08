package game.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import core.Window;
import game.level.Level;

public class Projectile extends Entity{
	
	public double direction;
	public float speed;
	public int size;
	public int lifespan;
	private double x, y;
	private double currentSize;
	private int time;
	
	
	public int damage = 100;
	
	public Entity owner;

	public Projectile(double direction, float speed, int lifespan, int damage, Color color, Rectangle box, Level level, Entity owner) {
		super(color, box, level);
		this.direction = direction;
		this.speed = speed;
		this.lifespan = lifespan;
		x = box.x;
		y = box.y;
		this.damage = damage;
		this.size = box.width;
	}
	
	public void onUpdate() {
		time++;
		double xa = speed * Math.cos(Math.toRadians(direction));
		double ya = speed * Math.sin(Math.toRadians(direction));
		x += xa;
		y += ya;
		
		box.x = (int) x;
		box.y = (int) y;
		
		if(time >= lifespan){
			kill();
		}
		currentSize = size * (lifespan - time) / (double)lifespan;
		box.width = (int) currentSize;
		box.height = (int) currentSize;
		if(box.x < 0 || box.x > Window.width || box.y < 0 || box.y > Window.height){
			kill();
		}
	}
	
	public void onRender(Graphics g) {
		g.setColor(color);
		g.fillRect(box.x, box.y, box.width, box.height);
	}

}
