package core.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.Game;
import layers.LayerManager;

public class UIComponent {
	
	public Color color;
	public Game game;
	
	public UIComponent(Game game, Color color){
		this.color = color;
		this.game = game;
	}
	
	public void onRender(Graphics g) {
		
	}
	
	public void onUpdate() {
		
	}

}
