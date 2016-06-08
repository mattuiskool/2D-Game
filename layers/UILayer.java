package layers;

import java.util.ArrayList;
import java.util.List;

import core.UI.UIComponent;
import game.Game;

public class UILayer extends Layer{
	
	public List<UIComponent> components = new ArrayList<UIComponent>();

	public UILayer(Game game) {
		super(game);
	}

}
