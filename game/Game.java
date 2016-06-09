package game;

import core.Window;
import game.level.Level;
import layers.MenuLayer;

public class Game {
	
	public Level level;
	public Window window;
	
	public Game() {
		window = new Window("Game", 1600, 900);
		window.addLayer(new MenuLayer(this));
	}

}
