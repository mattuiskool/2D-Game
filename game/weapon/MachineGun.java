package game.weapon;

import game.entity.Entity;

public class MachineGun extends Weapon{

	public MachineGun(Entity holder) {
		super(holder);
		speed = 20;
		damage = 100;
		shotSpeed = 200;
		lifespan = 60;
	}

}
