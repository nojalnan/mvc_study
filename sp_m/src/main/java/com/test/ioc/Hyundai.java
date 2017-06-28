package com.test.ioc;

public class Hyundai implements Maker {

	public Hyundai(){}
	public Car sell(Money money){
		System.out.println("현대차 팔았다!");
		Car car = new Car("YF소나타");
		return car;
	}
}
