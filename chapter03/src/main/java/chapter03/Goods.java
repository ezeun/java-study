package chapter03;

public class Goods {
	
	public static int countOfGoods = 0;
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods() {
		countOfGoods++;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price<0) price=0;
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	public void printInfo() {
		System.out.println("상품이름: " + this.name + ", "
		+ "가격: " + this.price + ", "
		+ "판매량: " + this.countSold + ", "
		+ "재고량: " + this.countStock);		
	}
}
