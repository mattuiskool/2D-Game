package game.entity;

import java.awt.Color;
import java.awt.Rectangle;

import game.entity.item.HealthItem;
import game.level.Level;

public class BaseEnemy extends Enemy{

	public BaseEnemy(int x, int y, Level level, Entity target, int health) {
		super(Color.blue, new Rectangle(x, y, 20, 20), level, target);
		this.stats.health = health;
	}
	
	public void onUpdate() {
		super.onUpdate();
		checkCollisions();
	}
	
	public void isTouching(Entity e){
		if(Player.class.isAssignableFrom(e.getClass())){
			e.damage(5);
			stop(10);
		}
	}
	
	public void kill(){
		super.kill();
		if(random.nextInt(100) <= 10){
			this.drop(new HealthItem(level, box.x, box.y));;			
		}
	}

}
