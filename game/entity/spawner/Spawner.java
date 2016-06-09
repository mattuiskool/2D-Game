package game.entity.spawner;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.entity.BaseEnemy;
import game.entity.Entity;
import game.level.Level;

public class Spawner extends Entity{
	
	public Entity type;
	public int spawnTime;
	public int spawned;
	
	private int tick;
	
	public Spawner(Level level, Entity type, int spawnTime) {
		super(null, new Rectangle(type.box.x, type.box.y, 0, 0), level);
		this.type = type;
		this.spawnTime = spawnTime;
	}
	
	public void onUpdate() {
		tick++;
		if(tick >= spawnTime){
			BaseEnemy e = new BaseEnemy(box.x, box.y, level, level.player);
			level.spawn(e);
			spawned++;
			tick = 0;
		}
		if(spawned >= 10){
			this.kill();
		}
	}
	
	public void kill() {
		super.kill();
		System.out.println("Killed");
	}
	
	public void onRender(Graphics g) {
		
	}
	
	

}
