package game.gameobject;

import java.awt.Color;
import java.awt.event.KeyEvent;

import core.util.Vector;
import game.gamecomponent.*;
import layers.Layer;

public class PlayerObject extends GameObject{
	
	private GameComponent renderer;
	private LabelComponent label;
	private MovementComponent movement;
	

	public PlayerObject(Layer layer) {
		super(layer);
		renderer = new RenderComponent();
		label = new LabelComponent();
		movement = new MovementComponent();
		addComponent(renderer);
		addComponent(label);
		addComponent(movement);
		this.setColor(Color.blue);
	}
	
	int time;
	
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
		label.setString("Health: " + getHealth());
		
		time++;
		
		double angle = 0;
		if(layer.mouseButtons[1] && time%5 == 0){
			Vector d = layer.mousePosition.subtract(getPosition());
			angle = 90 - Math.toDegrees(Math.atan2(d.x, d.y));
			//this.addChild(new ProjectileObject(layer, angle+10).setX(getX()).setY(getY()).setSpeed(15));
		//	this.addChild(new ProjectileObject(layer, angle+5).setX(getX()).setY(getY()).setSpeed(15));
			this.addChild(new ProjectileObject(layer, angle).setX(getX()).setY(getY()).setSpeed(15));
			//this.addChild(new ProjectileObject(layer, angle-5).setX(getX()).setY(getY()).setSpeed(15));
			//this.addChild(new ProjectileObject(layer, angle-10).setX(getX()).setY(getY()).setSpeed(15));
		}
	}
	
	

}
