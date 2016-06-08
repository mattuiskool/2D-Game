package layers;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import events.Event;
import events.EventListener;
import game.entity.Entity;

public class Layer implements EventListener{
	
	public boolean[] keys = new boolean[1000];
	public boolean[] mouseButtons = new boolean[10];
	public int mouseX;
	public int mouseY;
	public boolean isFocus;
	
	protected boolean handleKeyPressed;
	protected boolean handleKeyReleased;
	protected boolean handleMouseClicked;
	protected boolean handleMouseReleased;
	protected boolean handleMouseMoved;

	@Override
	public void onEvent(Event event) {
	}
	
	
	public void onUpdate() {
		
	}
	
	public void onRender(Graphics g) {
		
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

}
