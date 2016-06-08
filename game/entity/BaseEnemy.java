package game.entity;

import java.awt.Color;
import java.awt.Rectangle;

import game.level.Level;

public class BaseEnemy extends Enemy{

	public BaseEnemy(int x, int y, Level level, Entity target) {
		super(Color.blue, new Rectangle(x, y, 20, 20), level, target);
		health = 50;
	}

}
