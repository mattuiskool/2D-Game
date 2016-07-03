package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import core.Window;
import core.util.Vector;
import game.ai.FlockAgentComponent;
import game.ai.FlockObject;
import game.gamecomponent.EnemyComponent;
import game.gamecomponent.RenderComponent;
import game.gameobject.GameObject;
import game.gameobject.PlayerObject;
import layers.GameLayer;

public class Game {
	public Window window; 
	public GameObject master;
	
	private GameLayer gameLayer;
	
	private FlockObject flock;
	
	private Random random;
	
	public Game() {
		random = new Random();
		master = new GameObject(null);
		window = new Window("Game", 1600, 900, this);
		gameLayer = new GameLayer(this);
		window.addLayer(gameLayer);
		GameObject player = new PlayerObject(gameLayer).setX(Window.width/2).setY(Window.height/2).setSpeed(5).setHealth(100);
		master.addChild(player);
		flock = new FlockObject(gameLayer, player);
		master.addChild(flock);
		
		for(int i = 0; i < 850; i++){
			flock.addChild(new GameObject(gameLayer).addComponent(new FlockAgentComponent(flock)).addComponent(new RenderComponent()).setPosition(new Vector(i, i))
					.setSpeed(4).addComponent(new EnemyComponent()));
		}
		
	}
	
	int time = 2;
	
	public void test() {
		System.out.println(flock.agents.size());
	}
	
	public void update() {
		master.onUpdate();
		//time++;
		if(time %5 == 0) {
			flock.addChild(new GameObject(gameLayer).addComponent(new FlockAgentComponent(flock)).addComponent(new RenderComponent()).setPosition(new Vector(100, 100)).setSpeed(random.nextInt(3)+1).setColor(new Color(random.nextInt())).addComponent(new EnemyComponent()).setHealth(random.nextInt(19)+1));
			flock.addChild(new GameObject(gameLayer).addComponent(new FlockAgentComponent(flock)).addComponent(new RenderComponent()).setPosition(new Vector(Window.width -100, 100)).setSpeed(random.nextInt(3)+1).setColor(new Color(random.nextInt())).addComponent(new EnemyComponent()).setHealth(random.nextInt(19)+1));
			flock.addChild(new GameObject(gameLayer).addComponent(new FlockAgentComponent(flock)).addComponent(new RenderComponent()).setPosition(new Vector(Window.width -100, 100)).setSpeed(random.nextInt(3)+1).setColor(new Color(random.nextInt())).addComponent(new EnemyComponent()).setHealth(random.nextInt(19)+1));
			flock.addChild(new GameObject(gameLayer).addComponent(new FlockAgentComponent(flock)).addComponent(new RenderComponent()).setPosition(new Vector(Window.width -100, Window.height -100)).setSpeed(random.nextInt(3)+1).setColor(new Color(random.nextInt())).addComponent(new EnemyComponent()).setHealth(random.nextInt(19)+1));
			flock.addChild(new GameObject(gameLayer).addComponent(new FlockAgentComponent(flock)).addComponent(new RenderComponent()).setPosition(new Vector(Window.width -100, Window.height -100)).setSpeed(random.nextInt(3)+1).setColor(new Color(random.nextInt())).addComponent(new EnemyComponent()).setHealth(random.nextInt(19)+1));
			flock.addChild(new GameObject(gameLayer).addComponent(new FlockAgentComponent(flock)).addComponent(new RenderComponent()).setPosition(new Vector(100, Window.height -100)).setSpeed(random.nextInt(3)+1).setColor(new Color(random.nextInt())).addComponent(new EnemyComponent()).setHealth(random.nextInt(19)+1));
			flock.addChild(new GameObject(gameLayer).addComponent(new FlockAgentComponent(flock)).addComponent(new RenderComponent()).setPosition(new Vector(100, Window.height -100)).setSpeed(random.nextInt(3)+1).setColor(new Color(random.nextInt())).addComponent(new EnemyComponent()).setHealth(random.nextInt(19)+1));
		}
	}
	
	public void render(Graphics g) {
		master.onRender(g);
	}

}
