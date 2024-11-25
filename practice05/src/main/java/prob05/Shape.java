package prob05;

public abstract class Shape {
	private int width;
	private int height;
	public Shape(int width, int height) {
		this.width = width;
		this.height = height;
	}
	abstract double getArea();
	abstract double getPerimeter();
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}	
}
