package prob01;
//java.util.Scanner 클래스를 이용하여 입력된수가3의배수인지판별하는프로그램을작성하세요.

import java.util.Scanner;

public class Sol01 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("수를 입력하세요: ");
		int x = scanner.nextInt();
		
		if(x%3==0) System.out.println("3의 배수입니다.");
		else  System.out.println("3의 배수가 아닙니다.");
		
		scanner.close();
	}
}