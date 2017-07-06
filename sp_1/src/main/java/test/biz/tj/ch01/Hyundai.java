package test.biz.tj.ch01;

public class Hyundai {

	public Hyundai(){}
	public Car sell(Money money){
		System.out.println("차팔았다!");
		Car car = new Car("YF소나타");
		return car;
	}
}
