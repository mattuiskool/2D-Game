package game.weapon;

import game.entity.Entity;

public class Pistol extends Weapon{

	public Pistol(Entity holder) {
		super(holder);
		speed = 12;
		shotSpeed = 0.5f;
		lifespan = 80;
		damage = 5;
		size = 6;
	}

}
