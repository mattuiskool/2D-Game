package game.gamecomponent;

public class MovementComponent extends GameComponent{
	
	public void moveLeft() {
		this.parent.changeX(-this.parent.getSpeed());
	}
	
	public void moveRight() {
		this.parent.changeX(this.parent.getSpeed());
	}
	
	public void moveUp() {
		this.parent.changeY(-this.parent.getSpeed());
	}
	
	public void moveDown() {
		this.parent.changeY(this.parent.getSpeed());
	}

}
