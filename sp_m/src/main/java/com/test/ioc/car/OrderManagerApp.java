package com.test.ioc.car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderManagerApp {

	public static void main(String[] args){
//		FileSystemResource fsr = new FileSystemResource("src/main/resources/ioc.xml");
//		BeanFactory factory = new XmlBeanFactory(fsr);
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:ioc3.xml");
		OrderManger om = (OrderManger)factory.getBean("orderManager");
		om.order();
		
	}
}
