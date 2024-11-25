package prob01;

public class Printer {
//	public static void println(int x) {
//		System.out.println(x);
//	}
//	public static void println(boolean x) {
//		System.out.println(x);
//	}
//	public static void println(double x) {
//		System.out.println(x);
//	}
//	public static void println(String x) {
//		System.out.println(x);
//	}
	
	//Generic을 이용하여 해결해보자.
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.print(t + " ");
		}
		System.out.println();
	}

	public int sum(Integer... nums) {
		// nums가 파라미터를 배열로 받음
		int s=0;
		for(Integer n : nums) {
			s += n;
		}
		return s;
	}
}
