package layers.ui;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

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
import layers.UILayer;

public class PauseMenu extends Menu{
	
	private UIButton resumeButton;

	public PauseMenu(UILayer layer) {
		super(layer);
		resumeButton = new UIButton("Resume", this, Color.blue, "Resume", new Rectangle(Window.width/2 - 150, Window.height/2 - 50, 300, 100));
		resumeButton.setPadding(50);
		components.add(resumeButton);
		active = false;
	}
	
	public void onEvent(Event event) {
		for(UIComponent c : components) {
			c.onEvent(event);
		}
		EventDispatcher dispatcher = new EventDispatcher(event);
		dispatcher.dispatch(Event.Type.MOUSE_PRESSED, (Event e) -> (onMousePressed((MousePressedEvent) e)));
		dispatcher.dispatch(Event.Type.MOUSE_RELEASED, (Event e) -> (onMouseReleased((MouseReleasedEvent) e)));
		dispatcher.dispatch(Event.Type.KEY_PRESSED, (Event e) -> (onKeyPressed((KeyPressedEvent) e)));
		dispatcher.dispatch(Event.Type.KEY_RELEASED, (Event e) -> (onKeyReleased((KeyReleasedEvent) e)));
		dispatcher.dispatch(Event.Type.BUTTON_PRESSED, (Event e) -> (onButtonPress((ButtonPressEvent) e)));
	}

	private boolean onKeyReleased(KeyReleasedEvent e) {
		return false;
	}

	private boolean onMouseReleased(MouseReleasedEvent e) {
		return false;
	}

	private boolean onMousePressed(MousePressedEvent e) {
		return false;
	}

	private boolean onKeyPressed(KeyPressedEvent e) {
		return false;
	}

	private boolean onButtonPress(ButtonPressEvent e) {
		if(e.button.getName() == "Resume") {
			active = !active;
		}
		return false;
	}

}
