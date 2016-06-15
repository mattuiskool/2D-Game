package layers.ui.gui;

import java.awt.Color;
import java.awt.Rectangle;

import core.Window;
import core.UI.UIPanel;
import core.UI.UITextField;
import layers.UILayer;
import layers.ui.Menu;

public class Stats extends Menu{
	
	public UIPanel panel;
	public UITextField score;
	
	public Stats(UILayer layer) {
		super(layer);
		panel = new UIPanel("Stats Screen", this, Color.gray, new Rectangle(Window.width - 200, 0, 200, Window.height));
		score = new UITextField("Score counter", "Score: ", this, Color.BLACK, Window.width - 195, 20);
	}
	
	public void onUpdate() {
		score.setText("Score: " + this.layer.game.level.player.coins);
	}

}
