package com.test.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
	
	@Service("samsung")
	public class Samsung implements Maker{
		@Autowired
		private Car car;
		
		public Samsung(){}
		public Car sell(Money money){
			System.out.println("삼성차 팔았다!");
			Car car = new Car("QM5");
			return car;
		}
	
}
