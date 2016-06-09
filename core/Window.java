package core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import events.Event;
import events.types.*;
import layers.*;
import layers.LayerManager;

public class Window extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private Screen screen;
	public static int width, height;
	
	
	public Window(String name, int width, int height) {
		screen = new Screen(width, height);
		this.width = width;
		this.height = height;
		setTitle(name);
		add(screen);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(width, height));
		setLocationRelativeTo(null);
		setVisible(true);
		
		screen.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				KeyPressedEvent event = new KeyPressedEvent(e.getKeyCode());
				onEvent(event);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				KeyReleasedEvent event = new KeyReleasedEvent(e.getKeyCode());
				onEvent(event);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				KeyTypedEvent event = new KeyTypedEvent(e.getKeyCode());
				onEvent(event);
			}
		});
		
		screen.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e){
				MouseReleasedEvent event = new MouseReleasedEvent(e.getButton(), e.getX(), e.getY());
				onEvent(event);
			}
			
			public void mousePressed(MouseEvent e){
				MousePressedEvent event = new MousePressedEvent(e.getButton(), e.getX(), e.getY());
				onEvent(event);
			}
		});
		
		screen.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				MouseMovedEvent event = new MouseMovedEvent(e.getX(), e.getY(), false);
				onEvent(event);
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				MouseMovedEvent event = new MouseMovedEvent(e.getX(), e.getY(), true);
				onEvent(event);
			}
			
		});
		screen.requestFocus();
		
		screen.init();
		time = System.nanoTime();
		time2 = System.nanoTime();
		run();
	}
	
	private long time;
	private long time2;
	private int frames;
	
	private void run(){
		long now = System.nanoTime();
		long dif = (now - time);
		long dif2 = (now - time2);
		if(dif2 >= 1000000000){
			frames = 0;
			time2 = now;
		}
		if(dif >= 1000000000 / 60){
			frames++;
			time = now;
			screen.beginRendering();
			screen.clear();
			onRender(screen.getGraphicsObject());
			onUpdate();
			screen.endRendering();		
		}
		SwingUtilities.invokeLater(() -> run());
	}
	
	public void onEvent(Event event){
		LayerManager.onEvent(event);
	}
	
	private void onRender(Graphics g){
		LayerManager.onRender(g);
	}
	
	private void onUpdate() {
		LayerManager.onUpdate();
	}
	
	public void addLayer(Layer layer){
		LayerManager.AddLayer(layer);
	}
	
	public void removeLayer(Layer layer){
		LayerManager.RemoveLayer(layer);
	}

}
