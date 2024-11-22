package paint;

public class PaintApp {

	public static void main(String[] args) {
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(20);

		// point1.show();

		draw(point1);
		Point point2 = new Point(100, 200);
		// point2.show(true);
		draw(point2);
		point2.show(false);

		ColorPoint point3 = new ColorPoint(50, 100, "red");
//		point3.setX(50);	
//		point3.setY(100);
//		point3.setColor("red");
		draw(point3);

		draw(new Triangle());
		draw(new Rectangle());
		draw(new Circle());
		draw(new GraphicText("안녕"));
		
		// instanceof 연산자
		Circle c = new Circle();
		System.out.println(c instanceof Circle);
		System.out.println(c instanceof Shape);
		// 오류: 연산자 우측항이 클래스인 경우,
		//		좌측항의 레퍼런스 타입의 hierachy(계층)의 상하위만 사용할 수 있음
		// System.out.println(c instanceof Point);
		
		Shape s = new Circle();
		System.out.println(c instanceof Object);
		System.out.println(s instanceof Drawable);
		System.out.println(s instanceof Circle);
		
		// 연산자 우측항이 인터페이스인 경우
		// hierachy 상관없이 연산자를 사용할 수 있음
		System.out.println(c instanceof Drawable);
		System.out.println(c instanceof Runnable);
		
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}

//	public static void drawPoint(Point point) {
//		point.show();
//	}
//	
//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}

//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
//	
//	public static void drawRectangle(Rectangle rectangle) {
//		rectangle.draw();
//	}

}
