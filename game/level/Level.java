package game.level;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import game.entity.BaseEnemy;
import game.entity.Enemy;
import game.entity.Entity;
import game.entity.Player;
import game.entity.spawner.BaseEnemySpawner;
import game.entity.spawner.Spawner;
import layers.GameLayer;

public class Level {
	
	public List<Entity> entities = new ArrayList<Entity>();
	public List<Enemy> enemies = new ArrayList<Enemy>();
	public Player player;
	public int currentLevel;
	public GameLayer layer;
	public int score;
	public int killed;
	
	public Level(GameLayer layer) {
		this.layer = layer;
		this.player = new Player(this);
		entities.add(player);
		//entities.add(new BaseEnemy(0, 0, this, player, 50));
		startLevel(1);
	}
	
	public void onRender(Graphics g) {
		for(Entity entity : entities){
			if(entity.stats.visible){
				entity.onRender(g);				
			}
		}
	}
	
	public void onUpdate() {
		for(int i = 0; i < entities.size(); i++){
			Entity e = entities.get(i);
			if(Enemy.class.isAssignableFrom(e.getClass())){
				if(!(enemies.contains(e))){
					enemies.add((Enemy) e);					
				}
			}
		}
		for(int i = 0; i < enemies.size(); i++){
			Entity e = enemies.get(i);
			if(!entities.contains(e)){
				enemies.remove(i);
			}
		}
		
		for(int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.onUpdate();
		}
		for(int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			for(int j = 0; j < entities.size(); j++){
				Entity entity2 = entities.get(j);
				if(entity2 == entity){
					continue;
				}
				if(entity.box.intersects(entity2.box)){
					entity.isTouching(entity2);
				}
			}
		}
		//System.out.println(enemies.size());
		
		if(currentLevel >=4){
			if(killed >= (currentLevel + 1)*4){
				
			}
		} else {
			if(killed >= (currentLevel + 1) * currentLevel){		
				
			}
		}
	}
	
	public void startLevel(int level) {
		killed = 0;
		currentLevel = level;
		if(!(level < 4)) level = 4;
		for(int i = 0; i < level; i++){
			entities.add(new BaseEnemySpawner(this, currentLevel + 1, 50 + currentLevel/2, i % 2 * 1600, (i/2) % 2 * 900).setSpawnTime(20));
		}
	}
	
	public void onInput() {
		for(Entity entity : entities) {
			entity.onInput();
		}
	}
	
	public void spawn(Entity e){
		entities.add(e);
	}

}
