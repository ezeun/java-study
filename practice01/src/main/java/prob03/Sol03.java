package prob03;

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
