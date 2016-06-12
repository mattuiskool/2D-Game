package core.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import layers.UILayer;

public class UIMessageBox extends UIComponent{
	
	Rectangle panel;
	

	public UIMessageBox(String name, UILayer layer, Color color) {
		super(name, layer, color);
	}
	
	public void onRender(Graphics g) {
		
	}

}
