package com.test.ioc;

public class Kia implements Maker {

	public Kia(){}
	public Car sell(Money money){
		Car car = new Car("k5");
		System.out.println(car.getName() + " 말고 BMW 타고 싶다!!");
		return car;
	}
}
