package game.gameobject;

import java.awt.Color;
import java.awt.event.KeyEvent;

import core.util.Vector;
import game.gamecomponent.*;
import layers.Layer;

public class PlayerObject extends GameObject{
	
	private GameComponent renderer;
	private LabelComponent label;
	private HealthComponent health;
	private MovementComponent movement;
	

	public PlayerObject(Layer layer) {
		super(layer);
		renderer = new RenderComponent();
		label = new LabelComponent();
		health = new HealthComponent().setHealth(100);
		movement = new MovementComponent();
		addComponent(renderer);
		addComponent(label);
		addComponent(health);
		addComponent(movement);
		this.setColor(Color.blue);
	}
	
	public void onUpdate() {
		super.onUpdate();
		if(layer.keys[KeyEvent.VK_W]){
			movement.moveUp();
		}
		if(layer.keys[KeyEvent.VK_S]){
			movement.moveDown();
		}
		if(layer.keys[KeyEvent.VK_A]){
			movement.moveLeft();
		}
		if(layer.keys[KeyEvent.VK_D]){
			movement.moveRight();
		}
		label.setString("Health: " + health.getHealth());
		
		double angle = 0;
		if(layer.mouseButtons[1]){
			Vector d = layer.mousePosition.subtract(getPosition());
			angle = 90 - Math.toDegrees(Math.atan2(d.x, d.y));
			this.addChild(new ProjectileObject(layer, angle).setX(getX()).setY(getY()).setSpeed(15));
		}
	}
	
	

}
