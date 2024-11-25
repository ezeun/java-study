package prob01;

public class PrinterTest {

	public static void main(String[] args) {
		Printer printer = new Printer();

		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동");
		
		//배열말고 가변파라미터 사용해서 해결해보기
		System.out.println(printer.sum(1,2));
		System.out.println(printer.sum(1,2,3));
		System.out.println(printer.sum(1,2,3,4,5,6,7,8));
		System.out.println(printer.sum(1,2,3,4,5,6,7,8,9,10));
		
		printer.println(10, "홍길동", true, 5.7);
	}
}