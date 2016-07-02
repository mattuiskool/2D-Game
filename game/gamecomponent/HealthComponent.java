package game.gamecomponent;

public class HealthComponent extends GameComponent{
	
	private int health;
	
	public HealthComponent setHealth(int health) {
		this.health = health;
		return this;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void damage(int amount) {
		health -= amount;
		if(health <= 0){
			parent.kill();
		}
	}

}