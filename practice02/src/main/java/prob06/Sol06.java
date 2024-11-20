package prob06;

import java.util.Random;
import java.util.Scanner;

public class Sol06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);


		while(true) {

			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt(100) + 1;
			
			System.out.println("수를 결정하였습니다. 맞추어 보세요: ");
			
			int left=1, right=100;
			int cnt=1;
			
			while(true) { //게임 진행
				System.out.println(left + "-" + right);
				System.out.print(cnt+">>");
				cnt+=1;
				
				int cmd = scanner.nextInt();
				
				if(cmd<correctNumber) {
					left=cmd;
					System.out.println("더 높게");
				}
				else if(cmd>correctNumber) {
					right = cmd;
					System.out.println("더 낮게");
				}
				else if(cmd==correctNumber) {
					System.out.println("맞췄습니다.");
					break;
	
				}	
			}
			
			//새 게임 여부 확인하기
			System.out.print("다시 하겠습니까(y/n)>>");
			String answer = scanner.next();
			if("y".equals(answer) == false) {
				break;
			}

		}
		
	}
}