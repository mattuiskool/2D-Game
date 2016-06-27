package game.gamecomponent;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import game.gameobject.GameObject;

public class PhysicsComponent extends GameComponent{
	
	public Rectangle collisionBox;
	private boolean evaluated;
	public static List<GameObject> colliders = new ArrayList<GameObject>();
	
	public PhysicsComponent(){
	}
	
	public void onUpdate() {
		if(collisionBox == null){
			collisionBox = new Rectangle(parent.getX(), parent.getY(), parent.getWidth(), parent.getHeight());
		}
		if(!evaluated){
			colliders.add(parent);
			evaluated = true;
		}
	}
	
}
