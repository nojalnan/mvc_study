package test.biz.tj.ch02;

public class SamSung implements CarMaker{

	public SamSung(){}
	public Car sell(Money money){
		System.out.println("삼성 차팔았다!");
		Car car = new Car("QM5");
		return car;
	}
}
