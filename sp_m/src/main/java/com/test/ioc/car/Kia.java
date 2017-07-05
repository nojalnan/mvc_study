package com.test.ioc.car;

import org.springframework.stereotype.Service;

@Service
public class Kia implements Maker{

		private Car car;
		
		public Kia(){}
		public Car sell(Money money){
			Car car = new Car("K5");
			System.out.println("기아차 팔았다!");
			return car;
		}
	
}
