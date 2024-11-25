package prob05;

public class Rectangle extends Shape{

	public Rectangle(int width, int height) {
		super(width, height);
	}

	public void resize(double rate) {
		
	}

	@Override
	double getArea() {
		return super.getWidth()*super.getHeight();
	}

	@Override
	double getPerimeter() {
		return (super.getWidth()+super.getHeight())*2;
	}
}
