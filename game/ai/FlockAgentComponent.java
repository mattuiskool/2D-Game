package game.ai;

import java.awt.Color;

import core.util.Vector;
import game.gamecomponent.GameComponent;
import game.gameobject.GameObject;
import layers.Layer;

public class FlockAgentComponent extends GameComponent{
	
	public FlockObject flock;
	
	public FlockAgentComponent(FlockObject f) {
		this.flock = f;
		flock.agents.add(this);
	}
	
	public void onUpdate() {
		super.onUpdate();
		
		Vector cohesion = calcCohesion();
		Vector separation = calcSeparation();
		Vector alignment = calcAlignment();
		Vector attraction = calcAttraction(flock.target);
		
		parent.getVelocity().x += separation.x * flock.separationWeight + cohesion.x * flock.cohesionWeight + alignment.x * flock.alignmentWeight + attraction.x * flock.attractionWeight;
		parent.getVelocity().y += separation.y * flock.separationWeight + cohesion.y * flock.cohesionWeight + alignment.y * flock.alignmentWeight + attraction.y * flock.attractionWeight;
		
		parent.setVelocity(parent.getVelocity().normalise());
		
		parent.changeX(parent.getVelocity().x * parent.getSpeed());
		parent.changeY(parent.getVelocity().y * parent.getSpeed());
	}
	
	private Vector calcAttraction(GameObject target) {
		Vector result = new Vector();
		result.x = target.getX() - parent.getX();
		result.y = target.getY() - parent.getY();
		double scale = result.getLengthSquared() / flock.neighbourDistance;
		
		result.x /= scale;
		result.y /= scale;
		
		return result.normalise();
	}
	
	private Vector calcAlignment() {
		Vector result = new Vector();
		int neighbours = 0;
		for(FlockAgentComponent o : flock.agents) {
			if(!o.equals(this) && parent.getPosition().subtract(o.parent.getPosition()).getLengthSquared() < flock.neighbourDistance){
				result.x += o.parent.getVelocity().x;
				result.y += o.parent.getVelocity().y;
				neighbours++;
			}
		}
		if(neighbours > 0) {
			result.x /= neighbours;
			result.y /= neighbours;
			return result.normalise();			
		} else {
			return new Vector();
		}
	}
	
	private Vector calcCohesion() {
		Vector result = new Vector();
		int neighbours = 0;
		for(FlockAgentComponent o : flock.agents) {
			if(!o.equals(this) && parent.getPosition().subtract(o.parent.getPosition()).getLengthSquared() < flock.neighbourDistance){
				result.x += o.parent.getX();
				result.y += o.parent.getY();
				neighbours++;
			}
		}
		if(neighbours > 0){
			result.x /= neighbours;
			result.y /= neighbours;
			result.x -= parent.getX();
			result.y -= parent.getY();
			return result.normalise();
		} else {
			System.out.println("hello");
			return new Vector();
		}
	}
	
	private Vector calcSeparation() {
		Vector result = new Vector();
		int neighbours = 0;
		
		double dSquared = 0;
		double scale = 0;
		for(FlockAgentComponent o : flock.agents) {
			if(!o.equals(this) && parent.getPosition().subtract(o.parent.getPosition()).getLengthSquared() < flock.separationDistance){
				result.x += o.parent.getX() - parent.getX();
				result.y += o.parent.getY() - parent.getY();
				neighbours++;
			}
		}
		if(neighbours > 0){
			result.x /= neighbours;
			result.y /= neighbours;
			dSquared = result.getLengthSquared();
			scale = Math.sqrt(dSquared)/Math.sqrt(flock.separationDistance);
			scale = 1-scale;
			result.x *= -1;
			result.y *= -1;	
			result.x *= 2*scale;
			result.y *= 2*scale;
			result = result.normalise();
			return result;
		} else {
			return new Vector();
		}
	}
	
}
