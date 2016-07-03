package game.gameobject;

import game.ai.FlockObject;
import game.gamecomponent.GameComponent;
import game.gamecomponent.LabelComponent;
import game.gamecomponent.RenderComponent;
import layers.Layer;

public class ZombieSheepObject extends GameObject{
	
	private GameComponent renderer;
	private LabelComponent label;
	
	private FlockObject flock;

	public ZombieSheepObject(Layer layer, FlockObject flock) {
		super(layer);
		this.flock = flock;
		renderer = new RenderComponent();
		label = new LabelComponent();
		
	}

}
