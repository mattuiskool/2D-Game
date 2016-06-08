package core.UI;

import java.awt.Color;
import java.awt.Graphics;

import game.Game;

public class UITextField extends UIComponent{
	
	private String text;
	private int x, y;

	public UITextField(Game game, Color color, String text, int x, int y) {
		super(game, color);
		this.text = text;
		this.x = x;
		this.y = y;
	}
	
	public void onRender(Graphics g) {
		g.setColor(color);
		g.drawString(text, x, y);
	}
	
	public void setText(String text) {
		this.text = text;
	}

}
