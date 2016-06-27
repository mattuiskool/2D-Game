package game.gamecomponent;

import java.awt.Graphics;

public class RenderComponent extends GameComponent{
	
	public void onRender(Graphics g) {
		g.setColor(parent.getColor());
		g.fillRect((int)this.parent.getX(), (int)this.parent.getY(), parent.getWidth(), parent.getHeight());
	}

}
