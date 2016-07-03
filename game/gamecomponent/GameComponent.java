package game.gamecomponent;

import java.awt.Graphics;

import game.gameobject.GameObject;

public class GameComponent {
	
	public GameObject parent;
	
	public GameComponent setParent(GameObject parent) {
		this.parent = parent;
		return this;
	}
	
	public void onUpdate() {
		
	}
	
	public void onRender(Graphics g) {
		
	}
	
	public void kill() {
		parent.components.remove(this);
	}

}