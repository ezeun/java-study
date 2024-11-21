package mypackage;

public class Goods2 {
	public String name; //모든 접근이 가능 (접근 제한 없음)
	protected int price; //같은 패키지 + 자식 클래스 접근이 가능
	private int countSold; //클래스 내부에서만 접근이 가능
	int countStock; //같은 패키지에서만(default)
	
	public void m() {
		//private는 내부에서만 접근이 가능함
		countSold = 10;
	}
}
