package test.biz.tj.ch02;

public class Hyundai implements CarMaker{

	public Hyundai(){}
	public Car sell(Money money){
		System.out.println("현대 차팔았다!");
		Car car = new Car("YF소나타");
		return car;
	}
}
