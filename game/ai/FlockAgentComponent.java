package game.ai;

import java.awt.Graphics;

import core.util.Vector;
import game.gamecomponent.GameComponent;
import game.gameobject.GameObject;

public class FlockAgentComponent extends GameComponent{
	
	public FlockObject flock;
	
	public FlockAgentComponent(FlockObject f) {
		this.flock = f;
		flock.agents.add(this);
	}
	
	public void onUpdate() {
		super.onUpdate();
		
		
		Vector flocking = calcFlocking();
		Vector attraction = calcAttraction(flock.target);
		
		
		parent.getVelocity().x += flocking.x + attraction.x;// + attraction.x;
		parent.getVelocity().y += flocking.y + attraction.y;// + attraction.y;
		
		
		parent.setVelocity(parent.getVelocity().normalise());;
		parent.getVelocity().x *= parent.getSpeed();
		parent.getVelocity().y *= parent.getSpeed();
	}
	
	private Vector calcAttraction(GameObject target) {
		Vector result = new Vector();
		result.x = target.getX() - parent.getX();
		result.y = target.getY() - parent.getY();
		double scale = result.getLengthSquared() / (flock.neighbourDistance*6);
		if(parent.getPosition().subtract(target.getPosition()).getLengthSquared() < flock.neighbourDistance){
			result.x *= 1-scale;
			result.y *= 1-scale;			
		} else {
		}
		result = result.normalise();
		
		
		return result;
	}
	
	private Vector calcFlocking() {
		Vector alignmentResult = new Vector();
		Vector cohesionResult = new Vector();
		Vector separationResult = new Vector();
		Vector result = new Vector();
		int neighbours = 0;
		int closeNeighbours = 0;
		
		double dSquared = 0;
		double scale = 0;
		
		for(FlockAgentComponent o : flock.agents){
			if(!o.equals(this) && parent.getPosition().subtract(o.parent.getPosition()).getLengthSquared() < flock.neighbourDistance){
				neighbours++;
				
				//cohesion
				cohesionResult.x += o.parent.getX();
				cohesionResult.y += o.parent.getY();
				
				//alignment
				alignmentResult.x += o.parent.getVelocity().x;
				alignmentResult.y += o.parent.getVelocity().y;
			}
			//separation
			if(!o.equals(this) && parent.getPosition().subtract(o.parent.getPosition()).getLengthSquared() < flock.separationDistance){
				separationResult.x += o.parent.getX() - parent.getX();
				separationResult.y += o.parent.getY() - parent.getY();
				closeNeighbours++;
			}
		}
		
		if(neighbours > 0) {
			//cohesion
			cohesionResult.x /= neighbours;
			cohesionResult.y /= neighbours;
			cohesionResult.x -= parent.getX();
			cohesionResult.y -= parent.getY();
			cohesionResult = cohesionResult.normalise();
			
			//alignment
			alignmentResult.x /= neighbours;
			alignmentResult.y /= neighbours;
			alignmentResult = alignmentResult.normalise();
		} else {
			cohesionResult = new Vector();
			alignmentResult = new Vector();
		}
		
		//separation
		if(closeNeighbours > 0){
			separationResult.x /= closeNeighbours;
			separationResult.y /= closeNeighbours;
			dSquared = separationResult.getLengthSquared();
			scale = Math.sqrt(dSquared)/Math.sqrt(flock.separationDistance);
			scale = 1-scale;
			separationResult.x *= -1;
			separationResult.y *= -1;	
			separationResult.x *= scale;
			separationResult.y *= scale;
		} else {
			separationResult = new Vector();
		}
		
		result.x = separationResult.x + cohesionResult.x + alignmentResult.x;
		result.y = separationResult.y + cohesionResult.y + alignmentResult.y;
		return result;
	}
	
	public void kill() {
		super.kill();
		flock.agents.remove(this);
	}
	
}
