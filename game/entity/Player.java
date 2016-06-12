package game.entity;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import core.Window;
import game.entity.item.Item;
import game.level.Level;
import game.weapon.MachineGun;
import game.weapon.Shotgun;

public class Player extends Entity{

	public Player(Level level) {
		super(Color.red, new Rectangle(Window.width/2 - 10, Window.height/2 - 10, 20, 20), level);
		weapon = new MachineGun(this);
		stats.speed = 2;
	}
	
	public void onInput(){
		if(getKeys()[KeyEvent.VK_W]){
			box.y-= stats.speed;
		} else if(getKeys()[KeyEvent.VK_S]) {
			box.y+= stats.speed;
		}
		if(getKeys()[KeyEvent.VK_A]){
			box.x-= stats.speed;
		} else if(getKeys()[KeyEvent.VK_D]) {
			box.x+= stats.speed;
		}
	}
	
	public void damage(int amount){
		if(stats.vulnerable){
			stats.health -= amount;
			stats.vulnerable = false;
		}
		if(stats.health <= 0){
			kill();
		}
	}
	
	public void isTouching(Entity e){
		if(Item.class.isAssignableFrom(e.getClass())){
			Item i = (Item) e;
			i.kill();
			i.onPickup(this);
		}
	}

	public void onUpdate(){
		super.onUpdate();
		int x = getMouseX() - box.x;
		int y = getMouseY() - box.y;
		double dir = 90 - Math.toDegrees(Math.atan2(x, y));
		weapon.update(dir, this.getMouseButtons()[1]);
		
		if(box.x < -box.width){
			box.x = Window.width;
		} else if(box.x > Window.width){
			box.x = -box.width;
		}
		if(box.y < -box.height){
			box.y = Window.height - box.height;
		} else if(box.y > Window.height - box.height) {
			box.y = -box.height;
		}
	}
	
	public void kill() {
		super.kill();
	}
	

}
