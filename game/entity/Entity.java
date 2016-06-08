package game.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import events.types.KeyPressedEvent;
import events.types.KeyReleasedEvent;
import events.types.MouseMovedEvent;
import events.types.MousePressedEvent;
import events.types.MouseReleasedEvent;
import game.level.Level;
import game.weapon.Weapon;

public class Entity {
	
	public Rectangle box;
	public Color color;
	public Level level;
	protected Weapon weapon;
	protected double speed;
	public boolean vulnerable = true;
	protected int vulnerableCount;
	public boolean visible = true;
	public int health = 100;
	
	protected boolean stopped;
	private int stopTimer;
	
	public Entity(Color color, Rectangle box, Level level){
		this.color = color;
		this.box = box;
		this.level = level;
	}
	
	public void damage(int amount){
		health -= amount;
		if(health <= 0){
			kill();
		}
	}
	
	public void isTouching(Entity e) {
		
	}
	
	public void onInput(){
	}
	
	public void onUpdate() {
		
	}
	
	public void kill(){
		level.entities.remove(this);
	}
	
	public void onRender(Graphics g) {
		if(stopTimer == 0){
			stopped = false;
		} else {
			stopped = true;
			stopTimer --;
		}
		g.setColor(color);
		if(!vulnerable){
			vulnerableCount++;
			if(vulnerableCount %10 == 0){
				visible = !visible;
			}
		}
		if(vulnerableCount >= 60){
			vulnerable = true;
			vulnerableCount = 0;
			visible = true;
		}
		if(visible){
			g.fillRect(box.x, box.y, box.width, box.height);			
		}
		g.drawString("Health: " + health, box.x, box.y - 10);
	}
	
	public void spawn(Entity e){
		level.spawn(e);
	}
	
	protected boolean[] getKeys() {
		return level.layer.keys;
	}
	
	protected boolean[] getMouseButtons() {
		return level.layer.mouseButtons;
	}
	
	protected int getMouseX() {
		return level.layer.mouseX;
	}
	
	protected int getMouseY() {
		return level.layer.mouseY;
	}
	
	public void stop(int ticks){
		stopTimer = ticks;
	}

}
