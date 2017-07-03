package com.test.ioc.exam;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Service;

@Service("designer")
public class Designer implements MethodReplacer{

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		return "프로그래머를 호출했는데 디자이너가 나오네여";
	}
	
//	@Override
//	public void work() {
//		// TODO Auto-generated method stub
//		System.out.println("디자이너가 일을 합니다");
//	}
//
//	@Override
//	public void gotoOffice() {
//		// TODO Auto-generated method stub
//		System.out.println("디자이너가 출근을 합니다");
//	}
//
//	@Override
//	public void getoffWork() {
//		// TODO Auto-generated method stub
//		System.out.println("디자이너가 출근을 합니다");
//	}
	
	

}
