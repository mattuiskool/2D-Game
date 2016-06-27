package core.util;

public class Vector {
	
	public double x, y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector() {
		this.x = 0;
		this.y = 0;
	}
	
	public Vector add(Vector a) {
		return new Vector(this.x + a.x, this.y + a.y);
	}
	
	public Vector subtract(Vector a) {
		return new Vector(this.x - a.x, this.y - a.y);
	}
	
	public Vector divide(double a) {
		return new Vector(this.x / a, this.y / a);
	}
	
	public Vector multiply(double a) {
		return new Vector(this.x * a, this.y * a);
	}
	
	public double dotProduct(Vector a) {
		return this.x * a.x + this.y * a.y;
	}
	
	public double getLength() {
		return Math.sqrt((x)*(x) + (y)*(y));
	}
	public double getLengthSquared() {
		return (x)*(x) + (y)*(y);
	}
	
	public double getAngleBetween(Vector a) {
		return Math.cosh(this.dotProduct(a) / (this.getLength() * a.getLength()));		
	}
	
	public double getAngle() {
		return Math.atan2(x, y);
	}
	
	public Vector normalise() {
		if(this.getLength() == 0){
			return this;
		}
		return this.divide(this.getLength());
	}

}
