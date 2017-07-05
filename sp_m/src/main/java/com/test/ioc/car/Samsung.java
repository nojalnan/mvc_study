package com.test.ioc.car;

import org.springframework.stereotype.Service;

@Service
public class Samsung implements Maker{

		private Car car;
		
		public Samsung(){}
		public Car sell(Money money){
			System.out.println("삼성차 팔았다!");
			Car car = new Car("QM5");
			return car;
		}
	
}
