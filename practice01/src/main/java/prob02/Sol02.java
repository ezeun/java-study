package prob02;
//출력값이다음과같도록Sol02클래스의main메소드를완성하십시오.
/*1 2 3 4 5 6 7 8 9 10 
1 2 3 4 5 6 7 8 9 10 11 
1 2 3 4 5 6 7 8 9 10 11 12 
1 2 3 4 5 6 7 8 9 10 11 12 13 
1 2 3 4 5 6 7 8 9 10 11 12 13 14 
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 */
public class Sol02 {
	public static void main(String[] args) {
		
		for(int i=10; i<=18; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	
	}
}