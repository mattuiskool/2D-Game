package layers.ui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import core.UI.UIComponent;
import events.Event;
import layers.UILayer;

public class Menu {

	public List<UIComponent> components = new ArrayList<UIComponent>();
	protected UILayer layer;
	public boolean active = true;

	public Menu(UILayer layer) {
		this.layer = layer;
		layer.menus.add(this);
	}

	public void onEvent(Event event) {

	}

	public void onRender(Graphics g) {
		for (UIComponent c : components) {
			c.onRender(g);
		}
	}

	public void onUpdate() {
		for (UIComponent c : components) {
			c.onUpdate();
		}
	}

}
