package game;

import java.awt.Color;
import java.awt.Graphics;

import core.Window;
import core.util.Vector;
import game.ai.FlockAgentComponent;
import game.ai.FlockObject;
import game.gamecomponent.RenderComponent;
import game.gameobject.GameObject;
import game.gameobject.PlayerObject;
import layers.GameLayer;

public class Game {
	public Window window; 
	public GameObject master;
	
	private GameLayer gameLayer;
	
	public Game() {
		master = new GameObject(null);
		window = new Window("Game", 1600, 900, this);
		gameLayer = new GameLayer(this);
		window.addLayer(gameLayer);
		GameObject player = new PlayerObject(gameLayer).setX(100).setY(100).setSpeed(2);
		master.addChild(player);
		FlockObject flock = new FlockObject(gameLayer, player);
		
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 12; j++){
				flock.addChild(new GameObject(gameLayer).addComponent(new FlockAgentComponent(flock)).addComponent(new RenderComponent()).setPosition(new Vector(500 + i*4, 500 + j*60)).setSpeed(2).setVelocity(new Vector(1, 0)));
				flock.addChild(new GameObject(gameLayer).addComponent(new FlockAgentComponent(flock)).addComponent(new RenderComponent()).setPosition(new Vector(500 + i*60, 500 + j*40)).setSpeed(2).setVelocity(new Vector(0, 1)).setColor(Color.red));
			}
		}
		master.addChild(flock);
		
	}
	
	public void update() {
		master.onUpdate();
		
	}
	
	public void render(Graphics g) {
		master.onRender(g);
	}

}
