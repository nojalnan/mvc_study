package test.biz.tj.ch04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("samsung")
public class SamSung implements CarMaker{
	@Autowired
	private Car car;
	
	public SamSung(){}
	public Car sell(Money money){
		System.out.println("삼성 차팔았다!");
		Car car = new Car("QM5");
		return car;
	}
}
