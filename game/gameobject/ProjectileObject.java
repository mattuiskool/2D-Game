package game.gameobject;

import java.awt.Graphics;

import core.Window;
import game.gamecomponent.EnemyComponent;
import layers.Layer;

public class ProjectileObject extends GameObject{

	private double angle;
	private int lifeSpan = 60*15;
	
	public ProjectileObject(Layer layer, double angle) {
		super(layer);
		this.angle = angle;
	}
	
	public void onUpdate() {
		super.onUpdate();
		lifeSpan--;
		if(lifeSpan <= 0){
			kill();
		}
		
		this.getVelocity().x = Math.cos(Math.toRadians(angle)) * getSpeed();
		this.getVelocity().y = Math.sin(Math.toRadians(angle)) * getSpeed();
		
		calcCollisions();
		
		if(getPosition().x < 0 || getPosition().x > Window.width || getPosition().y < 0 || getPosition().y > Window.height) {
			this.kill();
		}
	}
	
	private void calcCollisions()  {
		for(GameObject o : EnemyComponent.enemies) {
			
		}
		for(int i = 0; i < EnemyComponent.enemies.size(); i++) {
			GameObject o = EnemyComponent.enemies.get(i);
			if(o.getBox().intersects(getBox())){
				o.damage(5);
				this.kill();
			}
		}
	}
	
	public void onRender(Graphics g) {
		super.onRender(g);
		g.setColor(getColor());
		g.fillRect((int)getX(), (int)getY(), 10, 10);
	}

}
