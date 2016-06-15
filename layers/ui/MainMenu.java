package layers.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import core.Window;
import core.UI.UIButton;
import core.UI.UIComponent;
import events.Event;
import events.EventDispatcher;
import events.types.ButtonPressEvent;
import layers.UILayer;

public class MainMenu extends Menu {
	private UIButton startButton;

	public MainMenu(UILayer layer) {
		super(layer);
		startButton = new UIButton("StartButton", this, Color.blue, "Start",
				new Rectangle(Window.width / 2 - 150, Window.height / 2 - 50, 300, 100));
		startButton.setPadding(50);
	}

	public void onEvent(Event event) {
		for (UIComponent c : components) {
			c.onEvent(event);
		}
		EventDispatcher dispatcher = new EventDispatcher(event);
		dispatcher.dispatch(Event.Type.BUTTON_PRESSED, (Event e) -> (onButtonPress((ButtonPressEvent) e)));
	}

	private boolean onButtonPress(ButtonPressEvent e) {
		if (e.button.getName() == "StartButton") {
			layer.startGame();
			active = false;
		}
		return true;
	}

}
