package chapter03;

public class SwapTest02 {

	public static void main(String[] args) {
		int i = 10;
		int j = 20;
		System.out.println(i+", "+j);
		
		swap(i,j); //값으로 넘길때는 copy해서 넘김
		
		System.out.println(i+", "+j);
	}

	private static void swap(int m, int n) {
		int temp = m;
		m=n;
		n=temp;
	}
}
