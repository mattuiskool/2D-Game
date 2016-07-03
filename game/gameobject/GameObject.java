package game.gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import core.Window;
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
	private Rectangle box;
	private double speed;
	private int width = 20, height = 20;
	protected Color color = Color.black;
	private int health = 20;


	public GameObject(Layer layer) {
		this.layer = layer;
		box = new Rectangle(0, 0, width, height);
	}
	
	public void onUpdate() {
		for(int i = 0; i < children.size(); i++) {
			children.get(i).onUpdate();
		}
		for(GameComponent c : components) {
			c.onUpdate();
		}
		
		position.x += velocity.x;
		position.y += velocity.y;
		box.x = (int) position.x;
		box.y = (int) position.y;
		
		if(getX() < 0) {
			setX(Window.width);
		} else if(getX() > Window.width){
			setX(0);
		}
		if(getY() < 0) {
			setY(Window.height);
		} else if(getY() > Window.height){
			setY(0);
		}
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
		components.add(c.setParent(this));
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
		box.width = width;
		return this;
	}
	
	public int getHeight() {
		return height;
	}
	
	public GameObject setHeight(int height) {
		this.height = height;
		box.height = height;
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
		for(int i = 0; i < components.size(); i++){
			components.get(i).kill();
		}
		for(int i = 0; i < children.size(); i++){
			children.get(i).kill();
		}
		this.parent.children.remove(this);
	}

	public Rectangle getBox() {
		return box;
	}

	public GameObject setBox(Rectangle box) {
		this.box = box;
		return this;
	}

	public int getHealth() {
		return health;
	}

	public GameObject setHealth(int health) {
		this.health = health;
		return this;
	}
	
	public void damage(int amount) {
		health -= amount;
		if(health <= 0){
			kill();
		}
	}
}
