package game.gamecomponent;

import java.awt.Graphics;

public class LabelComponent extends GameComponent{
	
	public String label = "";
	
	public LabelComponent setString(String string){
		this.label = string;
		return this;
	}
	
	public void onRender(Graphics g) {
		if(!(label == "")){
			g.setColor(parent.getColor());
			g.drawString(label, (int)parent.getX(), (int)parent.getY() - 10);			
		}
	}

}
