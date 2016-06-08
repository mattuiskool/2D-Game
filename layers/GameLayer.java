package layers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import events.Event;
import events.EventDispatcher;
import events.types.KeyPressedEvent;
import events.types.KeyReleasedEvent;
import events.types.MouseMovedEvent;
import events.types.MousePressedEvent;
import events.types.MouseReleasedEvent;
import game.entity.Enemy;
import game.entity.Entity;
import game.entity.Player;
import game.entity.Projectile;
import game.level.Level;
import layers.Layer;

public class GameLayer extends Layer{
	
	public Level level;
	
	public GameLayer() {
		this.level = new Level(this);
	}
	
	public void onEvent(Event event) {
		EventDispatcher dispatcher = new EventDispatcher(event);
		dispatcher.dispatch(Event.Type.MOUSE_PRESSED, (Event e) -> (onMousePressed((MousePressedEvent) e)));
		dispatcher.dispatch(Event.Type.MOUSE_RELEASED, (Event e) -> (onMouseReleased((MouseReleasedEvent) e)));
		dispatcher.dispatch(Event.Type.MOUSE_MOVED, (Event e) -> (onMouseMoved((MouseMovedEvent) e)));
		dispatcher.dispatch(Event.Type.KEY_PRESSED, (Event e) -> (onKeyPressed((KeyPressedEvent) e)));
		dispatcher.dispatch(Event.Type.KEY_RELEASED, (Event e) -> (onKeyReleased((KeyReleasedEvent) e)));
	}
	
	public boolean onMousePressed(MousePressedEvent e) {
		mouseButtons[e.getButton()] = true;
		return false;
	}
	public boolean onMouseReleased(MouseReleasedEvent e) {
		mouseButtons[e.getButton()] = false;
		return false;
	}
	public boolean onMouseMoved(MouseMovedEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		return false;
	}
	
	public boolean onKeyPressed(KeyPressedEvent e) {
		keys[e.getButton()] = true;
		return true;
	}
	
	public boolean onKeyReleased(KeyReleasedEvent e) {
		keys[e.getButton()] = false;
		return true;
	}
	
	public void onRender(Graphics g) {
		level.onRender(g);
	}
	
	public void onUpdate() {
		level.onUpdate();
		level.onInput();
	}

}
