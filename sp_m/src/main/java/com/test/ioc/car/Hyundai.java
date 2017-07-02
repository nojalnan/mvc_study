package com.test.ioc.car;

public class Hyundai implements Maker{
		
		private Car car;
		
		public Hyundai(){}
		public Car sell(Money money){	
			Car car = new Car("YF소나타");
			System.out.println(car.getName() + " " + money.getAmt() + "만원에  현대차 팔았다!");
			return car;
		}
		
	
}
