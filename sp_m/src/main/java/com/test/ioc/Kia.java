package com.test.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
	
	@Service("kia")
	public class Kia implements Maker{
		@Autowired
		private Car car;
		
		public Kia(){}
		public Car sell(Money money){
			Car car = new Car("K5");
			System.out.println("기아차 팔았다!");
			return car;
		}
	
}
