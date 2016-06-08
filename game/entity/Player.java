package game.entity;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

import core.Window;
import events.types.MouseMovedEvent;
import events.types.MousePressedEvent;
import events.types.MouseReleasedEvent;
import game.level.Level;
import game.weapon.MachineGun;
import game.weapon.Pistol;
import game.weapon.Shotgun;

public class Player extends Entity{

	public Player(Level level) {
		super(Color.red, new Rectangle(Window.width/2 - 10, Window.height/2 - 10, 20, 20), level);
		weapon = new MachineGun(this);
		speed = 2;
	}
	
	public void onInput(){
		if(getKeys()[KeyEvent.VK_W]){
			box.y-= speed;
		} else if(getKeys()[KeyEvent.VK_S]) {
			box.y+= speed;
		}
		if(getKeys()[KeyEvent.VK_A]){
			box.x-= speed;
		} else if(getKeys()[KeyEvent.VK_D]) {
			box.x+= speed;
		}
	}
	
	public void damage(int amount){
		if(vulnerable){
			health -= amount;
			vulnerable = false;
		}
		if(health <= 0){
			kill();
		}
	}
	
	public void isTouching(Entity e){
		if(Enemy.class.isAssignableFrom(e.getClass())){
			damage(5);
			e.stop(10);
		}
	}

	public void onUpdate(){
		int x = getMouseX() - box.x;
		int y = getMouseY() - box.y;
		double dir = 90 - Math.toDegrees(Math.atan2(x, y));
		weapon.update(dir, this.getMouseButtons()[1]);
		
	}
	
	public void kill() {
		super.kill();
	}
	

}
