package test.biz.tj.ch05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("hyundai")
public class Hyundai implements CarMaker{
	@Autowired
	private Car car;
	
	public Hyundai(){}
	public Car sell(Money money){
		System.out.println("현대 차팔았다!");
		Car car = new Car("YF소나타");
		return car;
	}
}
