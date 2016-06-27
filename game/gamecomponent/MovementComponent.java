package game.gamecomponent;

public class MovementComponent extends GameComponent{
	
	private int speed;
	
	public MovementComponent setSpeed(int speed) {
		this.speed = speed;
		return this;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void moveLeft() {
		this.parent.changeX(-speed);
	}
	
	public void moveRight() {
		this.parent.changeX(speed);
	}
	
	public void moveUp() {
		this.parent.changeY(-speed);
	}
	
	public void moveDown() {
		this.parent.changeY(speed);
	}

}
