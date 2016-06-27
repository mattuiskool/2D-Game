package game.level;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import core.Window;
import game.entity.Enemy;
import game.entity.Entity;
import game.entity.Player;
import game.entity.spawner.BaseEnemySpawner;
import layers.GameLayer;

public class Level {
	
	public List<Entity> entities = new ArrayList<Entity>();
	public Player player;
	public int currentLevel;
	public GameLayer layer;
	public int killed;
	
	
	public Level(GameLayer layer) {
		this.layer = layer;
		this.player = new Player(this);
		entities.add(player);
		startLevel(1);
	}
		
	public void onRender(Graphics g) {
		for(Entity entity : entities){
			if(entity.stats.visible){
				entity.onRender(g);				
			}
		}
		g.setColor(Color.black);
		g.drawString("Entities: " + entities.size(), 5, 15);
	}
	
	public void onUpdate() {		
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
			entities.add(new BaseEnemySpawner(this, currentLevel + 1, 50 + currentLevel/2, i % 2 * layer.width, (i/2) % 2 * layer.height).setSpawnTime(20));
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
