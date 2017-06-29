package com.test.ioc.exam;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value=2)
public class Designer implements Emp{
	
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("디자이너가 일을 합니다");
	}
	
	

}
