package game.gameobject;

import java.awt.Graphics;

import layers.Layer;

public class ProjectileObject extends GameObject{

	private double angle;
	private int speed = 5;
	private double x, y;
	
	public ProjectileObject(Layer layer, double angle) {
		super(layer);
		this.angle = angle;
	}
	
	public double getX() {
		return (int) x;
	}
	public double getY() {
		return (int) y;
	}
	
	public ProjectileObject setX(double x){
		this.x = x;
		return this;
	}
	public ProjectileObject setY(double y){
		this.y = y;
		return this;
	}
	
	public void onUpdate() {
		super.onUpdate();
		double xa;
		double ya;
		
		xa = Math.cos(Math.toRadians(angle)) * speed;
		ya = Math.sin(Math.toRadians(angle)) * speed;
		
		x += xa;
		y += ya;
	}
	
	public void onRender(Graphics g) {
		super.onRender(g);
		g.setColor(getColor());
		g.fillRect((int)getX(), (int)getY(), 10, 10);
	}

}
