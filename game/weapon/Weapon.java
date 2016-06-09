package game.weapon;

import java.awt.Color;
import java.awt.Rectangle;

import game.entity.Entity;
import game.entity.Projectile;

public class Weapon {
	
	public static float maxSpeed, minSpeed = 0;
	public static int maxSize, minSize;
	public static int maxLifespan, minLifespan;
	public static int maxShotSpeed, minShotSpeed;
	
	public Entity holder;
	
	protected float speed;
	protected int size = 5;
	protected int lifespan;
	protected float shotSpeed;
	protected int color;
	protected int damage = 100;
	
	protected boolean shot;
	protected int counter;
	
	public Weapon(Entity holder) {
		this.holder = holder;
	}
	
	public void setSpeed(float s){
		speed = s;
		if(speed > maxSpeed) speed = maxSpeed;
		if(speed < minSpeed) speed = minSpeed;
	}
	
	public void setSize(int s) {
		size = s;
		if(size > maxSize) size = maxSize;
		if(size < minSize) size = minSize;
	}
	
	public void setLifespan(int l) {
		lifespan = l;
		if(lifespan > maxLifespan) lifespan = maxLifespan;
		if(lifespan < minLifespan) lifespan = minLifespan;
	}
	
	public void setColor(int c){
		color = c;
	}
	
	public void update(double dir, boolean shooting) {
		if(shooting){
			if(!shot){
				shoot(dir);
				shot = true;
			}
		}
		if(shot){
			counter++;
			if(counter >= 60.0f / shotSpeed){
				shot = false;
				counter = 0;
			}
		}
	}
	
	public void shoot(double angle) {
		holder.spawn(newProjectile(angle));
	}
	
	protected Projectile newProjectile(double angle) {
		return new Projectile(angle, speed, lifespan, damage, new Color(color), new Rectangle(holder.box.x + holder.box.width/2, holder.box.y + holder.box.height/2, size, size), holder.level, holder);
	}

}
