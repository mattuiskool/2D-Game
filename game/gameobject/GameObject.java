package game.gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import core.util.Vector;
import game.gamecomponent.GameComponent;
import layers.Layer;

public class GameObject {
	
	public GameObject parent;
	public List<GameComponent> components = new ArrayList<GameComponent>();
	public List<GameObject> children = new ArrayList<GameObject>();
	public Layer layer;
	private Vector position = new Vector();
	private Vector velocity = new Vector();
	private double speed = 1;
	private int width = 20, height = 20;
	protected Color color = Color.black;


	public GameObject(Layer layer) {
		this.layer = layer;
	}
	
	public void onUpdate() {
		for(GameObject o : children) {
			o.onUpdate();
		}
		for(GameComponent c : components) {
			c.onUpdate();
		}
		
		position.x += velocity.x;
		position.y += velocity.y;
	}
	
	public void onRender(Graphics g) {
		for(GameObject o : children) {
			o.onRender(g);
		}
		for(GameComponent c : components) {
			c.onRender(g);
		}
	}
	
	public GameObject addChild(GameObject o){
		if(o.parent != null){
			o.parent.children.remove(o);
		}
		children.add(o);
		o.parent = this;
		return this;
	}
	
	public GameObject addComponent(GameComponent c) {
		components.add(c);
		c.setParent(this);
		return this;
	}

	public double getX() {
		return position.x;
	}
	
	public GameObject setX(double x) {
		this.position.x = x;
		return this;
	}
	
	public void changeX(double amount) {
		this.position.x += amount;
	}
	
	public double getY() {
		return position.y;
	}
	
	public GameObject setY(double y) {
		this.position.y = y;
		return this;
	}
	
	public void changeY(double amount) {
		this.position.y += amount;
	}
	
	public int getWidth() {
		return width;
	}
	
	public GameObject setWidth(int width) {
		this.width = width;
		return this;
	}
	
	public int getHeight() {
		return height;
	}
	
	public GameObject setHeight(int height) {
		this.height = height;
		return this;
	}
	
	public Color getColor() {
		return color;
	}
	
	public GameObject setColor(Color color) {
		this.color = color;
		return this;
	}
	
	public GameObject setPosition(Vector v) {
		this.position = v;
		
		return this;
	}
	
	public Vector getPosition() {
		return position;
	}
	
	public GameObject setVelocity(Vector v) {
		this.velocity = v;
		
		return this;
	}
	
	public Vector getVelocity() {
		return velocity;
	}

	public double getSpeed() {
		return speed;
	}

	public GameObject setSpeed(double speed) {
		this.speed = speed;
		return this;
	}
	
	public void kill() {
		this.parent.children.remove(this);
	}
}
