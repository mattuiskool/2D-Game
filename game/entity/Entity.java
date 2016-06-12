package game.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import game.entity.item.Item;
import game.level.Level;
import game.weapon.Weapon;

public class Entity {
	
	public Rectangle box;
	public Color color;
	public Level level;
	protected Weapon weapon;
	protected int vulnerableCount;
	
	public Stats stats;
	
	protected Random random;
	
	protected boolean stopped;
	private int stopTimer;
	
	public Entity(Color color, Rectangle box, Level level){
		this.color = color;
		this.box = box;
		this.level = level;
		random = new Random();
		this.stats = new Stats();
	}
	
	public void damage(int amount){
		stats.health -= amount;
		if(stats.health <= 0){
			kill();
		}
		if(stats.health >= stats.maxHealth){
			stats.health = stats.maxHealth;
		}
	}
	
	public void drop(Item item) {
		level.spawn(item);
	}
	
	public void isTouching(Entity e) {
		
	}
	
	public void onInput(){
	}
	
	public void onUpdate() {
		if(!stats.vulnerable){
			vulnerableCount++;
			if(vulnerableCount %10 == 0){
				stats.visible = !stats.visible;
			}
		}
		if(vulnerableCount >= 90){
			stats.vulnerable = true;
			vulnerableCount = 0;
			stats.visible = true;
		}
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
		
		g.fillRect(box.x, box.y, box.width, box.height);			
		g.drawString("Health: " + stats.health, box.x, box.y - 10);
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
