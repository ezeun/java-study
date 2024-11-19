package prob03;
/*숫자를입력받아서아래와같은실행결과가나타나도록Sol03클래스의main메소드를완성하세요.
1. 입력받은숫자가홀수인경우에는,0부터입력값까지홀수의합을출력합니다.
ex) 입력이7이면16을출력(1+3+5+7=16)
2. 입력받은숫자가짝수인경우에는,0부터입력값까지짝수의합을출력합니다.
ex) 입력이10이면30을출력(2+4+6+8+10=30)*/

import java.util.Scanner;

public class Sol03 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("수를 입력하세요: ");
			int x = sc.nextInt();
			System.out.println("결과값: ");
			
			int ans=0;
			if(x%2==1) {
				for(int i=0; i<=x; i++) {
					if(i%2==1) ans+=i;
				}
			}
			else {
				for(int i=0; i<=x; i++) {
					if(i%2==0) ans+=i;
				}
			}
			System.out.println(ans);
		}
	}
}
