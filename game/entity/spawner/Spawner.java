package game.entity.spawner;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.entity.BaseEnemy;
import game.entity.Entity;
import game.level.Level;

public class Spawner extends Entity{
	
	public int spawnTime = 60;
	public int spawned;
	public int maxSpawns;
	protected int health;
	
	protected int tick;
	
	public Spawner(Level level, int maxSpawns, int health, int x, int y) {
		super(null, new Rectangle(x, y, 0, 0), level);
		this.spawnTime = spawnTime;
		this.maxSpawns = maxSpawns;
		this.health = health;
	}
	
	public Spawner setSpawnTime(int spawnTime) {
		this.spawnTime = spawnTime;
		return this;
	}
	
	public void onRender(Graphics g) {
		
	}
	
	

}
