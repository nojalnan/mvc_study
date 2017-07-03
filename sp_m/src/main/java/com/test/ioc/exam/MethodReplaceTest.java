package com.test.ioc.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MethodReplaceTest {	
	Programmer programmer;
	
	public void setEmp(Programmer programmer) {
		this.programmer = programmer;
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ioc5.xml");
		MethodReplaceTest test = (MethodReplaceTest) context.getBean("methodReplaceTest");
		System.out.println(test.programmer.work());
	}
}
