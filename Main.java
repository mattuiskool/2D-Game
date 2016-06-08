
import java.awt.Color;
import java.awt.Rectangle;

import core.Window;
import core.UI.UIComponent;
import core.UI.UILayer;
import game.level.Level;
import layers.GameLayer;

public class Main {
	
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 900;

	public static void main(String[] args) {
		Window window = new Window("Event", WIDTH, HEIGHT);
		window.addLayer(new GameLayer());
		UILayer ui = new UILayer();
		ui.addComponent(new UIComponent(new Rectangle(0, 0, 100, HEIGHT),Color.gray));
		window.addLayer(ui);
	}

}
