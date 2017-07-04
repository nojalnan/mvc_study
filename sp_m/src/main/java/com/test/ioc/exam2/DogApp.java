package com.test.ioc.exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DogApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dog/dog.xml", "dog/dog_bean.xml"});
		DogManager dogManager = (DogManager) context.getBean("dogManager");
		dogManager.bark();
	}

}
