package game.gamecomponent.ai;

import java.awt.Color;

import core.util.Vector;
import game.gamecomponent.GameComponent;
import game.gameobject.GameObject;
import layers.Layer;

public class AgentObject extends GameObject{
	
	public FlockObject parent;
	public GameObject target;
	
	private Vector toCentreOfMass = new Vector();

	public AgentObject(Layer layer) {
		super(layer);
	}

	private Vector velocity = new Vector();
	private int speed;
	private int mass = 1;
	
	private int minDist = 900;
	
	public void onUpdate() {
		super.onUpdate();
		
		Vector cohesion = calcCohesion();
		Vector separation = calcSeparation();
		Vector alignment = calcAlignment();
		Vector targetV = calcTarget(target);
		velocity.x += 5*separation.x + cohesion.x + alignment.x + targetV.x / 3;
		velocity.y += 5*separation.y + cohesion.y + alignment.y + targetV.y / 3;
		
		velocity = velocity.normalise();
		
		changeX(velocity.x * speed);
		changeY(velocity.y * speed);
	}
	
	private Vector calcTarget(GameObject target) {
		Vector result = new Vector();
		result.x = target.getX() - this.getX();
		result.y = target.getY() - this.getY();
		return result.normalise();
	}
	
	private Vector calcAlignment() {
		Vector result = new Vector();
		int neighbours = 0;
		for(AgentObject o : parent.children) {
			if(!o.equals(this) && this.position.subtract(o.getPosition()).getLengthSquared() < 20000){
				result.x += o.getVelocity().x;
				result.y += o.getVelocity().y;
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
		for(AgentObject o : parent.children) {
			if(!o.equals(this) && this.position.subtract(o.getPosition()).getLengthSquared() < 20000){
				result.x += o.getX();
				result.y += o.getY();
				neighbours++;
			}
		}
		if(neighbours > 0){
			result.x /= neighbours;
			result.y /= neighbours;
			result.x -= this.getX();
			result.y -= this.getY();
			return result.normalise();
		} else {
			System.out.println("hello");
			return new Vector();
		}
	}
	
	private Vector calcSeparation() {
		Vector result = new Vector();
		int neighbours = 0;
		Vector averageDistance;
		for(AgentObject o : parent.children) {
			if(!o.equals(this) && this.position.subtract(o.getPosition()).getLengthSquared() < 300){
				result.x += o.getX() - this.getX();
				result.y += o.getY() - this.getY();
				neighbours++;
			}
		}
		if(neighbours > 0){
			result.x /= neighbours;
			result.y /= neighbours;
			result.x *= -1;
			result.y *= -1;			
			result = result.normalise();
			return result;
		} else {
			return new Vector();
		}
	}
	
	public AgentObject addComponent(GameComponent c) {
		components.add(c);
		c.setParent(this);
		return this;
	}
	
	public int getMass() {
		return mass;
	}
	
	public AgentObject setMass(int mass){
		this.mass = mass;
		return this;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public AgentObject setSpeed(int speed){
		this.speed = speed;
		return this;
	}
	
	public Vector getVelocity() {
		return velocity;
	}
	
	public AgentObject setVelocity(Vector v) {
		this.velocity = v;
		return this;
	}
	
	public AgentObject setX(int x) {
		this.position.x = x;
		return this;
	}
	
	public AgentObject setY(double y) {
		this.position.y = y;
		return this;
	}
	
	public AgentObject setPosition(Vector v) {
		this.position = v;
		return this;
	}
	
	public AgentObject setTarget(GameObject o) {
		this.target = o;
		return this;
	}
	
	public AgentObject setColor(Color color) {
		this.color = color;
		return this;
	}
	
}
