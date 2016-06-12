package game.entity.spawner;

import game.entity.BaseEnemy;
import game.level.Level;

public class BaseEnemySpawner extends Spawner{

	public BaseEnemySpawner(Level level, int maxSpawns, int health, int x, int y) {
		super(level, maxSpawns, health, x, y);
	}
	
	public void onUpdate() {
		tick++;
		if(tick >= spawnTime){
			BaseEnemy e = new BaseEnemy(box.x, box.y, level, level.player, health);
			level.spawn(e);
			spawned++;
			tick = 0;
		}
		if(spawned >= maxSpawns){
			this.kill();
		}
	}

}
