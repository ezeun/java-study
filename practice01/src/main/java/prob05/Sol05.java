package prob05;

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
