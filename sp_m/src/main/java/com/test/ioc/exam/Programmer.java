package com.test.ioc.exam;

import org.springframework.stereotype.Service;

@Service("programmer")
public class Programmer implements Emp {

	@Override
	public String work() {
		// TODO Auto-generated method stub
		System.out.println("개발자가 일을 합니다");
		return "개발자가 일을 합니다";
	}

	@Override
	public void gotoOffice() {
		// TODO Auto-generated method stub
		System.out.println("개발자가 출근을 합니다");
	}

	@Override
	public void getoffWork() {
		// TODO Auto-generated method stub
		System.out.println("개발자가 출근을 합니다");
	}

}
