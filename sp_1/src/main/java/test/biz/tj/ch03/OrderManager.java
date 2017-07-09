package test.biz.tj.ch03;

public class OrderManager {
	private CarMaker cm;
	
	public OrderManager(){}
	
	public void order(){
		Car car = cm.sell(new Money(100));
	}
	
	public void setMaker(CarMaker cm){
		this.cm= cm;
	}
}
