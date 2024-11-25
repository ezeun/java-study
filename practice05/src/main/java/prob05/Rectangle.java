package prob05;

public class Rectangle extends Shape implements Resizable {

	public Rectangle(double width, double height) {
		super(width, height);
	}

	@Override
	public void resize(double rate) {
		super.setWidth(super.getWidth()*rate);
		super.setHeight(super.getHeight()*rate);
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
