package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();
		
		Class klass = point.getClass(); //relection 
		System.out.println(klass);

		System.out.println(point.hashCode()); //address 기반의 해싱값 
		// -> address도 아니고 reference값도 아님
		
		System.out.println(point.toString()); //getClass().toString() + "@" + hashCode()
		System.out.println(point);
	}

}
