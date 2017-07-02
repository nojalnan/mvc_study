package com.test.ioc.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class OrderManagerApp {

	public static void main(String[] args){
//		FileSystemResource fsr = new FileSystemResource("src/main/resources/ioc.xml");
//		BeanFactory factory = new XmlBeanFactory(fsr);
//		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:ioc4.xml");
//		OrderManger om = (OrderManger)factory.getBean("orderManager");
//		om.order();
		
//		Money money = new Money(1000);
//		
//		Hyundai hy = new Hyundai();	
//		hy.sell(money);
//		
//		Samsung ss= new Samsung();
//		ss.sell(money);
//		
//		Kia kia= new Kia();
//		kia.sell(money);
		
		OrderManger om = new OrderManger(); //@Service("orderManager") 
		Maker mk = new Hyundai(); //@Autowired @Qualifier("hyundai")
		Maker mk2 = new Samsung(); //@Autowired @Qualifier("samsung")
		om.setMaker(mk);
		om.setMaker2(mk2);
		om.order();
		
	}
}
