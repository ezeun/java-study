package chapter03;

import mypackage.Goods2;

public class DiscountGoods2 extends Goods2 {
	float discountRate = 0.5f; //디폴트는 double
	
	public float getDiscountPrice() {
		//protected는 자식에서 접근 가능
		return discountRate * price;
	}
}
