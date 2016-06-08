package layers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import core.Window;
import core.UI.UIComponent;
import core.UI.UIPanel;
import events.Event;
import events.EventDispatcher;
import events.types.KeyPressedEvent;
import events.types.KeyReleasedEvent;
import events.types.MouseMovedEvent;
import events.types.MousePressedEvent;
import events.types.MouseReleasedEvent;
import game.Game;

public class MenuLayer extends Layer{
	
	boolean paused;
	boolean mainMenu = true;
	
	private UIPanel startButton;

	public MenuLayer(Game game) {
		super(game);
		startButton = new UIPanel(game, Color.blue, new Rectangle(Window.width/2 - 150, Window.height/2 - 35, 300, 70));
	}
	
	@Override
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
		if(paused){
			return true;
		} else {
			return false;			
		}
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
		if(e.getButton() == KeyEvent.VK_ESCAPE) {
			System.out.println("hello");
			if(!mainMenu){
				paused = !paused;
				game.level.layer.setActive(!game.level.layer.active);				
			}
		}
		return false;
	}
	
	public boolean onKeyReleased(KeyReleasedEvent e) {
		keys[e.getButton()] = false;
		return false;
	}
	
	public void onRender(Graphics g) {
		if(mainMenu){
			startButton.onRender(g);
		}
	}
	
	public void onUpdate() {
		if(mainMenu){
			if(mouseButtons[1]){
				if(startButton.box.contains(new Point(mouseX, mouseY))){
					game.window.addLayer(new GameLayer(game));
					this.gainFocus();
					mainMenu = false;
				}
			}			
		}
	}

}
