package chapter04;

public class ObjectTest02 {

	public static void main(String[] args) {
		Point p1 = new Point(10,20);
		Point p2 = new Point(10,20);
		Point p3 = p1;
		
		// == : 두 객체의 동일성
		System.out.println(p1 == p2);
		System.out.println(p2 == p3);
		System.out.println(p1 == p3);
		System.out.println();
		
		// equals : 두 객체의 동질성(내용 비교) -> object는 기본적으로 == 비교
		//			부모 클래스 Object의 기본 구현은 동일성(==) 비교와 같음
		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p3));
		System.out.println(p1.equals(p3));
		//-> 내용 비교를 하게끔 equals를 overriding
	}

}
