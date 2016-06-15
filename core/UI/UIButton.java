package core.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import events.Event;
import events.EventDispatcher;
import events.types.ButtonPressEvent;
import events.types.MousePressedEvent;
import layers.ui.Menu;

public class UIButton extends UIComponent {

	public String text;
	public Rectangle box;
	private int padding = 10;

	public UIButton(String name, Menu menu, Color color, String text, Rectangle box) {
		super(name, menu, color);
		this.text = text;
		this.box = box;
	}

	public void onEvent(Event event) {
		EventDispatcher dispatcher = new EventDispatcher(event);
		dispatcher.dispatch(Event.Type.MOUSE_PRESSED, (Event e) -> (onMousePressed((MousePressedEvent) e)));
	}

	public boolean onMousePressed(MousePressedEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (box.contains(new Point(e.getX(), e.getY()))) {
				onPress();
				return true;
			}
		}
		return false;
	}

	public void onRender(Graphics g) {
		g.setColor(color);
		g.fillRect(box.x, box.y, box.width, box.height);
		g.setColor(Color.white);
		g.drawString(text, box.x + padding, box.y + padding);
		;
	}

	public void setPadding(int padding) {
		this.padding = padding;
	}

	public void onPress() {
		this.menu.layer.game.window.onEvent(new ButtonPressEvent(this));
	}

}
