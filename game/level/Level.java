package game.level;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import game.entity.BaseEnemy;
import game.entity.Entity;
import game.entity.Player;
import game.entity.spawner.Spawner;
import layers.GameLayer;

public class Level {
	
	public List<Entity> entities = new ArrayList<Entity>();
	public Player player;
	public int currentLevel;
	public GameLayer layer;
	public int score;
	
	public Level(GameLayer layer) {
		this.layer = layer;
		this.player = new Player(this);
		entities.add(player);
		entities.add(new Spawner(this, new BaseEnemy(40, 40, this, player), 60));
	}
	
	public void onRender(Graphics g) {
		for(Entity entity : entities){
			entity.onRender(g);
		}
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
	}
	
	public void startLevel(int level) {
		
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
