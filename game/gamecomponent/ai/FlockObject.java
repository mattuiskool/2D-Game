package game.gamecomponent.ai;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import core.util.Vector;
import game.gamecomponent.GameComponent;
import game.gameobject.GameObject;
import layers.Layer;

public class FlockObject extends GameObject{
	
	private Vector averageVelocity;
	private Vector centreOfMass;
	
	public List<AgentObject> children = new ArrayList<AgentObject>();

	public FlockObject(Layer layer) {
		super(layer);
	}
	
	public void onUpdate() {
		super.onUpdate();
		for(GameObject o : children) {
			o.onUpdate();
		}
	}
	
	public void onRender(Graphics g) {
		super.onRender(g);
		for(GameObject o : children) {
			o.onRender(g);
		}
	}
	
	public void calculateAverageVelocity() {
		averageVelocity = new Vector();
		for(AgentObject a : children) {
			averageVelocity = averageVelocity.add(a.getVelocity().normalise());
		}
		averageVelocity = averageVelocity.divide(children.size());
	}
	
	public GameObject addChild(AgentObject o){
		if(o.parent != null){
			o.parent.children.remove(o);
		}
		children.add(o);
		o.parent = this;
		return this;
	}

}
