package core.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import core.Window;
import events.Event;
import events.EventDispatcher;
import events.types.KeyPressedEvent;
import events.types.KeyReleasedEvent;
import events.types.MouseMovedEvent;
import events.types.MousePressedEvent;
import events.types.MouseReleasedEvent;
import layers.Layer;

public class UILayer extends Layer {
	
	public List<UIComponent> components = new ArrayList<UIComponent>();
	
	public UILayer(){
	}

	public void onEvent(Event event) {
		EventDispatcher dispatcher = new EventDispatcher(event);
		dispatcher.dispatch(Event.Type.MOUSE_PRESSED, (Event e) -> (onMousePressed((MousePressedEvent) e)));
		dispatcher.dispatch(Event.Type.MOUSE_RELEASED, (Event e) -> (onMouseReleased((MouseReleasedEvent) e)));
		dispatcher.dispatch(Event.Type.MOUSE_MOVED, (Event e) -> (onMouseMoved((MouseMovedEvent) e)));
		dispatcher.dispatch(Event.Type.KEY_PRESSED, (Event e) -> (onKeyPressed((KeyPressedEvent) e)));
		dispatcher.dispatch(Event.Type.KEY_RELEASED, (Event e) -> (onKeyReleased((KeyReleasedEvent) e)));
	}
	
	public boolean onKeyPressed(KeyPressedEvent e) {
		keys[e.getButton()] = true;
		return false;
	}
	
	public boolean onKeyReleased(KeyReleasedEvent e) {
		keys[e.getButton()] = false;
		return false;
	}
	

	public boolean onMousePressed(MousePressedEvent e) {
		mouseButtons[e.getButton()] = true;
		return false;
	}
	
	public boolean onMouseReleased(MouseReleasedEvent e) {
		mouseButtons[e.getButton()] = true;
		return false;
	}
	
	public boolean onMouseMoved(MouseMovedEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		return false;
	}
	
	
	public void onUpdate() {
		
	}
	
	public void addComponent(UIComponent c){
		components.add(c);
	}
	
	public void onRender(Graphics g){
		for(UIComponent c : components){
			c.onRender(g);
		}
	}

}
