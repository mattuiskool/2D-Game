package game.weapon;

import java.awt.Color;
import java.awt.Rectangle;

import game.entity.Entity;
import game.entity.Projectile;

public class Shotgun extends Weapon{

	public Shotgun(Entity holder) {
		super(holder);
		speed = 30;
		shotSpeed = 0.6f;
		lifespan = 20;
		damage = 100;
		size = 7;
	}
	
	public void shoot(double angle) {
		holder.spawn(newProjectile(angle + 10));
		holder.spawn(newProjectile(angle + 5));
		holder.spawn(newProjectile(angle));
		holder.spawn(newProjectile(angle - 5));
		holder.spawn(newProjectile(angle - 10));
	}
	
	
	
	

}
