package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		
		System.out.println("some code1...");
		
		try {
			
			System.out.println("some code2...");
			int result = (1+2+3)/b; //예외 발생
			System.out.println("some code3...");
			
		}catch(ArithmeticException e) { //예외 처리
			//catch문 비워놓지 말고 이거라도 해야함
			//e.printStackTrace();
			
			System.out.println("some code4...");
			//1. 로깅
			System.out.println("error: " + e);
			
			//2. 사과
			System.out.println("미안합니다...");
			
			//3. 정상종료
			return;
			
		} finally { //예외든 아니든 실행됨
			System.out.println("지원정리: ex) close file, socket, db connection");
		}
		System.out.println("some code5...");
	}

}
