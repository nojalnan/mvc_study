package test.biz.tj.ch01;

public class OrderManger {
	private Hyundai hy;
	
	public OrderManger(){
		this.hy = new Hyundai();
	}
	
	public void order(){
		Car car = hy.sell(new Money(100));
	}
}
