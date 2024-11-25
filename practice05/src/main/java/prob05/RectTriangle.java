package prob05;

public class RectTriangle extends Shape{

	public RectTriangle(double width, double height) {
		super(width, height);
	}
	
	@Override
	double getArea() {
		return super.getWidth()*super.getHeight()*0.5;
	}


	@Override
	double getPerimeter() {
		double w = super.getWidth();
		double h = super.getHeight();
		return w+h+Math.sqrt(w*w+h*h);
	}

}
