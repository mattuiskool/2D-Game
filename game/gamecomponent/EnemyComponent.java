package game.gamecomponent;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import game.gameobject.GameObject;

public class EnemyComponent extends GameComponent{
	
	public static List<GameObject> enemies = new ArrayList<GameObject>();

	private boolean added = false;
	
	public EnemyComponent() {
	}
	
	public void onUpdate() {
		if(!added){
			enemies.add(parent);
			added = true;
		}
	}
	
	public void kill() {
		super.kill();
		enemies.remove(parent);
	}
	
	public void onRender(Graphics g) {
		
	}

}
