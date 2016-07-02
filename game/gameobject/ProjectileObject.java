package game.gameobject;

import java.awt.Graphics;

import layers.Layer;

public class ProjectileObject extends GameObject{

	private double angle;
	
	public ProjectileObject(Layer layer, double angle) {
		super(layer);
		this.angle = angle;
	}
	
	public void onUpdate() {
		super.onUpdate();
		
		this.getVelocity().x = Math.cos(Math.toRadians(angle)) * getSpeed();
		this.getVelocity().y = Math.sin(Math.toRadians(angle)) * getSpeed();
	}
	
	public void onRender(Graphics g) {
		super.onRender(g);
		g.setColor(getColor());
		g.fillRect((int)getX(), (int)getY(), 10, 10);
	}

}
