package layers;

import core.util.Vector;
import events.Event;
import events.EventListener;
import game.Game;

public class Layer implements EventListener{
	
	public boolean[] keys = new boolean[1000];
	public boolean[] mouseButtons = new boolean[10];
	public Vector mousePosition = new Vector();
	public boolean isFocus;
	public int layerIndex;
	public Game game;
	
	protected boolean active = true;
	
	protected boolean handleKeyPressed;
	protected boolean handleKeyReleased;
	protected boolean handleMouseClicked;
	protected boolean handleMouseReleased;
	protected boolean handleMouseMoved;
	
	public Layer(Game game){
		this.game = game;
	}

	@Override
	public void onEvent(Event event) {
		
	}
	
	public void loseFocus(){
		isFocus = false;
		for(int i = 0; i < keys.length; i++){
			keys[i] = false;
		}
		for(int i = 0; i < mouseButtons.length; i++){
			mouseButtons[i] = false;
		}
	}
	
	public void gainFocus(){
		LayerManager.gainFocus(this);
		isFocus = true;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isActive() {
		return active;
	}

}
