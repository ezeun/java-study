package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();

//		goods.name = "nikon"; 
//		goods.price = 40000;
//		goods.countSold = 10;
//		goods.countStock = 20;
		goods.setName("nikon");
		goods.setPrice(40000);
		goods.setCountSold(10);
		goods.setCountStock(20);
		
		System.out.println("상품이름: " + goods.getName() + ", "
				+ "가격: " + goods.getPrice() + ", "
				+ "판매량: " + goods.getCountSold() + ", "
				+ "재고량: " + goods.getCountStock());
		
		System.out.println(goods.getClass());
		
		goods.printInfo();
		
		//정보은닉(객체의 상태를 보호)
		
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		System.out.println(Goods.countOfGoods);
	}

}
