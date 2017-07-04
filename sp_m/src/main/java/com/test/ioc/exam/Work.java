package com.test.ioc.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class Work {

	public Work(){

	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ioc4.xml");
		Working dev = (Working) context.getBean("working");
		dev.work();

	}
}
