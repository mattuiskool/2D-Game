package game;

import java.awt.Color;
import java.awt.Graphics;

import core.Window;
import core.util.Vector;
import game.gamecomponent.RenderComponent;
import game.gamecomponent.ai.AgentObject;
import game.gamecomponent.ai.FlockObject;
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
		GameObject player = new PlayerObject(gameLayer).setX(100).setY(100);
		master.addChild(player);
		FlockObject flock = new FlockObject(gameLayer);
		
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 12; j++){
				flock.addChild(new AgentObject(gameLayer).addComponent(new RenderComponent()).setVelocity(new Vector(i/2.0, j/2.0)).setPosition(new Vector(i * 60,  j * 60)).setSpeed(2).setTarget(player));				
				flock.addChild(new AgentObject(gameLayer).addComponent(new RenderComponent()).setVelocity(new Vector(i/2.0, j/2.0)).setPosition(new Vector(500 + i * 80,  200 + j * 80)).setSpeed(3).setTarget(player).setColor(Color.red));					
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
