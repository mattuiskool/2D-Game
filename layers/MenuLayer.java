package layers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import core.Window;
import core.UI.UIButton;
import core.UI.UIComponent;
import events.Event;
import events.EventDispatcher;
import events.types.ButtonPressEvent;
import events.types.KeyPressedEvent;
import events.types.KeyReleasedEvent;
import events.types.MouseMovedEvent;
import events.types.MousePressedEvent;
import events.types.MouseReleasedEvent;
import game.Game;

public class MenuLayer extends UILayer{
	
	
	private UIButton startButton;

	public MenuLayer(Game game) {
		super(game);
		startButton = new UIButton("StartButton", this, Color.blue, "Start", new Rectangle(Window.width/2 - 150, Window.height/2 - 50, 300, 100));
		startButton.setPadding(50);
	}
	
	@Override
	public void onEvent(Event event) {
		super.onEvent(event);
		EventDispatcher dispatcher = new EventDispatcher(event);
		dispatcher.dispatch(Event.Type.MOUSE_PRESSED, (Event e) -> (onMousePressed((MousePressedEvent) e)));
		dispatcher.dispatch(Event.Type.MOUSE_RELEASED, (Event e) -> (onMouseReleased((MouseReleasedEvent) e)));
		dispatcher.dispatch(Event.Type.MOUSE_MOVED, (Event e) -> (onMouseMoved((MouseMovedEvent) e)));
		dispatcher.dispatch(Event.Type.KEY_PRESSED, (Event e) -> (onKeyPressed((KeyPressedEvent) e)));
		dispatcher.dispatch(Event.Type.KEY_RELEASED, (Event e) -> (onKeyReleased((KeyReleasedEvent) e)));
		dispatcher.dispatch(Event.Type.BUTTON_PRESSED, (Event e) -> (onButtonPress((ButtonPressEvent) e)));
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
		return false;
	}
	
	public boolean onKeyReleased(KeyReleasedEvent e) {
		keys[e.getButton()] = false;
		return false;
	}
	
	public boolean onButtonPress(ButtonPressEvent e) {
		if(e.button.getName() == "StartButton"){
			startGame();
		}
		return false;
	}
	
	public void onRender(Graphics g) {
		for(UIComponent c : components) {
			c.onRender(g);
		}
	}
	
	public void onUpdate() {
		for(UIComponent c : components) {
			c.onUpdate();
		}
	}
	
	private void startGame() {
		game.window.addLayer(new GameLayer(game));
		this.setActive(false);
		game.window.removeLayer(this);
	}
}
