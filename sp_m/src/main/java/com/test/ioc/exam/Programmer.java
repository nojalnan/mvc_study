package com.test.ioc.exam;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value=1)
public class Programmer implements Emp{

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("개발자가 일을 합니다");
	}
	
	

}
