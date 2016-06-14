package layers;

import java.awt.Graphics;
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
import layers.ui.MainMenu;
import layers.ui.Menu;
import layers.ui.PauseMenu;

public class UILayer extends Layer{
	
	private MainMenu mainMenu;
	private PauseMenu pauseMenu;
	public List<Menu> menus = new ArrayList<Menu>();

	public UILayer(Game game) {
		super(game);
		mainMenu = new MainMenu(this);
		pauseMenu = new PauseMenu(this);
		
	}
	
	@Override
	public void onEvent(Event event) {
		for(Menu m : menus) {
			if(m.active){
				m.onEvent(event);
			}
		}
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
		if(e.getButton() == KeyEvent.VK_ESCAPE) {
			pauseMenu.active = !pauseMenu.active;
		}
		return false;
	}
	
	public boolean onButtonPress(ButtonPressEvent e) {
		return false;
	}
	
	public void onRender(Graphics g) {
		for(Menu m : menus) {
			if(m.active) {
				m.onRender(g);
			}
		}
	}
	
	public void onUpdate() {
		for(Menu m : menus) {
			if(m.active) {
				m.onUpdate();
			}
		}
	}
	
	public void startGame() {
		game.window.addLayer(new GameLayer(game));
		this.gainFocus();
	}
}
