package prob05;
//반복문을이용하여369게임에서박수를쳐야하는경우의수를순서대로화면에출력해보세요.(1~100)

public class Sol05 {
	public static void main(String[] args) {

		for(int i=1; i<=100; i++) {
			if(i%10==3 || i%10==6 || i%10==9 || i/10==3 || i/10==6 || i/10==9) {
				System.out.print(i+" ");
				if(i%10==3 || i%10==6 || i%10==9) System.out.print("짝");
				if(i/10==3 || i/10==6 || i/10==9) System.out.print("짝");
				System.out.println();
			}
		}
	}
}
