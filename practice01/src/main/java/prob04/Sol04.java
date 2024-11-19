package prob04;
//문자열을입력받아아래와같은실행결과가되도록Sol04클래스의main메소드를완성하세요.
//입력받은문자열을한글자씩증가시키며출력하는프로그램입니다.
/*Bat Man
B
Ba
Bat
Bat 
Bat M
Bat Ma
Bat Man*/

import java.util.Scanner;

public class Sol04 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.nextLine();
		
		for(int i=0; i<str.length(); i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(str.charAt(j));
			}
			System.out.println();
		}
		
		
		scanner.close();
	}
}