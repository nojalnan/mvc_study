package test.biz.tj.ch02;

public class OrderManager {
	private CarMaker cm;
	
	public OrderManager(){
		this.cm = new SamSung();
	}
	
	public void order(){
		Car car = cm.sell(new Money(100));
	}
}
