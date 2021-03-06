package game.ai;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import core.util.Vector;
import game.gameobject.GameObject;
import layers.Layer;

public class FlockObject extends GameObject{
		
	public double separationWeight = 1;
	public double cohesionWeight = 1;
	public double alignmentWeight = 1;
	public double targetWeight = 1;
	public double attractionWeight = 0.2;
	
	public int separationDistance = 300;
	public int neighbourDistance = 5000;
	
	public GameObject target;
	
	public List<FlockAgentComponent> agents = new ArrayList<FlockAgentComponent>();

	public FlockObject(Layer layer, GameObject target) {
		super(layer);
		this.target = target;
	}
	
	public void onUpdate() {
		super.onUpdate();
	}
	
	

}
