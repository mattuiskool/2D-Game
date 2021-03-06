package layers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import events.Event;
import events.EventDispatcher;
import events.types.ButtonPressEvent;
import events.types.KeyPressedEvent;
import events.types.KeyReleasedEvent;
import events.types.MouseMovedEvent;
import events.types.MousePressedEvent;
import events.types.MouseReleasedEvent;
import game.Game;
import game.entity.Enemy;
import game.entity.Entity;
import game.entity.Player;
import game.entity.Projectile;
import layers.Layer;

public class GameLayer extends Layer{
	
	public int width = 1500;
	public int height = 900;
	
	public GameLayer(Game game) {
		super(game);
	}
	
	public void onEvent(Event event) {
		EventDispatcher dispatcher = new EventDispatcher(event);
		dispatcher.dispatch(Event.Type.MOUSE_PRESSED, (Event e) -> (onMousePressed((MousePressedEvent) e)));
		dispatcher.dispatch(Event.Type.MOUSE_RELEASED, (Event e) -> (onMouseReleased((MouseReleasedEvent) e)));
		dispatcher.dispatch(Event.Type.MOUSE_MOVED, (Event e) -> (onMouseMoved((MouseMovedEvent) e)));
		dispatcher.dispatch(Event.Type.KEY_PRESSED, (Event e) -> (onKeyPressed((KeyPressedEvent) e)));
		dispatcher.dispatch(Event.Type.KEY_RELEASED, (Event e) -> (onKeyReleased((KeyReleasedEvent) e)));
		dispatcher.dispatch(Event.Type.BUTTON_PRESSED, (Event e) -> (onButtonPress((ButtonPressEvent) e)));
	}
	
	private boolean onButtonPress(ButtonPressEvent e) {
		return false;
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
		mousePosition.x = e.getX();
		mousePosition.y = e.getY();
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

}
