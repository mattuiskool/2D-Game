package game;

import java.awt.Color;
import java.awt.Rectangle;

import core.Window;
import core.UI.UIPanel;
import game.level.Level;
import layers.GameLayer;
import layers.MenuLayer;

public class Game {
	
	public Level level;
	public Window window;
	
	public Game() {
		window = new Window("Game", 1600, 900);
		window.addLayer(new MenuLayer(this));
	}

}
