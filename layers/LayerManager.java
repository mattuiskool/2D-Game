package layers;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import events.Event;

public class LayerManager {
	
	public static List<Layer> layerStack = new ArrayList<Layer>();
	
	
	public static void gainFocus(Layer layer){
		if(layerStack.get(layerStack.size() - 1).equals(layer)){
			return;
		}
		layerStack.get(layerStack.size()-1).loseFocus();
		for(int i = 0; i < layerStack.size(); i++) {
			if(layerStack.get(i).equals(layer)){
				layerStack.remove(i);
				layerStack.add(layerStack.size(), layer);
			}
		}
	}
	
	public static void onEvent(Event event){
		for(int i = layerStack.size() - 1; i >= 0 ; i--){
			layerStack.get(i).onEvent(event);				
		}
	}
	
	public static void onRender(Graphics g){
		for(int i = 0; i < layerStack.size(); i++){
			layerStack.get(i).onRender(g);
		}
	}
	
	public static void onUpdate() {
		for(int i = 0; i < layerStack.size(); i++){
			if(layerStack.get(i).isActive()){
				layerStack.get(i).onUpdate();				
			}
		}
	}
	
	public static void AddLayer(Layer layer){
		layerStack.add(layer);
		layer.isFocus = true;
		layer.layerIndex = layerStack.size() - 1;
	}
	
	public static void RemoveLayer(Layer layer){
		layerStack.remove(layer.layerIndex);
	}

}
